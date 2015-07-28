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

import com.stefensharkey.entityedit.util.Clipboard;
import com.stefensharkey.entityedit.util.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandPaste implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 1) {
            Location location = new Location(player.getWorld(),
                    player.getTargetBlock(Utils.getMaterialFilter(), 200).getX(),
                    player.getTargetBlock(Utils.getMaterialFilter(), 200).getY() + 1,
                    player.getTargetBlock(Utils.getMaterialFilter(), 200).getZ());
            paste(player, location);
        } else if (args.length == 2) {
            switch (args[1]) {
                case "feet":
                case "f":
                    Location location = player.getLocation();
                    paste(player, location);
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "Invalid argument: " + args[1]);
                    return false;
            }
        } else {
            player.sendMessage(ChatColor.RED + "Too many arguments.");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return new ArrayList<>();
    }

    private void paste(Player player, Location location) {
        Clipboard clipboard = new Clipboard();

        if (clipboard.paste() != null) {
            Entity entity = clipboard.paste();
            player.getWorld().spawnEntity(location, entity.getType());
        }
    }
}
