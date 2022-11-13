package com.utubz.util;

import java.util.UUID;

import com.google.gson.JsonObject;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.Player;
import net.minestom.server.utils.mojang.MojangUtils;

public class PlayerFinder {
    public static UUID getUuid(String username)
    {
        final JsonObject json = MojangUtils.fromUsername(username);
        if (json == null)
            return null;

        final String uuid = json.get("id").getAsString();
        if (uuid == null)
            return null;
        return UUID.fromString(uuid.substring(0, 8) + "-" + uuid.substring(8, 12) + "-" + uuid.substring(12, 16) + "-" + uuid.substring(16, 20) + "-" + uuid.substring(20, 32));
    }

    public static Entity find(UUID uuid)
    {
        return Player.getEntity(uuid);
    }

    public static Entity find(String username)
    {
        return Player.getEntity(getUuid(username));
    }
}
