package com.dimensionsapart.destinations;

import com.dimensionsapart.destinations.command.DestCmd;
import com.dimensionsapart.destinations.command.DestListCmd;
import com.dimensionsapart.destinations.command.DestSetCmd;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.EventManager;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

/**
 * Created by Caden on 8/19/2016.
 */

@Plugin(id = "destinations",
        name = "Destinations",
        description = "Teleportation system for Dimensions Apart",
        url = "http://dimensionsapart.com/plugins/destinations",
        authors = {"mistakenCynic"},
        version = "1.0")
public class Destinations {

    private static Destinations instance;

    @Inject
    private Game game;
    @Inject
    private Logger logger;
    @Inject
    private EventManager eventManager;

    CommandManager cmdService = Sponge.getCommandManager();

    public static Destinations getPlugin() {
        return Destinations.instance;
    }

    @Listener
    public void gameConstruct(GameConstructionEvent event) {
        Destinations.instance = this;
    }

    @Listener
    public void gamePreInit(GamePreInitializationEvent event) {
        logger.info("Travel Plugin (1.0) has started");
    }

    @Listener
    public void gameInit(GameInitializationEvent event) {


        CommandSpec destSetCmd = CommandSpec.builder()
                .description(Text.of("Set a destination"))
                .permission("travel.dest.set")
                .arguments()
                .executor(new DestSetCmd())
                .build();
        CommandSpec destInfoCmd = CommandSpec.builder()
                .description(Text.of("Get information about a specific destination"))
                .permission("travel.dest")
                .arguments()
                .executor(new DestCmd())
                .build();
        CommandSpec destListCmd = CommandSpec.builder()
                .description(Text.of("Fetch a complete list of destinations"))
                .permission("travel.list")
                .executor(new DestListCmd())
                .build();

        CommandSpec destCmd = CommandSpec.builder()
                .description(Text.of("Travel across the world to places you have previously visited."))
                .permission("travel")
                .executor(new DestCmd())
                .child(destListCmd, "list")
                .child(destInfoCmd, "dest")
                .build();
        cmdService.register(this, destCmd, "destinations", "dest", "d", "tp" );
    }

}
