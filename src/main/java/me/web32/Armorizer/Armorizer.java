/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.web32.Armorizer;

import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author maximiliansollner
 */
public class Armorizer extends JavaPlugin {
    private ItemStack[] diamond = new ItemStack[4];
    private ItemStack[] gold = new ItemStack[4];
    private ItemStack[] iron = new ItemStack[4];
    private ItemStack[] leather = new ItemStack[4];
    
    
    @Override
    public void onEnable() {
        //Define ItemStacks
        diamond[0] = new ItemStack(310);
        diamond[1] = new ItemStack(311);
        diamond[2] = new ItemStack(312);
        diamond[3] = new ItemStack(313);
        
        iron[0] = new ItemStack(306);
        iron[1] = new ItemStack(307);
        iron[2] = new ItemStack(308);
        iron[3] = new ItemStack(309);
        
        gold[0] = new ItemStack(314);
        gold[1] = new ItemStack(315);
        gold[2] = new ItemStack(316);
        gold[3] = new ItemStack(317);
        
        leather[0] = new ItemStack(298);
        leather[1] = new ItemStack(299);
        leather[2] = new ItemStack(300);
        leather[3] = new ItemStack(301);
        
        //Activate MC-Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = getServer().getPlayer(sender.getName());
        if(sender instanceof Player) {
            
        } else {
            sender.sendMessage("This Command can only be run by a Player!");
            return false;
        }
        if(cmd.getName().equalsIgnoreCase("armor")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("diamond") || args[0].equalsIgnoreCase("dia")) {
                    player.getInventory().setArmorContents(diamond);
                    sender.sendMessage("You now wear " + ChatColor.AQUA + "diamond " + ChatColor.WHITE + "armor!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("iron")) {
                    player.getInventory().setArmorContents(iron);
                    sender.sendMessage("You now wear " + ChatColor.GRAY + "iron " + ChatColor.WHITE + "armor!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("gold")) {
                    player.getInventory().setArmorContents(gold);
                    sender.sendMessage("You now wear " + ChatColor.GOLD + "golden " + ChatColor.WHITE + "armor!");
                    return true;
                }
                if(args[0].equalsIgnoreCase("leather")) {
                    player.getInventory().setArmorContents(leather);
                    sender.sendMessage("You now wear " + ChatColor.DARK_RED + "leather " + ChatColor.WHITE + "armor!");
                    return true;
                }
            }
        }
        return false;
    }
}
