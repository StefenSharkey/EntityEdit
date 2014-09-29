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
