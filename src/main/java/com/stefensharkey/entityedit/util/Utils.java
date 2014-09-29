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

package com.stefensharkey.entityedit.util;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

public class Utils {

  /**
   * Gets the entities in the player's crosshairs.
   *
   * @param player The player.
   * @return The entity; null if non-existent.
   */
  public static Entity getEntityInCrosshairs(Player player) {
    int range = 10;
    Block[] blocks = player.getLineOfSight(null, range).toArray(new Block[0]);
    List<Entity> near = player.getNearbyEntities(range, range, range);

    for (Block block : blocks) {
      for (Entity entity : near) {
        if (entity.getLocation().distance(block.getLocation()) < 2) {
          return entity;
        }
      }
    }

    return null;
  }
}
