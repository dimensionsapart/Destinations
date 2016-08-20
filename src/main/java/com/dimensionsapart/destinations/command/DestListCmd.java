package com.dimensionsapart.destinations.command;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationService;

/**
 * Created by Cynic on 8/19/2016.
 */
public class DestListCmd implements CommandExecutor {

    PaginationService paginationService = Sponge.getServiceManager().provide(PaginationService.class).get();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {



        return CommandResult.success();
    }
}