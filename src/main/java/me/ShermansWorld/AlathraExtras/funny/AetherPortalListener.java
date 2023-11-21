package me.ShermansWorld.AlathraExtras.funny;

import me.ShermansWorld.AlathraExtras.AlathraExtras;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class AetherPortalListener implements Listener {

    // 1, 2, 3, 4, 5 or 6
    private int placeLocation;
    // 1 or 2
    private int x_or_z;

    // X1 X2 X3 X4
    // X5 A1 A2 X6
    // X7 A3 A4 X8
    // X9 A5 A6 X10
    // X11 X12 X13 X14

    @EventHandler()
    public void onAetherPortalCreate(PlayerBucketEmptyEvent e) {

        if (e.getBucket().equals(Material.WATER_BUCKET)) {
            if (checkValidPositions(e.getBlock())) {
                World world = e.getBlock().getWorld();
                // ~ 6 seconds
                world.playSound(e.getBlock().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 1.0F, 0.25F);
                spawnParticles(e.getBlock());
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        world.playSound(e.getBlock().getLocation(), Sound.ENTITY_GHAST_HURT, 1.0F, 0.25F);
                    }
                }.runTaskLater(AlathraExtras.getInstance(), 100); // After 5 seconds
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Entity entityTNT = world.spawnEntity(e.getBlock().getRelative(0, 1, 0).getLocation(), EntityType.PRIMED_TNT);
                        TNTPrimed primedTNT = (TNTPrimed) entityTNT;
                        primedTNT.setFuseTicks(0);
                        primedTNT.setSource(e.getPlayer());
                        primedTNT.setYield(6F);
                    }
                }.runTaskLater(AlathraExtras.getInstance(), 140); // After 7 seconds
            }
        }
    }

    private void spawnParticles(Block start) {

        Block A1 = null;
        Block A2 = null;
        ;
        Block A3 = null;
        ;
        Block A4 = null;
        ;
        Block A5 = null;
        ;
        Block A6 = null;
        ;
        World world = start.getWorld();

        switch (placeLocation) {
            case 1:
                A1 = start;
                if (x_or_z == 1) {
                    A2 = start.getRelative(1, 0, 0);
                    A3 = start.getRelative(0, -1, 0);
                    A4 = start.getRelative(1, -1, 0);
                    A5 = start.getRelative(0, -2, 0);
                    A6 = start.getRelative(1, -2, 0);
                } else if (x_or_z == 2) {
                    A2 = start.getRelative(0, 0, 1);
                    A3 = start.getRelative(0, -1, 0);
                    A4 = start.getRelative(0, -1, 1);
                    A5 = start.getRelative(0, -2, 0);
                    A6 = start.getRelative(0, -2, 1);
                }
                break;
            case 2:
                A2 = start;
                if (x_or_z == 1) {
                    A1 = start.getRelative(-1, 0, 0);
                    A3 = start.getRelative(-1, -1, 0);
                    A4 = start.getRelative(0, -1, 0);
                    A5 = start.getRelative(-1, -2, 0);
                    A6 = start.getRelative(0, -2, 0);
                } else if (x_or_z == 2) {
                    A1 = start.getRelative(0, 0, -1);
                    A3 = start.getRelative(0, -1, -1);
                    A4 = start.getRelative(0, -1, 0);
                    A5 = start.getRelative(0, -2, -1);
                    A6 = start.getRelative(0, -2, 0);
                }
                break;
            case 3:
                A3 = start;
                if (x_or_z == 1) {
                    A1 = start.getRelative(0, 1, 0);
                    A2 = start.getRelative(1, 1, 0);
                    A4 = start.getRelative(1, 0, 0);
                    A5 = start.getRelative(0, -1, 0);
                    A6 = start.getRelative(1, -1, 0);
                } else if (x_or_z == 2) {
                    A1 = start.getRelative(0, 1, 0);
                    A2 = start.getRelative(0, 1, 1);
                    A4 = start.getRelative(0, 0, 1);
                    A5 = start.getRelative(0, -1, 0);
                    A6 = start.getRelative(0, -1, 1);
                }
                break;
            case 4:
                A4 = start;
                if (x_or_z == 1) {
                    A1 = start.getRelative(-1, 1, 0);
                    A2 = start.getRelative(0, 1, 0);
                    A3 = start.getRelative(-1, 0, 0);
                    A5 = start.getRelative(-1, -1, 0);
                    A6 = start.getRelative(0, -1, 0);
                } else if (x_or_z == 2) {
                    A1 = start.getRelative(0, 1, -1);
                    A2 = start.getRelative(0, 1, 0);
                    A3 = start.getRelative(0, 0, -1);
                    A5 = start.getRelative(0, -1, -1);
                    A6 = start.getRelative(0, -1, 0);
                }
                break;
            case 5:
                A5 = start;
                if (x_or_z == 1) {
                    A1 = start.getRelative(0, 2, 0);
                    A2 = start.getRelative(1, 2, 0);
                    A3 = start.getRelative(0, 1, 0);
                    A4 = start.getRelative(1, 1, 0);
                    A6 = start.getRelative(1, 0, 0);
                } else if (x_or_z == 2) {
                    A1 = start.getRelative(0, 2, 0);
                    A2 = start.getRelative(0, 2, 1);
                    A3 = start.getRelative(0, 1, 0);
                    A4 = start.getRelative(0, 1, 1);
                    A6 = start.getRelative(0, 0, 1);
                }
                break;
            case 6:
                A6 = start;
                if (x_or_z == 1) {
                    A1 = start.getRelative(-1, 2, 0);
                    A2 = start.getRelative(0, 2, 0);
                    A3 = start.getRelative(-1, 1, 0);
                    A4 = start.getRelative(0, 1, 0);
                    A5 = start.getRelative(-1, 0, 0);
                } else if (x_or_z == 2) {
                    A1 = start.getRelative(0, 2, -1);
                    A2 = start.getRelative(0, 2, 0);
                    A3 = start.getRelative(0, 1, -1);
                    A4 = start.getRelative(0, 1, 0);
                    A5 = start.getRelative(0, 0, -1);
                }
                break;
        }

        world.spawnParticle(Particle.SMOKE_LARGE, A1.getLocation(), 120);
        world.spawnParticle(Particle.SMOKE_LARGE, A2.getLocation(), 120);
        world.spawnParticle(Particle.SMOKE_LARGE, A3.getLocation(), 120);
        world.spawnParticle(Particle.SMOKE_LARGE, A4.getLocation(), 120);
        world.spawnParticle(Particle.SMOKE_LARGE, A5.getLocation(), 120);
        world.spawnParticle(Particle.SMOKE_LARGE, A6.getLocation(), 120);

    }

    private boolean checkValidPositions(Block block) {
        if (checkPos1X(block) || checkPos1Z(block) || checkPos2X(block) || checkPos2Z(block) || checkPos3X(block)
            || checkPos3Z(block) || checkPos4X(block) || checkPos4Z(block) || checkPos5X(block) || checkPos5Z(block)
            || checkPos6X(block) || checkPos6Z(block)) {
            return true;
        }
        return false;
    }

    private boolean checkPos1X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-1, 1, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 1, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(1, 1, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(2, 1, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-1, 0, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(2, 0, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-1, -1, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(2, -1, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-1, -2, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(2, -2, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-1, -3, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -3, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(1, -3, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(2, -3, 0));
        // A2
        airBlocks.add(start.getRelative(1, 0, 0));
        // A3
        airBlocks.add(start.getRelative(0, -1, 0));
        // A4
        airBlocks.add(start.getRelative(1, -1, 0));
        // A5
        airBlocks.add(start.getRelative(0, -2, 0));
        // A6
        airBlocks.add(start.getRelative(1, -2, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 1;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos1Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 1, -1));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 1, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 1, 1));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 1, 2));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 0, -1));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 0, 2));
        // X7
        glowstoneBlocks.add(start.getRelative(0, -1, -1));
        // X8
        glowstoneBlocks.add(start.getRelative(0, -1, 2));
        // X9
        glowstoneBlocks.add(start.getRelative(0, -2, -1));
        // X10
        glowstoneBlocks.add(start.getRelative(0, -2, 2));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -3, -1));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -3, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -3, 1));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -3, 2));
        // A2
        airBlocks.add(start.getRelative(0, 0, 1));
        // A3
        airBlocks.add(start.getRelative(0, -1, 0));
        // A4
        airBlocks.add(start.getRelative(0, -1, 1));
        // A5
        airBlocks.add(start.getRelative(0, -2, 0));
        // A6
        airBlocks.add(start.getRelative(0, -2, 1));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 1;
        x_or_z = 2;
        return true;
    }

    private boolean checkPos2X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-2, 1, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(-1, 1, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 1, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(1, 1, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-2, 0, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(1, 0, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-2, -1, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(1, -1, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-2, -2, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(1, -2, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-2, -3, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(-1, -3, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -3, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(1, -3, 0));
        // A1
        airBlocks.add(start.getRelative(-1, 0, 0));
        // A3
        airBlocks.add(start.getRelative(-1, -1, 0));
        // A4
        airBlocks.add(start.getRelative(0, -1, 0));
        // A5
        airBlocks.add(start.getRelative(-1, -2, 0));
        // A6
        airBlocks.add(start.getRelative(0, -2, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 2;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos2Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 1, -2));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 1, -1));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 1, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 1, 1));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 0, -2));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 0, 1));
        // X7
        glowstoneBlocks.add(start.getRelative(0, -1, -2));
        // X8
        glowstoneBlocks.add(start.getRelative(0, -1, 1));
        // X9
        glowstoneBlocks.add(start.getRelative(0, -2, -2));
        // X10
        glowstoneBlocks.add(start.getRelative(0, -2, 1));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -3, -2));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -3, -1));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -3, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -3, 1));
        // A1
        airBlocks.add(start.getRelative(0, 0, -1));
        // A3
        airBlocks.add(start.getRelative(0, -1, -1));
        // A4
        airBlocks.add(start.getRelative(0, -1, 0));
        // A5
        airBlocks.add(start.getRelative(0, -2, -1));
        // A6
        airBlocks.add(start.getRelative(0, -2, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 2;
        x_or_z = 2;
        return true;
    }

    private boolean checkPos3X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-1, 2, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 2, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(1, 2, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(2, 2, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-1, 1, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(2, 1, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-1, 0, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(2, 0, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-1, -1, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(2, -1, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-1, -2, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -2, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(1, -2, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(2, -2, 0));
        // A1
        airBlocks.add(start.getRelative(0, 1, 0));
        // A2
        airBlocks.add(start.getRelative(1, 1, 0));
        // A4
        airBlocks.add(start.getRelative(1, 0, 0));
        // A5
        airBlocks.add(start.getRelative(0, -1, 0));
        // A6
        airBlocks.add(start.getRelative(1, -1, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 3;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos3Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 2, -1));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 2, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 2, 1));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 2, 2));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 1, -1));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 1, 2));
        // X7
        glowstoneBlocks.add(start.getRelative(0, 0, -1));
        // X8
        glowstoneBlocks.add(start.getRelative(0, 0, 2));
        // X9
        glowstoneBlocks.add(start.getRelative(0, -1, -1));
        // X10
        glowstoneBlocks.add(start.getRelative(0, -1, 2));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -2, -1));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -2, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -2, 1));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -2, 2));
        // A1
        airBlocks.add(start.getRelative(0, 1, 0));
        // A2
        airBlocks.add(start.getRelative(0, 1, 1));
        // A4
        airBlocks.add(start.getRelative(0, 0, 1));
        // A5
        airBlocks.add(start.getRelative(0, -1, 0));
        // A6
        airBlocks.add(start.getRelative(0, -1, 1));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 3;
        x_or_z = 2;
        return true;
    }

    private boolean checkPos4X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-2, 2, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(-1, 2, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 2, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(1, 2, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-2, 1, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(1, 1, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-2, 0, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(1, 0, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-2, -1, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(1, -1, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-2, -2, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(-1, -2, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -2, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(1, -2, 0));
        // A1
        airBlocks.add(start.getRelative(-1, 1, 0));
        // A2
        airBlocks.add(start.getRelative(0, 1, 0));
        // A3
        airBlocks.add(start.getRelative(-1, 0, 0));
        // A5
        airBlocks.add(start.getRelative(-1, -1, 0));
        // A6
        airBlocks.add(start.getRelative(0, -1, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 4;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos4Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 2, -2));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 2, -1));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 2, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 2, 1));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 1, -2));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 1, 1));
        // X7
        glowstoneBlocks.add(start.getRelative(0, 0, -2));
        // X8
        glowstoneBlocks.add(start.getRelative(0, 0, 1));
        // X9
        glowstoneBlocks.add(start.getRelative(0, -1, -2));
        // X10
        glowstoneBlocks.add(start.getRelative(0, -1, 1));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -2, -2));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -2, -1));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -2, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -2, 1));
        // A1
        airBlocks.add(start.getRelative(0, 1, -1));
        // A2
        airBlocks.add(start.getRelative(0, 1, 0));
        // A3
        airBlocks.add(start.getRelative(0, 0, -1));
        // A5
        airBlocks.add(start.getRelative(0, -1, -1));
        // A6
        airBlocks.add(start.getRelative(0, -1, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 4;
        x_or_z = 2;
        return true;
    }

    private boolean checkPos5X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-1, 3, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 3, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(1, 3, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(2, 3, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-1, 2, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(2, 2, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-1, 1, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(2, 1, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-1, 0, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(2, 0, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-1, -1, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -1, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(1, -1, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(2, -1, 0));
        // A1
        airBlocks.add(start.getRelative(0, 2, 0));
        // A2
        airBlocks.add(start.getRelative(1, 2, 0));
        // A3
        airBlocks.add(start.getRelative(1, 1, 0));
        // A4
        airBlocks.add(start.getRelative(1, 1, 0));
        // A6
        airBlocks.add(start.getRelative(1, 0, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 5;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos5Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 3, -1));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 3, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 3, 1));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 3, 2));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 2, -1));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 2, 2));
        // X7
        glowstoneBlocks.add(start.getRelative(0, 1, -1));
        // X8
        glowstoneBlocks.add(start.getRelative(0, 1, 2));
        // X9
        glowstoneBlocks.add(start.getRelative(0, 0, -1));
        // X10
        glowstoneBlocks.add(start.getRelative(0, 0, 2));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -1, -1));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -1, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -1, 1));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -1, 2));
        // A1
        airBlocks.add(start.getRelative(0, 2, 0));
        // A2
        airBlocks.add(start.getRelative(0, 2, 1));
        // A3
        airBlocks.add(start.getRelative(0, 1, 1));
        // A4
        airBlocks.add(start.getRelative(0, 1, 1));
        // A6
        airBlocks.add(start.getRelative(0, 0, 1));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 5;
        x_or_z = 2;
        return true;
    }

    private boolean checkPos6X(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(-2, 3, 0));
        // X2
        glowstoneBlocks.add(start.getRelative(-1, 3, 0));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 3, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(1, 3, 0));
        // X5
        glowstoneBlocks.add(start.getRelative(-2, 2, 0));
        // X6
        glowstoneBlocks.add(start.getRelative(1, 2, 0));
        // X7
        glowstoneBlocks.add(start.getRelative(-2, 1, 0));
        // X8
        glowstoneBlocks.add(start.getRelative(1, 1, 0));
        // X9
        glowstoneBlocks.add(start.getRelative(-2, 0, 0));
        // X10
        glowstoneBlocks.add(start.getRelative(1, 0, 0));
        // X11
        glowstoneBlocks.add(start.getRelative(-2, -1, 0));
        // X12
        glowstoneBlocks.add(start.getRelative(-1, -1, 0));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -1, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(1, -1, 0));
        // A1
        airBlocks.add(start.getRelative(-1, 2, 0));
        // A2
        airBlocks.add(start.getRelative(0, 2, 0));
        // A3
        airBlocks.add(start.getRelative(-1, 1, 0));
        // A4
        airBlocks.add(start.getRelative(0, 1, 0));
        // A5
        airBlocks.add(start.getRelative(-1, 0, 0));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 6;
        x_or_z = 1;
        return true;
    }

    private boolean checkPos6Z(Block start) {

        // X1 X2 X3 X4
        // X5 A1 A2 X6
        // X7 A3 A4 X8
        // X9 A5 A6 X10
        // X11 X12 X13 X14

        ArrayList<Block> glowstoneBlocks = new ArrayList<Block>();
        ArrayList<Block> airBlocks = new ArrayList<Block>();

        // X1
        glowstoneBlocks.add(start.getRelative(0, 3, -2));
        // X2
        glowstoneBlocks.add(start.getRelative(0, 3, -1));
        // X3
        glowstoneBlocks.add(start.getRelative(0, 3, 0));
        // X4
        glowstoneBlocks.add(start.getRelative(0, 3, 1));
        // X5
        glowstoneBlocks.add(start.getRelative(0, 2, -2));
        // X6
        glowstoneBlocks.add(start.getRelative(0, 2, 1));
        // X7
        glowstoneBlocks.add(start.getRelative(0, 1, -2));
        // X8
        glowstoneBlocks.add(start.getRelative(0, 1, 1));
        // X9
        glowstoneBlocks.add(start.getRelative(0, 0, -2));
        // X10
        glowstoneBlocks.add(start.getRelative(0, 0, 1));
        // X11
        glowstoneBlocks.add(start.getRelative(0, -1, -2));
        // X12
        glowstoneBlocks.add(start.getRelative(0, -1, -1));
        // X13
        glowstoneBlocks.add(start.getRelative(0, -1, 0));
        // X14
        glowstoneBlocks.add(start.getRelative(0, -1, 1));
        // A1
        airBlocks.add(start.getRelative(0, 2, -1));
        // A2
        airBlocks.add(start.getRelative(0, 2, 0));
        // A3
        airBlocks.add(start.getRelative(0, 1, -1));
        // A4
        airBlocks.add(start.getRelative(0, 1, 0));
        // A5
        airBlocks.add(start.getRelative(0, 0, -1));

        for (Block block : glowstoneBlocks) {
            if (block.getType() != Material.GLOWSTONE) {
                return false;
            }
        }

        for (Block block : airBlocks) {
            if (block.getType() != Material.AIR) {
                return false;
            }
        }

        placeLocation = 6;
        x_or_z = 2;
        return true;
    }

}
