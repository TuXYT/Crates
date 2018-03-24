package com.Emile2250.ezcrates;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EZCratesHandler implements Listener {

    private EZCrates plugin;

    public EZCratesHandler(EZCrates plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
            switch (event.getBlock().getType()) {
                case STONE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("Stone")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                case COAL_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("CoalOre")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                    break;
                case IRON_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("IronOre")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                    break;
                case GOLD_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("GoldOre")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                    break;
                case DIAMOND_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("DiamondOre")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                    break;
                case EMERALD_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("EmeraldOre")) + 1.0D) == 1) {
                        event.setCancelled(true);
                        event.getBlock().setType(Material.CHEST);
                        sendCrateMessage(player);
                    }
                    break;
            }
        }
    }
    private void sendCrateMessage(Player p) {

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6EZCrates&8] &bA Random crate has spawned!"));
    }
}