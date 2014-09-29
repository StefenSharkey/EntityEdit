package com.stefensharkey.entityedit.util;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CustomNames {

  private static Map<Player, String> names = new HashMap<>();

  public static boolean exists(Player player) {
    return names.containsKey(player);
  }

  public static String getName(Player player) {
    return names.get(player);
  }

  public static void setName(Player player, String name) {
    if (names.containsKey(player)) {
      names.remove(player);
    }
    names.put(player, name);
  }

  public static Map<Player, String> getNames() {
    return names;
  }

  public static void setNames(Map<Player, String> playerNames) {
    names = playerNames;
  }
}
