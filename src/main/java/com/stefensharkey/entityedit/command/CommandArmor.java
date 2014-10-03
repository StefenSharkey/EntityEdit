/*
 * This file is part of EntityEdit.
 *
 * EntityEdit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EntityEdit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EntityEdit.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.stefensharkey.entityedit.command;

import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandArmor implements TabExecutor {

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
        argsList.add(arg.toUpperCase());
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
              entity.getEquipment().setHelmet(new ItemStack(Material.AIR, 1));
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

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    ArrayList<String> equipmentTypes = new ArrayList<>();

    ArrayList<Material> helmTypes = new ArrayList<Material>() {{
      add(Material.AIR);
      add(Material.LEATHER_HELMET);
      add(Material.CHAINMAIL_HELMET);
      add(Material.IRON_HELMET);
      add(Material.DIAMOND_HELMET);
      add(Material.GOLD_HELMET);
    }};

    ArrayList<Material> chestplateTypes = new ArrayList<Material>() {{
      add(Material.AIR);
      add(Material.LEATHER_CHESTPLATE);
      add(Material.CHAINMAIL_CHESTPLATE);
      add(Material.IRON_CHESTPLATE);
      add(Material.DIAMOND_CHESTPLATE);
      add(Material.GOLD_CHESTPLATE);
    }};

    ArrayList<Material> leggingTypes = new ArrayList<Material>() {{
      add(Material.AIR);
      add(Material.LEATHER_LEGGINGS);
      add(Material.CHAINMAIL_LEGGINGS);
      add(Material.IRON_LEGGINGS);
      add(Material.DIAMOND_LEGGINGS);
      add(Material.GOLD_LEGGINGS);
    }};

    ArrayList<Material> bootTypes = new ArrayList<Material>() {{
      add(Material.AIR);
      add(Material.LEATHER_BOOTS);
      add(Material.CHAINMAIL_BOOTS);
      add(Material.IRON_BOOTS);
      add(Material.DIAMOND_BOOTS);
      add(Material.GOLD_BOOTS);
    }};

    if (args[args.length - 2].equalsIgnoreCase("-h")) {
      for (Material helm : helmTypes) {
        if (helm.toString().toLowerCase().startsWith(args[args.length - 1].toLowerCase())) {
          equipmentTypes.add(helm.toString());
        }
      }
    } else if (args[args.length - 2].equalsIgnoreCase("-c")) {
      for (Material chestplate : chestplateTypes) {
        if (chestplate.toString().toLowerCase().startsWith(args[args.length - 1].toLowerCase())) {
          equipmentTypes.add(chestplate.toString());
        }
      }
    } else if (args[args.length - 2].equalsIgnoreCase("-l")) {
      for (Material legging : leggingTypes) {
        if (legging.toString().toLowerCase().startsWith(args[args.length - 1].toLowerCase())) {
          equipmentTypes.add(legging.toString());
        }
      }
    } else if (args[args.length - 2].equalsIgnoreCase("-b")) {
      for (Material boot : bootTypes) {
        if (boot.toString().toLowerCase().startsWith(args[args.length - 1].toLowerCase())) {
          equipmentTypes.add(boot.toString());
        }
      }
    }

    Collections.sort(equipmentTypes);
    return equipmentTypes;
  }

  private Material getHelmet(String helmet) {
    Material material;

    switch (helmet) {
      case "LEATHER_HELMET":
        material = Material.LEATHER_HELMET;
        break;
      case "CHAINMAIL_HELMET":
        material = Material.CHAINMAIL_HELMET;
        break;
      case "IRON_HELMET":
        material = Material.IRON_HELMET;
        break;
      case "DIAMOND_HELMET":
        material = Material.DIAMOND_HELMET;
        break;
      case "GOLD_HELMET":
        material = Material.GOLD_HELMET;
        break;
      case "AIR":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getChestplate(String chestplate) {
    Material material;

    switch (chestplate) {
      case "LEATHER_CHESTPLATE":
        material = Material.LEATHER_CHESTPLATE;
        break;
      case "CHAINMAIL_CHESTPLATE":
        material = Material.CHAINMAIL_CHESTPLATE;
        break;
      case "IRON_CHESTPLATE":
        material = Material.IRON_CHESTPLATE;
        break;
      case "DIAMOND_CHESTPLATE":
        material = Material.DIAMOND_CHESTPLATE;
        break;
      case "GOLD_CHESTPLATE":
        material = Material.GOLD_CHESTPLATE;
        break;
      case "AIR":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getLeggings(String leggings) {
    Material material;

    switch (leggings) {
      case "LEATHER_LEGGINGS":
        material = Material.LEATHER_LEGGINGS;
        break;
      case "CHAINMAIL_LEGGINGS":
        material = Material.CHAINMAIL_LEGGINGS;
        break;
      case "IRON_LEGGINGS":
        material = Material.IRON_LEGGINGS;
        break;
      case "DIAMOND_LEGGINGS":
        material = Material.DIAMOND_LEGGINGS;
        break;
      case "GOLD_LEGGINGS":
        material = Material.GOLD_LEGGINGS;
        break;
      case "AIR":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }

  private Material getBoots(String boots) {
    Material material;

    switch (boots) {
      case "LEATHER_BOOTS":
        material = Material.LEATHER_BOOTS;
        break;
      case "CHAINMAIL_BOOTS":
        material = Material.CHAINMAIL_BOOTS;
        break;
      case "IRON_BOOTS":
        material = Material.IRON_BOOTS;
        break;
      case "DIAMOND_BOOTS":
        material = Material.DIAMOND_BOOTS;
        break;
      case "GOLD_BOOTS":
        material = Material.GOLD_BOOTS;
        break;
      case "AIR":
      default:
        material = Material.AIR;
        break;
    }

    return material;
  }
}
