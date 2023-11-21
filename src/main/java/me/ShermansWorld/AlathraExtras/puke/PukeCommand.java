package me.ShermansWorld.AlathraExtras.puke;

import com.palmergames.bukkit.towny.utils.NameUtil;
import me.ShermansWorld.AlathraExtras.AlathraExtras;
import me.ShermansWorld.AlathraExtras.Helper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class PukeCommand implements CommandExecutor, TabCompleter {

    static Map<Player, Puke> active = new HashMap<>();

    static int[] bukkitId = new int[1];

    public PukeCommand(final AlathraExtras plugin) {
        plugin.getCommand("puke").setExecutor(this);
        plugin.getCommand("puke").setTabCompleter(this);

        //tick loop
        bukkitId[0] = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(AlathraExtras.getInstance(),
            () -> {
//                    Bukkit.getLogger().info("doing puke loop");
                for (Player p : active.keySet()) {
                    Puke puke = active.get(p);
                    int loops = (int) Math.floor(puke.getIntensity());
                    double remainder = puke.getIntensity() - loops;
//                        Bukkit.getLogger().info("Intensity: " + puke.getIntensity());
//                        Bukkit.getLogger().info("Loops: " + loops);
//                        Bukkit.getLogger().info("Remainder: " + remainder);
                    for (int i = 0; i < loops; i++) {
                        doPuke(puke);
                    }
                    if (remainder > 0.0) {
                        if (remainder > new Random().nextDouble()) {
                            doPuke(puke);
                        }
                    }
                }
            }, 0L, 1);
    }

    private void doPuke(Puke puke) {
//        Bukkit.getLogger().info("puking for " + puke.getTarget().getName());
        //decrement duration
        puke.decrDura();
        //check remaining time
        if (puke.getDuration() < 0) {
            active.remove(puke.getTarget());
            return;
        }

        //item
        ItemStack puking = new ItemStack(Material.NETHERITE_BLOCK);
        if (puke.getItem() != null) {
            puking.setType(puke.getItem());
        } else {
            puking.setType(ramdomMat());
        }


//        Bukkit.getLogger().info("puking item " + puking.toString());

        //calc velocity, stolen from brewery
        Location loc = puke.getTarget().getLocation();
        loc.setY(loc.getY() + 1.1);
        loc.setPitch((float) (loc.getPitch() - puke.getYspread() + (new Random().nextDouble() * (puke.getYspread() * 2.0))));
        loc.setYaw((float) (loc.getYaw() - puke.getXzspread() + (new Random().nextDouble() * (puke.getXzspread() * 2.0))));
        Vector direction = loc.getDirection();
        direction.multiply(puke.getSpeed());
        loc.add(direction);

        //spawn item
        Item item = puke.getTarget().getWorld().dropItem(loc, puking);
        item.setPickupDelay(32767);
        item.setCustomName(String.valueOf(new Random().nextInt(999999999)));
        item.setCustomNameVisible(false);
        item.setTicksLived(5800);
        item.setVelocity(direction);
        item.addScoreboardTag("puke");
        item.addScoreboardTag("puke2");
    }


    /**
     * @param sender  command sender
     * @param command command
     * @param s       string
     * @param args    args
     * @return success
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player target = null;
        Material material = null;
        int time = 100;
        double intensity = 2.0;
        double xzspread = 20.0;
        double yspread = 12.0;
        double speed = 0.5;
        boolean doAll = false;
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(Helper.Chatlabel() + Helper.color("&r/puke (amount) (rate) (material) (player) (speed) (xzSpread) (ySpread)"));
                return true;
            }
        }
        if (args.length >= 2) {
            try {
                time = Integer.parseInt(args[0]);
                intensity = Double.parseDouble(args[1]);

                //cap
                if (time > 3000) time = 3000;
                if (time < 1) time = 1;
                if (intensity > time) intensity = time;
                if (intensity <= 0.0) intensity = 1.0;

                if (args.length >= 3) {
                    material = Material.getMaterial(args[2]);
                    if (args[1].equalsIgnoreCase("RANDOM")) {
                        material = null;
                    } else {
                        if (args.length >= 4) {
                            if (args[3].equalsIgnoreCase("**")) {
                                doAll = true;
                                if (args.length >= 5) {
                                    speed = Double.parseDouble(args[4]);
                                    if (args.length >= 6) {
                                        xzspread = Double.parseDouble(args[5]);
                                        if (args.length >= 7) {
                                            yspread = Double.parseDouble(args[6]);
                                        }
                                    }
                                }
                            } else {
                                Player p = Bukkit.getPlayer(args[3]);
                                if (p != null) {
                                    target = p;
                                    if (args.length >= 5) {
                                        speed = Double.parseDouble(args[4]);
                                        if (args.length >= 6) {
                                            xzspread = Double.parseDouble(args[5]);
                                            if (args.length >= 7) {
                                                yspread = Double.parseDouble(args[6]);
                                            }
                                        }
                                    }
                                } else {
                                    sender.sendMessage(Helper.Chatlabel() + Helper.color("&cNot a valid player!"));
                                    return true;
                                }
                            }
                        } else {
                            if (sender instanceof Player p) {
                                target = p;
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                sender.sendMessage(Helper.Chatlabel() + Helper.color("&cNot a valid number!"));
                return true;
            }
        }
        //do for all **
        if (doAll) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Puke puke = new Puke(p, time, intensity, material, speed, xzspread, yspread);
                active.put(p, puke);
            }
        } else {
            if (target == null) {
                if (sender instanceof Player player) {
                    target = player;
                } else {
                    sender.sendMessage(Helper.Chatlabel() + Helper.color("&cMust define a player from console."));
                    return true;
                }
            }

            //create and store the puke data
            Puke puke = new Puke(target, time, intensity, material, speed, xzspread, yspread);
            active.put(target, puke);
        }


        //create the tick loop if needed


        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length > 1) {
            if (args.length > 2) {
                if (args.length > 3) {
                    if (args.length > 4) {
                        return Collections.emptyList();
                    } else {
                        List<String> players = new ArrayList<>();
                        players.add("**");
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            players.add(p.getName());
                        }
                        return NameUtil.filterByStart(players, args[3]);
                    }
                } else {
                    List<String> mats = new ArrayList<>();
                    mats.add("RANDOM");
                    for (Material m : Material.values()) {
                        mats.add(m.name());
                    }
                    return NameUtil.filterByStart(mats, args[2]);
                }
            } else {
                return List.of(new String[]{String.valueOf(2.0)});
            }
        } else {
            return List.of(new String[]{String.valueOf(100), "help"});
        }
    }

    private Material ramdomMat() {
        return Material.values()[new Random().nextInt(Material.values().length)];
    }

    protected static class Puke {
        private final Player target;
        private int duration;
        private final Material item;
        private final double intensity;
        private final double speed;
        private final double xzspread;
        private final double yspread;

        protected Puke(Player target, int dura, double intensity, Material item, double speed, double xzspread, double yspread) {
            this.target = target;
            this.duration = dura;
            this.item = item;
            this.intensity = intensity;
            this.speed = speed;
            this.xzspread = xzspread;
            this.yspread = yspread;
        }

        protected void decrDura() {
            this.duration--;
        }

        protected Player getTarget() {
            return target;
        }

        protected int getDuration() {
            return duration;
        }

        protected Material getItem() {
            return item;
        }

        protected double getIntensity() {
            return intensity;
        }

        protected double getSpeed() {
            return speed;
        }

        protected double getXzspread() {
            return xzspread;
        }

        protected double getYspread() {
            return yspread;
        }
    }
}
