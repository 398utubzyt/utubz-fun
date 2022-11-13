package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import com.utubz.Main;

import net.minestom.server.entity.PlayerSkin;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerSkinInitEvent;

public class PlayerSkinInitListener implements EventListener<PlayerSkinInitEvent> {
    @Override
    public @NotNull Class<PlayerSkinInitEvent> eventType() {
        return PlayerSkinInitEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerSkinInitEvent ev) {
        final PlayerSkin skin = PlayerSkin.fromUuid(ev.getPlayer().getUuid().toString());
        if (skin == null)
        {
            Main.logger.error("Could not load " + ev.getPlayer().getUsername() + "'s skin.");
            return Result.EXCEPTION;
        }
        ev.setSkin(skin);
        return Result.SUCCESS;
    }
}
