/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone.command.defaults;

import baritone.api.IBaritone;
//import baritone.api.bot.IBaritoneUser;
//import baritone.api.bot.connect.IConnectionResult;
import baritone.api.command.Command;
import baritone.api.command.argument.IArgConsumer;
import baritone.api.command.exception.CommandException;
import baritone.api.command.exception.CommandInvalidTypeException;
//import baritone.bot.UserManager;
//import net.minecraft.util.Session;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Cxzlw
 * @since 12/14/2020
 */
public class SayCommand extends Command {

    public SayCommand(IBaritone baritone) {
        super(baritone, "say");
    }

    @Override
    public void execute(String label, IArgConsumer args) throws CommandException {
        if (args.hasExactly(0)) {
            throw new CommandInvalidTypeException(args.consumed(), "an string");

        } else {
//            baritone.getPlayerContext().player().sendChatMessage(args.consumedString());
//            baritone.getPlayerContext().player().sendChatMessage(label);
            baritone.getPlayerContext().player().sendChatMessage(args.rawRest());
        }
    }

    @Override
    public Stream<String> tabComplete(String label, IArgConsumer args) {
        return Stream.empty();
    }

    @Override
    public String getShortDesc() {
        return "Say a string";
    }

    @Override
    public List<String> getLongDesc() {
        return Arrays.asList(
                "Say a string",
                "",
                "Usage:",
                "> say <string>"
        );
    }


}

