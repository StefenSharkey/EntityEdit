/*
 * This file is part of PvPLogger.
 *
 * PvPLogger is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PvPLogger is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PvPLogger.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.stefensharkey.entityedit.command;

import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CommandArmor implements CommandInterface {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;
    LivingEntity entity = Utils.getEntityInCrosshairs(player);
    ArrayList<String> argsList = new ArrayList<>();

    if (args.length == 1) {
      sender.sendMessage(ChatColor.RED + "Syntax error.");
      sender.sendMessage(
          ChatColor.RED + "/entityedit armor <[-clear] [-h [helm]] [-c [chestplate]] [-l [leggings]] [-b [boots]]>");
    } else {
      for (String arg : args) {
        argsList.add(arg.toLowerCase());
      }

      if (entity != null) {
        if (argsList.contains("-clear")) {
          entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
          entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
          entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
          entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));

          if (argsList.size() > argsList.indexOf("-clear") + 1) {
            if (argsList.get(argsList.indexOf("-clear") + 1).equalsIgnoreCase("all")) {
              entity.getEquipment().setItemInHand(new ItemStack(Material.AIR, 1));
            }
          }

          sender.sendMessage(ChatColor.GREEN + Utils.getEntityName(entity) + "'s equipment has been cleared.");
        }

        if (argsList.contains("-h") || argsList.contains("-c") || argsList.contains("-l") || argsList.contains("-b")) {
          if (argsList.contains("-h")) {
            if (argsList.size() > argsList.indexOf("-h") + 1) {
              entity.getEquipment().setHelmet(new ItemStack(getHelmet(argsList.get(argsList.indexOf("-h") + 1)), 1));
            } else {
              entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
              return false;
            }
          }

          if (argsList.contains("-c")) {
            if (argsList.size() > argsList.indexOf("-c") + 1) {
              entity.getEquipment()
                  .setChestplate(new ItemStack(getChestplate(argsList.get(argsList.indexOf("-c") + 1)), 1));
            } else {
              entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
              return false;
            }
          }

          if (argsList.contains("-l")) {
            if (argsList.size() > argsList.indexOf("-l") + 1) {
              entity.getEquipment()
                  .setLeggings(new ItemStack(getLeggings(argsList.get(argsList.indexOf("-l") + 1)), 1));
            } else {
              entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
              return false;
            }
          }

          if (argsList.contains("-b")) {
            if (argsList.size() > argsList.indexOf("-b") + 1) {
              entity.getEquipment().setBoots(new ItemStack(getBoots(argsList.get(argsList.indexOf("-b") + 1)), 1));
            } else {
              entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
              return false;
            }
          }

          sender.sendMessage(ChatColor.GREEN + Utils.getEntityName(entity) + "'s armor has been set.");
        }
      } else {
        sender.sendMessage(ChatColor.RED + "No entities found.");
      }
    }

    return false;
  }

  private Material getHelmet(String helmet) {
    Material material;

    switch (helmet) {
      case "l":
      case "leather":
      case "lhelm":
      case "l_helm":
      case "lhelmet":
      case "l_helmet":
      case "leatherhelm":
      case "leather_helm":
      case "leatherhelmet":
      case "leather_helmet":
      case "minecraft:leather_helmet":
      case "298":
        material = Material.LEATHER_HELMET;
        break;
      case "c":
      case "chain":
      case "chainmail":
      case "chelm":
      case "c_helm":
      case "chelmet":
      case "c_helmet":
      case "chainhelm":
      case "chain_helm":
      case "chainmailhelm":
      case "chainmail_helm":
      case "chainhelmet":
      case "chain_helmet":
      case "chainmailhelmet":
      case "chainmail_helmet":
      case "minecraft:chainmail_helmet":
      case "302":
        material = Material.CHAINMAIL_HELMET;
        break;
      case "i":
      case "iron":
      case "ihelm":
      case "i_helm":
      case "ihelmet":
      case "i_helmet":
      case "ironhelm":
      case "iron_helm":
      case "ironhelmet":
      case "iron_helmet":
      case "minecraft:iron_helmet":
      case "306":
        material = Material.IRON_HELMET;
        break;
      case "d":
      case "diamond":
      case "dhelm":
      case "d_helm":
      case "dhelmet":
      case "d_helmet":
      case "diamondhelm":
      case "diamond_helm":
      case "diamondhelmet":
      case "diamond_helmet":
      case "minecraft:diamond_helmet":
      case "310":
        material = Material.DIAMOND_HELMET;
        break;
      case "g":
      case "gold":
      case "golden":
      case "ghelm":
      case "g_helm":
      case "ghelmet":
      case "g_helmet":
      case "goldhelm":
      case "gold_helm":
      case "goldenhelm":
      case "golden_helm":
      case "goldhelmet":
      case "gold_helmet":
      case "goldenhelmet":
      case "golden_helmet":
      case "minecraft:golden_helmet":
      case "314":
        material = Material.GOLD_HELMET;
        break;
      case "a":
      case "air":
      case "minecraft:air":
      case "0":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getChestplate(String chestplate) {
    Material material;

    switch (chestplate) {
      case "l":
      case "leather":
      case "ltunic":
      case "l_tunic":
      case "lchest":
      case "l_chest":
      case "lchestplate":
      case "l_chestplate":
      case "leathertunic":
      case "leather_tunic":
      case "leatherchest":
      case "leather_chest":
      case "leatherchestplate":
      case "leather_chestplate":
      case "minecraft:leather_chestplate":
      case "299":
        material = Material.LEATHER_CHESTPLATE;
        break;
      case "c":
      case "chain":
      case "chainmail":
      case "cchest":
      case "c_chest":
      case "cchestplate":
      case "c_chestplate":
      case "chainchest":
      case "chain_chest":
      case "chainchestplate":
      case "chain_chestplate":
      case "chainmailchest":
      case "chainmail_chest":
      case "chainmailchestplate":
      case "chainmail_chestplate":
      case "minecraft:chainmail_chestplate":
      case "303":
        material = Material.CHAINMAIL_CHESTPLATE;
        break;
      case "i":
      case "iron":
      case "ichest":
      case "i_chest":
      case "ichestplate":
      case "i_chestplate":
      case "ironchest":
      case "iron_chest":
      case "ironchestplate":
      case "iron_chestplate":
      case "minecraft:iron_chestplate":
      case "307":
        material = Material.IRON_CHESTPLATE;
        break;
      case "d":
      case "diamond":
      case "dhelm":
      case "d_helm":
      case "dhelmet":
      case "d_helmet":
      case "diamondhelm":
      case "diamond_helm":
      case "diamondhelmet":
      case "diamond_helmet":
      case "minecraft:diamond_helmet":
      case "311":
        material = Material.DIAMOND_CHESTPLATE;
        break;
      case "g":
      case "gold":
      case "golden":
      case "gchest":
      case "g_chest":
      case "gchestplate":
      case "g_chestplate":
      case "goldchest":
      case "gold_chest":
      case "goldchestplate":
      case "gold_chestplate":
      case "goldenchest":
      case "golden_chest":
      case "goldenchestplate":
      case "golden_chestplate":
      case "minecraft:golden_chestplate":
      case "315":
        material = Material.GOLD_CHESTPLATE;
        break;
      case "a":
      case "air":
      case "minecraft:air":
      case "0":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getLeggings(String leggings) {
    Material material;

    switch (leggings) {
      case "l":
      case "leather":
      case "lpants":
      case "l_pants":
      case "llegs":
      case "l_legs":
      case "lleggings":
      case "l_leggings":
      case "leatherpants":
      case "leather_pants":
      case "leatherlegs":
      case "leather_legs":
      case "leatherleggings":
      case "leather_leggings":
      case "inecraft:leather_leggings":
      case "300":
        material = Material.LEATHER_LEGGINGS;
        break;
      case "c":
      case "chain":
      case "chainmail":
      case "clegs":
      case "c_legs":
      case "cleggings":
      case "c_leggings":
      case "chainlegs":
      case "chain_legs":
      case "chainleggings":
      case "chain_leggings":
      case "chainmaillegs":
      case "chainmail_legs":
      case "chainmailleggings":
      case "chainmail_leggings":
      case "minecraft:chainmail_leggings":
      case "304":
        material = Material.CHAINMAIL_LEGGINGS;
        break;
      case "i":
      case "iron":
      case "ilegs":
      case "i_legs":
      case "ileggings":
      case "i_leggings":
      case "ironlegs":
      case "iron_legs":
      case "ironleggings":
      case "iron_leggings":
      case "minecraft:iron_leggings":
      case "308":
        material = Material.IRON_LEGGINGS;
        break;
      case "d":
      case "diamond":
      case "dlegs":
      case "d_legs":
      case "dleggings":
      case "d_leggings":
      case "diamondlegs":
      case "diamond_legs":
      case "diamondleggings":
      case "diamond_leggings":
      case "minecraft:diamond_leggings":
      case "312":
        material = Material.DIAMOND_LEGGINGS;
        break;
      case "g":
      case "gold":
      case "golden":
      case "glegs":
      case "g_legs":
      case "gleggings":
      case "g_leggings":
      case "goldlegs":
      case "gold_legs":
      case "goldleggings":
      case "gold_leggings":
      case "goldenlegs":
      case "golden_legs":
      case "goldenleggings":
      case "golden_leggings":
      case "minecraft:golden_leggings":
      case "316":
        material = Material.GOLD_LEGGINGS;
        break;
      case "a":
      case "air":
      case "minecraft:air":
      case "0":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getBoots(String boots) {
    Material material;

    switch (boots) {
      case "l":
      case "leather":
      case "lboots":
      case "l_boots":
      case "leatherboots":
      case "leather_boots":
      case "minecraft:leather_boots":
      case "301":
        material = Material.LEATHER_BOOTS;
        break;
      case "c":
      case "chain":
      case "chainmail":
      case "cboots":
      case "c_boots":
      case "chainboots":
      case "chain_boots":
      case "chainmailboots":
      case "chainmail_boots":
      case "minecraft:chainmail_boots":
      case "304":
        material = Material.CHAINMAIL_BOOTS;
        break;
      case "i":
      case "iron":
      case "iboots":
      case "i_boots":
      case "ironboots":
      case "iron_boots":
      case "minecraft:iron_boots":
      case "309":
        material = Material.IRON_BOOTS;
        break;
      case "d":
      case "diamond":
      case "dboots":
      case "d_boots":
      case "diamondboots":
      case "diamond_boots":
      case "minecraft:diamond_boots":
      case "313":
        material = Material.DIAMOND_BOOTS;
        break;
      case "g":
      case "gold":
      case "golden":
      case "gboots":
      case "g_boots":
      case "goldboots":
      case "gold_boots":
      case "goldenboots":
      case "golden_boots":
      case "minecraft:golden_boots":
      case "317":
        material = Material.GOLD_BOOTS;
        break;
      case "a":
      case "air":
      case "minecraft:air":
      case "0":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }
}
