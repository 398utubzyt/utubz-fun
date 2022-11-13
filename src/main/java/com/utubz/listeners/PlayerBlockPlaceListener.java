package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import net.minestom.server.entity.Player;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerBlockPlaceEvent;

public class PlayerBlockPlaceListener implements EventListener<PlayerBlockPlaceEvent> {
    @Override
    public @NotNull Class<PlayerBlockPlaceEvent> eventType() {
        return PlayerBlockPlaceEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerBlockPlaceEvent ev) {
        final Player player = ev.getPlayer();
        
        if (!player.hasPermission("rank.staff.builder"))
            ev.setCancelled(true);

        return Result.SUCCESS;
    }
}
