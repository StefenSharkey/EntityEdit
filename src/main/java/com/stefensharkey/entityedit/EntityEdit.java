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

import com.stefensharkey.entityedit.command.*;
import com.stefensharkey.entityedit.util.Utils;

import org.bukkit.plugin.java.JavaPlugin;

public class EntityEdit extends JavaPlugin {

  @Override
  public void onEnable() {
    registerCommands();

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
    handler.register("copy", new CommandCopy());
    handler.register("cut", new CommandCut());
    handler.register("enchant", new CommandEnchant());
    handler.register("health", new CommandHealth());
//    handler.register("name", new CommandName());
    handler.register("paste", new CommandPaste());

    getCommand("entityedit").setExecutor(handler);
  }
}
