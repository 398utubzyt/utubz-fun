package com.utubz.ranking;

import java.util.Map;

import org.jetbrains.annotations.NotNull;
import org.jglrxavpok.hephaistos.nbt.NBTCompound;
import org.jglrxavpok.hephaistos.nbt.NBTString;

import net.kyori.adventure.text.Component;
import net.minestom.server.entity.Player;
import net.minestom.server.permission.Permission;

public abstract class Rank {
    private final String id;
    private final Component displayName;
    private final int priority;
    private final String[] permissions;


    public String getId() { return id; }
    public Component getDisplayName() { return displayName; }
    public int getPriority() { return priority; }
    public String[] getPermissions() { return permissions; }

    public boolean atLeast(int priority) { return this.priority >= priority; }
    public boolean atLeast(Rank rank) { return priority >= rank.priority; }
    public boolean equals(int priority) { return this.priority == priority; }
    public boolean equals(Rank rank) { return priority == rank.priority; }
    public boolean hasPermission(String permission) { for (int i = 0; i < permissions.length; i++) if (permissions[i].startsWith(permission)) return true; return false; }

    public void apply(Player player)
    {
        player.getAllPermissions().forEach(p -> { if (p.getPermissionName().startsWith("rank")) player.removePermission(p); });

        player.addPermission(new Permission("rank", new NBTCompound(Map.of("id", new NBTString(id)))));
        for (int i = 0; i < permissions.length; i++)
            player.addPermission(new Permission(permissions[i]));
    }

    public Rank(@NotNull String id, @NotNull Component displayName, int priority, @NotNull String... permissions)
    {
        this.id = id;
        this.displayName = displayName;
        this.priority = priority;
        this.permissions = permissions;
    }
}
