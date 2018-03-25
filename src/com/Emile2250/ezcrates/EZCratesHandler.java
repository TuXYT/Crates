package com.Emile2250.ezcrates;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
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
            
            Block block = event.getBlock();

            switch (block.getType()) {

                case STONE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("Stone")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                case COAL_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("CoalOre")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                    break;
                case IRON_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("IronOre")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                    break;
                case GOLD_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("GoldOre")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                    break;
                case DIAMOND_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("DiamondOre")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                    break;
                case EMERALD_ORE:
                    if ((int) (Math.random() * (100 / this.plugin.getConfig().getInt("EmeraldOre")) + 1.0D) == 1) {
                        setCrateItems(event, block);

                        sendCrateMessage(player);
                    }
                    break;
            }
        }
    }

    private void setCrateItems(BlockBreakEvent event, Block block) {

        event.setCancelled(true);

        block.setType(Material.CHEST);

        Chest chest = (Chest) block;

        Inventory chestInventory = chest.getBlockInventory();

        ItemStack[] items = new ItemStack[27];

        chestInventory.addItem();

    }

    private void sendCrateMessage(Player p) {

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6EZCrates&8] &bA Random crate has spawned!"));
    }
}