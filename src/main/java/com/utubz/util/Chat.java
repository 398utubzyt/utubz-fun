package com.utubz.util;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.minestom.server.adventure.audience.Audiences;

public class Chat {
    public static void send(Audience audience, Component message) {
        audience.sendMessage(message);
    }

    public static void log(Component message) {
        Audiences.console().sendMessage(message);
    }

    public static void announce(Component message) {
        Audiences.all().sendMessage(message);
    }
}
