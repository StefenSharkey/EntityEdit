package com.stefensharkey.entityedit.command;

import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandHealth implements TabExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player player = (Player) sender;
    LivingEntity entity = Utils.getEntityInCrosshairs(player);

    if (entity != null) {
      if (args.length == 1) {
        sender.sendMessage(ChatColor.RED + "A number is required to set the health.");
        return false;
      } else if (args.length == 2) {
        double health;

        try {
          health = Double.parseDouble(args[1]);
        } catch (NullPointerException | NumberFormatException e) {
          sender.sendMessage(ChatColor.RED + args[1] + " is invalid.");
          return true;
        }

        if (health < 0) {
          sender.sendMessage(ChatColor.RED + "Health must be at least 0.");
          return true;
        } else if (health > 20) {
          sender.sendMessage(ChatColor.RED + "Health must be no greater than 20.");
          return true;
        }

        sender.sendMessage(
            ChatColor.GREEN + entity.getType().getEntityClass().getSimpleName() + "'s health is now " + args[1] + ".");
        entity.setHealth(health);
        return true;
      } else {
        sender.sendMessage(ChatColor.RED + "Syntax error.");
        sender.sendMessage(ChatColor.RED + "/entityedit health <number>");
        return true;
      }
    }

    sender.sendMessage(ChatColor.RED + "No entities found.");
    return true;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    return new ArrayList<>();
  }
}
