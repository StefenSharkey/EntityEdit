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

package com.stefensharkey.entityedit;

import com.stefensharkey.entityedit.command.CommandArmor;
import com.stefensharkey.entityedit.command.CommandEntityEdit;
import com.stefensharkey.entityedit.command.CommandHandler;
import com.stefensharkey.entityedit.command.CommandName;
import com.stefensharkey.entityedit.eventlistener.AsyncPlayerReceiveNameTagListener;
import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.plugin.java.JavaPlugin;

public class EntityEdit extends JavaPlugin {

  @Override
  public void onEnable() {
    registerCommands();
    registerEvents();

    if (getServer().getPluginManager().getPlugin("TagAPI") != null) {
      Utils.setDependency("TagAPI");
    }
  }

  @Override
  public void onDisable() {
  }

  @SuppressWarnings("ConstantConditions")
  public void registerCommands() {
    CommandHandler handler = new CommandHandler();

    handler.register("entityedit", new CommandEntityEdit());
    handler.register("armor", new CommandArmor());
    handler.register("name", new CommandName());

    getCommand("entityedit").setExecutor(handler);
  }

  public void registerEvents() {
    getServer().getPluginManager().registerEvents(new AsyncPlayerReceiveNameTagListener(this), this);
  }
}
