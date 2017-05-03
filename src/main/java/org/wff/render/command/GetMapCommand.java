package org.wff.render.command;

import com.google.inject.Inject;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.commands.MessageCommand;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;
import org.wff.render.utils.Emoji;
import org.wff.render.utils.Pair;
import org.wff.render.world.GlobalWorldInterface;

import static com.pengrad.telegrambot.request.SendMessage.message;

public class GetMapCommand extends MessageCommand {
    private GlobalWorldInterface globalWorldInterface;

    @Inject
    public GetMapCommand(GlobalWorldInterface globalWorld) {
        super("/map", "map command");
        this.globalWorldInterface = globalWorld;
    }

    @Override
    public void execute(TelegramBot telegramBot, User user, Chat chat, String s) {
        byte[][] world;
        StringBuilder messageBuilder = new StringBuilder();
        world = globalWorldInterface.getWorldMap(new Pair(1, 1));
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                Emoji custom = Emoji.getEmoji(world[i][j]);
                messageBuilder.append(custom.toString());
            }
            messageBuilder.append("\t\n");
        }
        telegramBot.execute(message(chat, messageBuilder.toString()));

    }
}
