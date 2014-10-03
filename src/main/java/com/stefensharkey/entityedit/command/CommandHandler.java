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

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandHandler implements TabExecutor {

  private Map<String, TabExecutor> commands = new HashMap<>();

  public void register(String name, TabExecutor cmd) {
    commands.put(name, cmd);
  }

  public boolean exists(String name) {
    return commands.containsKey(name);
  }

  public TabExecutor getExecutor(String name) {
    return commands.get(name);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      if (args.length == 0) {
        getExecutor("entityedit").onCommand(sender, cmd, label, args);
        return true;
      }

      if (args.length > 0) {
        if (exists(args[0])) {
          getExecutor(args[0]).onCommand(sender, cmd, label, args);
          return true;
        } else {
          sender.sendMessage(ChatColor.RED + "This command doesn't exist.");
          return true;
        }
      }
    } else {
      sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
      return true;
    }

    return false;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      if (args.length == 0) {
        return getExecutor("entityedit").onTabComplete(sender, cmd, label, args);
      }

      if (args.length > 0) {
        if (exists(args[0])) {
          return getExecutor(args[0]).onTabComplete(sender, cmd, label, args);
        } else {
          ArrayList<String> commandList = new ArrayList<>();

          for (String command : commands.keySet()) {
            commandList.add(command);
          }

          Collections.sort(commandList);
          return commandList;
        }
      }
    }

    return new ArrayList<>();
  }
}
