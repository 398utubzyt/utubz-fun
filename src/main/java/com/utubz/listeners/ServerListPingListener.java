package com.utubz.listeners;

import net.kyori.adventure.text.Component;

import net.minestom.server.event.server.ServerListPingEvent;
import net.minestom.server.event.EventListener;
import net.minestom.server.ping.ResponseData;

import org.jetbrains.annotations.NotNull;

import com.utubz.Main;

public class ServerListPingListener implements EventListener<ServerListPingEvent> {
    private final ResponseData response = new ResponseData();

    public ServerListPingListener() {
        response.setMaxPlayer(Main.MAX_PLAYERS);
        response.setDescription(Component.text(Main.MOTD));
    }

    @Override
    public @NotNull Class<ServerListPingEvent> eventType() {
        return ServerListPingEvent.class;
    }

    @Override
    public @NotNull Result run(@NotNull ServerListPingEvent ev) {
        response.setOnline(2);
        ev.setResponseData(response);
        return Result.SUCCESS;
    }
}
