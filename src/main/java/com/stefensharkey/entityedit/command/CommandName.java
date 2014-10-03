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

import com.stefensharkey.entityedit.util.CustomNames;
import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.List;

public class CommandName implements TabExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;
    LivingEntity entity = Utils.getEntityInCrosshairs(player);

    if (args.length > 2) {
      sender.sendMessage(ChatColor.RED + "Entity names can only have one word.");
    } else if (args.length > 1) {
      if (entity != null) {
        if (entity instanceof Player) {
          if (Utils.getEnabledDependencies().contains("TagAPI")) {
            sender.sendMessage(
                ChatColor.GREEN + (Utils.getEntityName(entity) + " has been renamed to " + args[1] + "."));
            CustomNames.setName((Player) entity, args[1]);
            return true;
          } else {
            sender.sendMessage(ChatColor.RED + "TagAPI not found. Cannot set player name.");
            return false;
          }
        }

        sender.sendMessage(ChatColor.GREEN + Utils.getEntityName(entity) + " has been renamed to " + args[1] + ".");
        entity.setCustomName(args[1]);
        return true;
      } else {
        sender.sendMessage(ChatColor.RED + "No entities found.");
      }
    } else {
      sender.sendMessage(ChatColor.RED + "Entity name missing and/or invalid.");
    }

    return false;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    return null;
  }
}
