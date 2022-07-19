package myshop.controller;

public class CommandFactory {
    private CommandFactory() {}

    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() { return instance; }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        switch (cmd) {
            case "/admin.mall" -> cmdIf = new AdminCommand();
            case "/cate_input.mall" -> cmdIf = new CateInputCommand();
            case "/cate_input_ok.mall" -> cmdIf = new CateInputOkCommand();
            case "/cate_list.mall" -> cmdIf = new CateListCommand();
            case "/cate_delete.mall" -> cmdIf = new CateDeleteCommand();
        }
        return cmdIf;
    }
}
