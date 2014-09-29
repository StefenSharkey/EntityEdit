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

package com.stefensharkey.entityedit;

import com.stefensharkey.entityedit.command.CommandEntityEdit;
import com.stefensharkey.entityedit.command.CommandHandler;
import com.stefensharkey.entityedit.command.CommandName;
import com.stefensharkey.entityedit.eventlistener.AsyncPlayerReceiveNameTagListener;

import org.bukkit.plugin.java.JavaPlugin;

public class EntityEdit extends JavaPlugin {

  @Override
  public void onEnable() {
    registerCommands();
    registerEvents();
  }

  @Override
  public void onDisable() {
  }

  @SuppressWarnings("ConstantConditions")
  public void registerCommands() {
    CommandHandler handler = new CommandHandler();

    handler.register("entityedit", new CommandEntityEdit());
    handler.register("name", new CommandName());

    getCommand("entityedit").setExecutor(handler);
  }

  public void registerEvents() {
    getServer().getPluginManager().registerEvents(new AsyncPlayerReceiveNameTagListener(this), this);
  }
}
