package com.dimensionsapart.destinations.command;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.service.pagination.PaginationService;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;

/**
 * Created by Cynic on 8/19/2016.
 */
public class DestCmd implements CommandExecutor {

    PaginationService paginationService = Sponge.getServiceManager().provide(PaginationService.class).get();

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        PaginationList.Builder paginationBuilder = paginationService.builder()
                .title(Text.of(TextColors.DARK_GRAY, "Travel"))
                .contents(
                        Text.of(TextActions.insertText("/destinations "), TextColors.LIGHT_PURPLE, "/dest, /d", TextColors.DARK_PURPLE, " [destination=help]", TextColors.GRAY, "Transport to a destination"),
                        Text.of(TextActions.insertText("/destinations info "), TextColors.LIGHT_PURPLE, "/dest, /d info", TextColors.DARK_PURPLE, " <destination>", TextColors.GRAY, "Get information about a destination"),
                        Text.of(TextActions.runCommand("/destinations list"), TextColors.LIGHT_PURPLE, "/dest, /d list", TextColors.DARK_PURPLE, " [available/all]", TextColors.GRAY, "Fetch a complete list of destinations")
                )
                .header(Text.of(TextColors.DARK_GRAY, "Travel across the world to places you have previously visited"))
                .padding(Text.of(TextColors.GRAY, "-"));
        paginationBuilder.sendTo(src);
        return CommandResult.success();
    }
}
