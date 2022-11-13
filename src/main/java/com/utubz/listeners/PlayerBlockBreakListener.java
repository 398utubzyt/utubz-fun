package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import net.minestom.server.entity.Player;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerBlockBreakEvent;

public class PlayerBlockBreakListener implements EventListener<PlayerBlockBreakEvent> {
    @Override
    public @NotNull Class<PlayerBlockBreakEvent> eventType() {
        return PlayerBlockBreakEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerBlockBreakEvent ev) {
        final Player player = ev.getPlayer();
        
        if (!player.hasPermission("rank.staff.builder"))
            ev.setCancelled(true);

        return Result.SUCCESS;
    }
}
