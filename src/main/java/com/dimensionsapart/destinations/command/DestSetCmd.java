package com.dimensionsapart.destinations.command;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

/**
 * Created by Caden on 8/19/2016.
 */
public class DestSetCmd implements CommandExecutor {


        @Override
        public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {



            return CommandResult.success();
        }
}
