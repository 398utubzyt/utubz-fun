package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import com.utubz.util.Chat;
import com.utubz.util.Text;

import net.minestom.server.entity.Player;
import net.minestom.server.entity.PlayerSkin;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerSpawnEvent;

public class PlayerSpawnListener implements EventListener<PlayerSpawnEvent> {
    @Override
    public @NotNull Class<PlayerSpawnEvent> eventType() {
        return PlayerSpawnEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerSpawnEvent ev) {
        final Player player = ev.getPlayer();
        player.setSkin(PlayerSkin.fromUuid(player.getUuid().toString()));

        Chat.announce(Text.combine(ev.getPlayer().getUsername(), Text.yellow(" has joined the game!")));

        Chat.send(player, Text.combine(Text.blue("Welcome to the Utubz Clubhoue, "), Text.aqua(player.getUsername()), Text.blue("!")));
        player.setEnableRespawnScreen(false);

        return Result.SUCCESS;
    }
}
