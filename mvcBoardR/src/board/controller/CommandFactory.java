package board.controller;

public class CommandFactory {
    private CommandFactory() {}

    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() { return instance; }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        switch (cmd) {
            case "/board_list.do" -> cmdIf = new BoardListCommand();
            case "/board_write.do" -> cmdIf = new BoardWriteCommand();
            case "/board_writePro.do" -> cmdIf = new BoardWriteProCommand();
            case "/board_content.do" -> cmdIf = new BoardContentCommand();
            case "/board_update.do" -> cmdIf = new BoardUpdateCommand();
            case "/board_updatePro.do" -> cmdIf = new BoardUpdateProCommand();
            case "/board_delete.do" -> cmdIf = new BoardDeleteCommand();
            case "/board_deletePro.do" -> cmdIf = new BoardDeleteProCommand();
        }
        return cmdIf;
    }
}
