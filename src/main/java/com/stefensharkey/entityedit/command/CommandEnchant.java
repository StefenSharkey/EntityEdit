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

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandEnchant implements TabExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;
    LivingEntity entity = Utils.getEntityInCrosshairs(player);
    ArrayList<String> argsList = new ArrayList<>();

    for (String arg : args) {
      argsList.add(arg.toUpperCase());
    }

    if (entity != null) {
      if (args.length < 3) {
        sender.sendMessage(ChatColor.RED + "At least one enchantment is required.");
        return false;
      } else {
        if (argsList.contains("-h") || argsList.contains("-c") || argsList.contains("-l") || argsList.contains("-b")) {
          if (argsList.contains("-h")) {
            ArrayList<String> helmEnchants;
            String helmArgs = StringUtils.join(argsList, " ");

            helmEnchants = new ArrayList<>(Arrays.asList(helmArgs
                .substring(helmArgs.indexOf("-h", helmArgs.indexOf("-", helmArgs.indexOf("-h")))).split(" ")));

            if (argsList.size() > argsList.indexOf("-h") + 1) {
              Map<Enchantment, Integer> enchantMap = new HashMap<>();

              for (String enchant : helmEnchants) {
                enchantMap.put(Enchantment.getByName(enchant), 1);
              }

              entity.getEquipment().getHelmet().addEnchantments(enchantMap);
            } else {
              if (entity.getEquipment().getHelmet().hasItemMeta()) {
                entity.getEquipment().getHelmet().getEnchantments().clear();
              }
            }
          }

          if (argsList.contains("-c")) {
            ArrayList<String> chestplateEnchantments;
            String chestplateArgs = StringUtils.join(argsList, " ");

            chestplateEnchantments = new ArrayList<>(Arrays.asList(chestplateArgs
                .substring(chestplateArgs.indexOf("-c", chestplateArgs.indexOf("-", chestplateArgs.indexOf("-c"))))
                                                                       .split(" ")));

            if (argsList.size() > argsList.indexOf("-c") + 1) {
              Map<Enchantment, Integer> enchantMap = new HashMap<>();

              for (String enchant : chestplateEnchantments) {
                enchantMap.put(Enchantment.getByName(enchant), 1);
              }

              entity.getEquipment().getChestplate().addEnchantments(enchantMap);
            } else {
              if (entity.getEquipment().getChestplate().hasItemMeta()) {
                entity.getEquipment().getChestplate().getEnchantments().clear();
              }
            }
          }

          if (argsList.contains("-l")) {
            ArrayList<String> leggingEnchantments;
            String leggingArgs = StringUtils.join(argsList, " ");

            leggingEnchantments = new ArrayList<>(Arrays.asList(leggingArgs
                .substring(leggingArgs.indexOf("-l", leggingArgs.indexOf("-", leggingArgs.indexOf("-l")))).split(" ")));

            if (argsList.size() > argsList.indexOf("-l") + 1) {
              Map<Enchantment, Integer> enchantMap = new HashMap<>();

              for (String enchant : leggingEnchantments) {
                enchantMap.put(Enchantment.getByName(enchant), 1);
              }

              entity.getEquipment().getLeggings().addEnchantments(enchantMap);
            } else {
              if (entity.getEquipment().getLeggings().hasItemMeta()) {
                entity.getEquipment().getLeggings().getEnchantments().clear();
              }
            }
          }

          if (argsList.contains("-b")) {
            ArrayList<String> bootEnchantments;
            String bootArgs = StringUtils.join(argsList, " ");

            bootEnchantments = new ArrayList<>(Arrays.asList(bootArgs
                .substring(bootArgs.indexOf("-b", bootArgs.indexOf("-", bootArgs.indexOf("-b")))).split(" ")));

            if (argsList.size() > argsList.indexOf("-b") + 1) {
              Map<Enchantment, Integer> enchantMap = new HashMap<>();

              for (String enchant : bootEnchantments) {
                enchantMap.put(Enchantment.getByName(enchant), 1);
              }

              entity.getEquipment().getBoots().addEnchantments(enchantMap);
            } else {
              if (entity.getEquipment().getBoots().hasItemMeta()) {
                entity.getEquipment().getBoots().getEnchantments().clear();
              }
            }
          }
          return true;
        }

        sender.sendMessage(ChatColor.RED + "Syntax error.");
        sender.sendMessage(ChatColor.RED
            + "/entityedit enchant <[-clear] [-h [enchantments]] [-c [enchantments]] [-l [enchantments]] [-b [enchantments]]>");
        return false;
      }
    }

    sender.sendMessage(ChatColor.RED + "No entities found.");
    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    ArrayList<String> enchantments = new ArrayList<>();
    ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));

    if (argsList.contains("-h") || argsList.contains("-c") || argsList.contains("-l") || argsList.contains("-b")) {
      for(Enchantment enchantment : Enchantment.values()) {
        enchantments.add(enchantment.toString());
      }

      Collections.sort(enchantments);
      return enchantments;
    }

    return null;
  }

}
