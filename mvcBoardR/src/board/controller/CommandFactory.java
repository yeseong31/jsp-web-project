package board.controller;

public class CommandFactory {
    private CommandFactory() {}

    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() { return instance; }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        switch (cmd) {
            case "/board_list.do" -> cmdIf = new BoardListCommand();
        }
        return cmdIf;
    }
}
