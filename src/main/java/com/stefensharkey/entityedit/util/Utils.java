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

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

  private final static ArrayList<String> enabledDependencies = new ArrayList<>();
  private final static Set<Material> materials = new HashSet<>();

  /**
   * Gets the entities in the player's crosshairs.
   *
   * @param player The player.
   * @return The entity; null if non-existent.
   */
  public static LivingEntity getEntityInCrosshairs(Player player) {
    int range = 10;
    materials.add(Material.AIR);
    List<Block> lineOfSight = player.getLineOfSight(materials, range);
    Block[] blocks = lineOfSight.toArray(new Block[lineOfSight.size()]);
    List<Entity> near = player.getNearbyEntities(range, range, range);

    for (Block block : blocks) {
      for (Entity entity : near) {
        if (entity instanceof LivingEntity && entity.getLocation().distance(block.getLocation()) < 2) {
          return (LivingEntity) entity;
        }
      }
    }

    return null;
  }

  public static String getEntityName(LivingEntity entity) {
    if (entity instanceof Player) {
      return ((Player) entity).getName();
    }

    if (entity.getCustomName() == null) {
      return entity.getType().getEntityClass().getSimpleName();
    }

    return entity.getCustomName();
  }

  public static void setDependency(String plugin) {
    enabledDependencies.add(plugin);
  }

  public static ArrayList<String> getEnabledDependencies() {
    return enabledDependencies;
  }
}
