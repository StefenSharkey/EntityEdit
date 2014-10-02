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
    LivingEntity entity = (LivingEntity) Utils.getEntityInCrosshairs(player);
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

          if (argsList.get(argsList.indexOf("-clear") + 1).equalsIgnoreCase("all")) {
            entity.getEquipment().setItemInHand(new ItemStack(Material.AIR, 1));
          }
        }

        if (argsList.contains("-h")) {
          String helmet;

          if (argsList.size() > argsList.indexOf("-h") + 1) {
            helmet = argsList.get(argsList.indexOf("-h") + 1);

            if (helmet.substring(0, 1).equals("-")) {
              entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
            } else {
              setHelmet(entity, helmet);
            }
          } else {
            entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
            return false;
          }
        }

        if (argsList.contains("-c")) {
          String chestplate;

          if (argsList.size() > argsList.indexOf("-c") + 1) {
            chestplate = argsList.get(argsList.indexOf("-c") + 1);

            if (chestplate.substring(0, 1).equals("-")) {
              entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
            } else {
              setChestplate(entity, chestplate);
            }
          } else {
            entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
            return false;
          }
        }

        if (argsList.contains("-l")) {
          String leggings;

          if (argsList.size() > argsList.indexOf("-l") + 1) {
            leggings = argsList.get(argsList.indexOf("-l") + 1);

            if (leggings.substring(0, 1).equals("-")) {
              entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
            } else {
              setLeggings(entity, leggings);
            }
          } else {
            entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
            return false;
          }
        }

        if (argsList.contains("-b")) {
          String boots;

          if (argsList.size() > argsList.indexOf("-b") + 1) {
            boots = argsList.get(argsList.indexOf("-b") + 1);

            if (boots.substring(0, 1).equals("-")) {
              entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
            } else {
              setBoots(entity, boots);
            }
          } else {
            entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
            return false;
          }
        }
      } else {
        sender.sendMessage(ChatColor.RED + "No entities found.");
      }
    }

    return false;
  }

  private void setHelmet(LivingEntity entity, String helmet) {
    switch (helmet) {
      case "a":
        entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
        break;
      case "air":
        entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
        break;
      case "minecraft:air":
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
      case "0":
        entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
        break;
      case "l":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "leather":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "lhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "l_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "lhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "l_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "leatherhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "leather_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "leatherhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "leather_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "minecraft:leather_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "298":
        entity.getEquipment().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
        break;
      case "c":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chain":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainmail":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "c_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "c_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chain_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainmailhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainmail_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chain_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainmailhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "chainmail_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "minecraft:chainmail_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "302":
        entity.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET, 1));
        break;
      case "i":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "iron":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "ihelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "i_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "ihelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "i_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "ironhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "iron_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "ironhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "iron_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "minecraft:iron_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "306":
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
        break;
      case "d":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "diamond":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "dhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "d_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "dhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "d_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "diamondhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "diamond_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "diamondhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "diamond_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "minecraft:diamond_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "310":
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
        break;
      case "g":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "gold":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "golden":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "ghelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "g_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "ghelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "g_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "goldhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "gold_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "goldenhelm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "golden_helm":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "goldhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "gold_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "goldenhelmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "golden_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "minecraft:golden_helmet":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      case "314":
        entity.getEquipment().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
        break;
      default:
        entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
        break;
    }
  }

  private void setChestplate(LivingEntity entity, String chestplate) {
    switch (chestplate) {
      case "a":
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
      case "air":
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
      case "minecraft:air":
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
      case "0":
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
      case "l":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leather":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "ltunic":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "l_tunic":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "lchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "l_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "lchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "l_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leathertunic":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leather_tunic":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leatherchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leather_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leatherchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "leather_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "minecraft:leather_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "299":
        entity.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
        break;
      case "c":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chain":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainmail":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "cchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "c_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "cchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "c_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chain_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chain_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainmailchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainmail_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainmailchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "chainmail_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "minecraft:chainmail_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "303":
        entity.getEquipment().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));
        break;
      case "i":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "iron":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "ichest":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "i_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "ichestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "i_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "ironchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "iron_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "ironchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "iron_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "307":
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
        break;
      case "d":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "diamond":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "dhelm":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "d_helm":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "dhelmet":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "d_helmet":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "diamondhelm":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "diamond_helm":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "diamondhelmet":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "diamond_helmet":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "minecraft:diamond_helmet":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "311":
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
        break;
      case "g":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "gold":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "golden":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "gchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "g_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "gchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "g_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "goldchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "gold_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "goldchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "gold_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "goldenchest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "golden_chest":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "goldenchestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "golden_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "minecraft:golden_chestplate":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      case "315":
        entity.getEquipment().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
        break;
      default:
        entity.getEquipment().setChestplate(new ItemStack(Material.AIR, 1));
        break;
    }
  }

  private void setLeggings(LivingEntity entity, String leggings) {
    switch (leggings) {
      case "a":
        entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
        break;
      case "air":
        entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
        break;
      case "0":
        entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
        break;
      case "l":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leather":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "lpants":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "l_pants":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "llegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "l_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "lleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "l_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leatherpants":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leather_pants":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leatherlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leather_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leatherleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "leather_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "inecraft:leather_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "300":
        entity.getEquipment().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
        break;
      case "c":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chain":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainmail":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "clegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "c_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "cleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "c_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chain_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chain_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainmaillegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainmail_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainmailleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "chainmail_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "minecraft:chainmail_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "304":
        entity.getEquipment().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));
        break;
      case "i":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "iron":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "ilegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "i_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "ileggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "i_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "ironlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "iron_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "ironleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "iron_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "minecraft:iron_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "308":
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
        break;
      case "d":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "diamond":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "dlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "d_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "dleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "d_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "diamondlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "diamond_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "diamondleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "diamond_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "minecraft:diamond_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "312":
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
        break;
      case "g":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "gold":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "golden":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "glegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "g_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "gleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "g_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "goldlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "gold_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "goldleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "gold_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "goldenlegs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "golden_legs":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "goldenleggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "golden_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "minecraft:golden_leggings":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      case "316":
        entity.getEquipment().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
        break;
      default:
        entity.getEquipment().setLeggings(new ItemStack(Material.AIR, 1));
        break;
    }
  }

  private void setBoots(LivingEntity entity, String boots) {
    switch (boots) {
      case "a":
        entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
        break;
      case "air":
        entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
        break;
      case "0":
        entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
        break;
      case "l":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "leather":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "lboots":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "l_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "leatherboots":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "leather_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "minecraft:leather_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "301":
        entity.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
        break;
      case "c":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chain":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chainmail":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "cboots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "c_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chainboots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chain_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chainmailboots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "chainmail_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "minecraft:chainmail_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "304":
        entity.getEquipment().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS, 1));
        break;
      case "i":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "iron":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "iboots":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "i_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "ironboots":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "iron_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "minecraft:iron_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "309":
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
        break;
      case "d":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "diamond":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "dboots":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "d_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "diamondboots":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "diamond_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "minecraft:diamond_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "313":
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
        break;
      case "g":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "gold":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "golden":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "gboots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "g_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "goldboots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "gold_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "goldenboots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "golden_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "minecraft:golden_boots":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      case "317":
        entity.getEquipment().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
        break;
      default:
        entity.getEquipment().setBoots(new ItemStack(Material.AIR, 1));
        break;
    }
  }
}
