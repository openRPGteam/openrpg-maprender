package org.wff.render.command;

import com.google.inject.Inject;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.commands.MessageCommand;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.User;
import org.wff.render.utils.Emoji;
import org.wff.render.utils.Pair;
import org.wff.render.world.GlobalWorldInterface;

import java.util.List;

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
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 1; i <= 10; ++i) {
            List<Emoji> custom = globalWorldInterface.getWorldMap(new Pair(1, 1));
            for (Emoji e : custom) {
                messageBuilder.append(e.toString());
            }
            messageBuilder.append("\t\n");
        }
        telegramBot.execute(message(chat, messageBuilder.toString()));

    }
}
