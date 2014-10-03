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

package com.stefensharkey.entityedit.util;

import org.bukkit.entity.Player;
import org.kitteh.tag.TagAPI;

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
    TagAPI.refreshPlayer(player);
  }

  public static Map<Player, String> getNames() {
    return names;
  }

  public static void setNames(Map<Player, String> playerNames) {
    names = playerNames;
  }
}
