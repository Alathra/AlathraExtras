package me.ShermansWorld.AlathraExtras.customroles;

import me.ShermansWorld.AlathraExtras.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static me.ShermansWorld.AlathraExtras.Main.economy;

public class MercCommand implements CommandExecutor {

    public static Map<String, Object> ActiveMercRequests = new HashMap<String, Object>();

    public MercCommand(final Main plugin) {
        plugin.getCommand("mercenary").setExecutor((CommandExecutor) this);
        plugin.getCommand("mercenary").setTabCompleter(new CustomRoleTabCompletion());
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        //LOAD PLAYER DATA
        UUID pID = p.getUniqueId();
        Map pData = (Map) Main.DataManager.getData(pID);
        //Bukkit.getLogger().info(Arrays.asList(pData).toString());

        if(!p.hasPermission("AlathraExtras.UseRoles")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return false;
        }
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            p.sendMessage(ChatColor.RED + "! "+ ChatColor.RESET + ChatColor.GOLD + "---- Mercenary Help ----");
            p.sendMessage(ChatColor.RED + "! " + ChatColor.GREEN + "/mercenary hire <player> <price>");
            if ((Boolean) pData.get("MercPermission")) {
                p.sendMessage(ChatColor.RED + "! " + ChatColor.GREEN + "/mercenary accept <player>");
                p.sendMessage(ChatColor.RED + "! " + ChatColor.GREEN + "/mercenary decline <player>");
            }
            if (p.hasPermission("AlathraExtras.Admin")) {
                p.sendMessage(ChatColor.RED + "! " + ChatColor.GREEN + "/mercenary add <player>");
                p.sendMessage(ChatColor.RED + "! " + ChatColor.GREEN + "/mercenary remove <player>");
            }
            return false;
        }
        else if(args[0].equalsIgnoreCase("hire")) {
            // Valid number of arguments
            if (args.length < 3) {
                p.sendMessage(ChatColor.RED + "/mercenary hire <player> <price>");
                return false;
            }

            // Target Validator
            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            // Number Validator
            double val = 0;
            try {
                val = Double.parseDouble(args[2]);
            } catch (Exception e) {
                p.sendMessage(ChatColor.RED + "Please enter a valid price.");
                return false;
            }

            // Minimum Price
            if (val < 10000) {
                p.sendMessage(ChatColor.DARK_RED + "You must comply with the minimum pricing of the server.");
                return false;
            }

            // Don't have enough money.
            double pVal = economy.getBalance(p);
            if (pVal < val) {
                p.sendMessage(ChatColor.DARK_RED + "You do not have a high enough balance.");
                return false;
            }


            //
            String targetStrID = target.getUniqueId().toString();
            Map TargetRequests = null;

            Bukkit.getLogger().info(String.valueOf(ActiveMercRequests.containsKey(targetStrID)));
            if (ActiveMercRequests.containsKey(targetStrID)) {
                TargetRequests = (Map) ActiveMercRequests.get(targetStrID);
            } else {
                TargetRequests = new HashMap<String, Object>();
            }

            if (TargetRequests.containsKey(pID.toString())) {
                p.sendMessage(ChatColor.RED + "You already have a pending contract.");
                return false;
            }

            Map targetData = (Map) Main.DataManager.getData(target.getUniqueId());

            if (targetData.containsKey(pID.toString())) {
                p.sendMessage(ChatColor.RED + "You already have a mercenary contract with this user.");
                return false;
            }
            if (!(Boolean) targetData.get("MercPermission")) {
                p.sendMessage(ChatColor.RED + "This user is not a mercenary.");
                return false;
            }

            // Adding request to pending contracts
            Map contractData = new HashMap<String, String>();
            contractData.put("Value", val);
            TargetRequests.put(pID.toString(), contractData);
            ActiveMercRequests.put(targetStrID, TargetRequests);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "You have requested a contract with " + target.getDisplayName() + " for " + ChatColor.YELLOW + economy.format(val) + ".");
            target.sendMessage(target.getDisplayName() + ChatColor.GREEN + " has requested a contract worth " + ChatColor.YELLOW + economy.format(val) + ".");
            Main.logger.log("User " + p.getName() + " requested mercenary work from " + p.getName() + ", value " + val);
        }
        else if (args[0].equalsIgnoreCase("accept")) {
            // Valid number of arguments
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "/mercenary accept <player>");
                return false;
            }

            // Checks and defining target
            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            Map MercRequests = (Map) ActiveMercRequests.get(pID.toString());
            if (MercRequests == null) {
                p.sendMessage(ChatColor.RED + "You do not have any pending contracts.");
                return false;
            }

            if(MercRequests.isEmpty() || !MercRequests.containsKey(target.getUniqueId().toString())) {
                p.sendMessage(ChatColor.RED + "This player has not made any requests.");
                return false;
            }
            Map Request = (Map) MercRequests.get(target.getUniqueId().toString());


            if (!(Boolean) pData.get("MercPermission")) {
                p.sendMessage("You don't have merc perms?");
                return false;
            }

            Map Contracts = (Map) pData.get("Contracts");
            if (Contracts.containsKey(target.getUniqueId().toString())) {
                p.sendMessage(ChatColor.RED + "You already have a contract with this person.");
                return false;
            }

            // Adds contract to userdata
            Map ContractData = new HashMap<String, Object>();
            ContractData.put("Type", "Merc");
            ContractData.put("Value", Request.get("Value"));
            Contracts.put(target.getUniqueId().toString(), ContractData);

            Main.DataManager.editData(pID, "Contracts", Contracts);

            // Money Changes
            Double Value = (Double) Request.get("Value");
            economy.withdrawPlayer(target, Value);
            economy.depositPlayer(p, Value);

            // Removes from ActiveMercRequests list
            MercRequests.remove(target.getUniqueId().toString());
            ActiveMercRequests.put(pID.toString(), MercRequests);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "You have " + ChatColor.YELLOW + "accepted " + target.getDisplayName() + ChatColor.GREEN + "'s request.");
            target.sendMessage(ChatColor.GREEN + "Your request to " + p.getDisplayName() + ChatColor.GREEN + " has been "+ ChatColor.YELLOW + "accepted" + ChatColor.YELLOW + ".");
            Main.logger.log("User " + p.getName() + " accepted mercenary work for " + target.getName());
            return true;
        }
        else if (args[0].equalsIgnoreCase("decline") || args[0].equalsIgnoreCase("deny")) {
            // Valid number of arguments
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "/mercenary decline <player>");
                return false;
            }

            //Checks and defining target
            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            Map MercRequests = (Map) ActiveMercRequests.get(pID.toString());
            if (MercRequests == null) {
                p.sendMessage(ChatColor.RED + "You do not have any pending contracts.");
                return false;
            }

            if(MercRequests.isEmpty() || !MercRequests.containsKey(target.getUniqueId().toString())) {
                p.sendMessage(ChatColor.RED + "This player has not made any requests.");
                return false;
            }

            // Removes from ActiveMercRequests list
            MercRequests.remove(target.getUniqueId().toString());
            ActiveMercRequests.put(pID.toString(), MercRequests);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "You have " + ChatColor.RED + "denied " + target.getDisplayName() + ChatColor.GREEN + "'s request.");
            target.sendMessage(ChatColor.GREEN + "Your request to " + p.getDisplayName() + ChatColor.GREEN + " has been "+ ChatColor.RED + "denied" + ChatColor.GREEN + ".");
            Main.logger.log("User " + p.getName() + " declined mercenary work for " + target.getName());
            return true;
        }
        else if (args[0].equalsIgnoreCase("add")) {
            // Valid number of arguments
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "/mercenary add <player>");
                return false;
            }

            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            // Gets data and re-writes
            Map targetData = (Map) Main.DataManager.getData(target.getUniqueId());
            Boolean MercPerm = (Boolean) targetData.get("MercPermission");
            if (MercPerm) {
             p.sendMessage(ChatColor.RED + "This user already has mercenary permissions!");
             return false;
            }
            Main.DataManager.editData(target.getUniqueId(), "MercPermission", true);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "User " + target.getDisplayName() + ChatColor.YELLOW + " may " + ChatColor.GREEN + "accept mercenary work.");
            target.sendMessage(ChatColor.GREEN + "You " + ChatColor.YELLOW + " may now " + ChatColor.GREEN + "accept mercenary work.");
            Main.logger.log("User " + p.getName() + " gave " + target.getName() + " mercenary permissions");
        }
        else if (args[0].equalsIgnoreCase("remove")) {
            // Valid number of arguments
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "/mercenary remove <player>");
                return false;
            }

            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            // Gets data and re-writes
            Map targetData = (Map) Main.DataManager.getData(target.getUniqueId());
            Boolean MercPerm = (Boolean) targetData.get("MercPermission");
            if (!MercPerm) {
                p.sendMessage(ChatColor.RED + "This user has no mercenary permissions!");
                return false;
            }
            Main.DataManager.editData(target.getUniqueId(), "MercPermission", false);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "User " + target.getDisplayName() + ChatColor.RED + " may not " + ChatColor.GREEN + "accept mercenary work.");
            target.sendMessage(ChatColor.GREEN + "You " + ChatColor.RED + " may no longer " + ChatColor.GREEN + "accept mercenary work.");
            Main.logger.log("User " + p.getName() + " removed " + target.getName() + "'s mercenary permissions");
        }
        else if (args[0].equalsIgnoreCase("complete")) {
            // Valid number of arguments
            if (args.length < 2) {
                p.sendMessage(ChatColor.RED + "/mercenary complete <player>");
                return false;
            }

            Player target = Bukkit.getPlayer(args[1]);
            if (!(target instanceof Player)) {
                p.sendMessage(ChatColor.RED + "Please enter a valid player.");
                return false;
            }

            // Removal of contract from userdata
            Map Contracts = (Map) pData.get("Contracts");
            if (!Contracts.containsKey(target.getUniqueId().toString())) {
                p.sendMessage(ChatColor.RED + "You have no contract with this user!");
                return false;
            }
            Contracts.remove(target.getUniqueId().toString());
            Main.DataManager.editData(pID, "Contracts", Contracts);

            // Messaging and logging
            p.sendMessage(ChatColor.GREEN + "You have " + ChatColor.GOLD + "completed " + target.getDisplayName() + ChatColor.GREEN + "'s mercenary contract.");
            target.sendMessage(ChatColor.GREEN + "Your contract with " + p.getDisplayName() + ChatColor.GREEN + " has been "+ ChatColor.GOLD + "completed" + ChatColor.GREEN + ".");
            Main.logger.log("User " + p.getName() + " completed " + target.getName() + "'s mercenary contract.");
        }
        else {
            p.sendMessage(ChatColor.RED + "Unknown sub-command. Do " + ChatColor.YELLOW + "/mercenary help" + ChatColor.RED + " for more info.");
        }

        return false;
    }
}
