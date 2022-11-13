package com.utubz;

import com.utubz.commands.*;
import com.utubz.listeners.*;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.instance.*;
import net.minestom.server.instance.block.Block;
import net.minestom.server.coordinate.Pos;

public class Main {
    public static final Pos GLOBAL_RESPAWN_POINT = new Pos(0, 42, 0);
    public static final String MOTD = "§c§l§kO§r §c§lUTUBZ FUN ZONE §kO";
    public static final int PORT = 3981;
    public static final int MAX_PLAYERS = 4;

    public static MinecraftServer mcServer;
    public static InstanceManager instManager;
    public static InstanceContainer instContainer;
    public static CommandManager cmdManager;
    public static GlobalEventHandler evHandler;
    public static ComponentLogger logger;

    public static void main(String[] args) {
        mcServer = MinecraftServer.init();
        instManager = MinecraftServer.getInstanceManager();
        logger = MinecraftServer.LOGGER;
        
        instContainer = instManager.createInstanceContainer();
        instContainer.setGenerator(unit -> {
            unit.modifier().fillHeight(0, 40, Block.GRASS_BLOCK);
            unit.modifier().fillHeight(41, 256, Block.AIR);
        });
        
        MinecraftServer.setBrandName("Utubz");

        MojangAuth.init();

        cmdManager = MinecraftServer.getCommandManager();
        cmdManager.setUnknownCommandCallback((sender, msg) -> { ServerCommand.reportError(sender, "That command does not exist."); });
        cmdManager.register(new StopCommand());
        cmdManager.register(new GamemodeCommand());
        cmdManager.register(new GiveCommand());
        cmdManager.register(new RankCommand());
        
        evHandler = MinecraftServer.getGlobalEventHandler();
        evHandler.addListener(new ServerListPingListener());
        evHandler.addListener(new PlayerBlockPlaceListener());
        evHandler.addListener(new PlayerBlockBreakListener());
        evHandler.addListener(new PlayerChatListener());
        evHandler.addListener(new PlayerSkinInitListener());
        evHandler.addListener(new PlayerSpawnListener());
        evHandler.addListener(new PlayerDisconnectListener());
        evHandler.addListener(new PlayerLoginListener());

        mcServer.start("0.0.0.0", PORT);
    }
}
