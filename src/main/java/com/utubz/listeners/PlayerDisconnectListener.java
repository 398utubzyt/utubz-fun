package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerDisconnectEvent;

public class PlayerDisconnectListener implements EventListener<PlayerDisconnectEvent> {
    @Override
    public @NotNull Class<PlayerDisconnectEvent> eventType() {
        return PlayerDisconnectEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerDisconnectEvent ev) {
        Chat.announce(Text.combine(ev.getPlayer().getUsername(), Text.yellow(" has left the game!")));
        return Result.SUCCESS;
    }
}
