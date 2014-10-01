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

package com.stefensharkey.entityedit.eventlistener;

import com.stefensharkey.entityedit.EntityEdit;
import com.stefensharkey.entityedit.util.CustomNames;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;

public class AsyncPlayerReceiveNameTagListener implements Listener {

  private EntityEdit plugin;

  public AsyncPlayerReceiveNameTagListener(EntityEdit plugin) {
    this.plugin = plugin;
  }

  @EventHandler(priority = EventPriority.LOW)
  public void onNameTag(AsyncPlayerReceiveNameTagEvent event) {
    if (CustomNames.exists(event.getNamedPlayer())) {
      event.setTag(CustomNames.getName(event.getNamedPlayer()));
    }
  }
}
