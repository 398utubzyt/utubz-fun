package com.utubz.listeners;

import org.jetbrains.annotations.NotNull;

import com.utubz.Main;
import com.utubz.ranking.Ranks;

import net.minestom.server.entity.Player;
import net.minestom.server.event.EventListener;
import net.minestom.server.event.player.PlayerLoginEvent;

public class PlayerLoginListener implements EventListener<PlayerLoginEvent> {
    @Override
    public @NotNull Class<PlayerLoginEvent> eventType() {
        return PlayerLoginEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull PlayerLoginEvent ev) {
        final Player player = ev.getPlayer();
        ev.setSpawningInstance(Main.instContainer);
        player.setRespawnPoint(Main.GLOBAL_RESPAWN_POINT);
        if (player.getUuid().toString().matches("4ce8720c-f7a0-4044-b1d7-e908ebe00c1c"))
            Ranks.OWNER.apply(player);
        else 
            Ranks.DEFAULT.apply(player);
        return Result.SUCCESS;
    }
}
