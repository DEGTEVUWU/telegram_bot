package tg_bot.telegram_bot.commands;

public enum TelegramCommands {
    START_COMMAND("/start"),
    CLEAR_COMMAND("/clear");

    private final String commandValue;

    TelegramCommands(String commandValue) {
        this.commandValue = commandValue;
    }
    public String getCommandValue() {
        return commandValue;
    }

}
