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

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandEntityEdit implements TabExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;

    player.sendMessage("EntityEdit");
    return false;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    return new ArrayList<>();
  }
}
