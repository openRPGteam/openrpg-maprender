import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.listeners.HandlersChainListener;
import com.pengrad.telegrambot.listeners.handlers.UpdateHandler;
import com.pengrad.telegrambot.model.Update;
import org.wff.render.command.GetMapCommand;
import org.wff.render.httpclient.impl.OkHttpFabric;
import org.wff.render.inject.ServiceModule;
import org.wff.render.world.GlobalWorldLocalImpl;

public class Main {
    public static void main(String[] args) {
        final TelegramBot bot;

        Injector injector = Guice.createInjector(new ServiceModule());
        GlobalWorldLocalImpl globalWorldLocal = injector.getInstance(GlobalWorldLocalImpl.class);
        OkHttpFabric client = injector.getInstance(OkHttpFabric.class);

        bot = TelegramBotAdapter.buildCustom(client.getToken(), client.getClient());
        UpdateHandler[] handlers = new UpdateHandler[]{new GetMapCommand(globalWorldLocal)};
        bot.setUpdatesListener(new HandlersChainListener(bot, new UpdateHandler() {
            @Override
            public boolean handle(TelegramBot telegramBot, Update update) {
                return true;
            }
        }, handlers));

    }
}
