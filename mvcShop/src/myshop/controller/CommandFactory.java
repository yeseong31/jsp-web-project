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
            case "/prod_input.mall" -> cmdIf = new ProdInputCommand();
            case "/prod_input_ok.mall" -> cmdIf = new ProdInputOkCommand();
            case "/prod_list.mall" -> cmdIf = new ProdListCommand();
            case "/prod_delete.mall" -> cmdIf = new ProdDeleteCommand();
            case "/prod_view.mall" -> cmdIf = new ProdViewCommand();
            case "/prod_update.mall" -> cmdIf = new ProdUpdateCommand();
            case "/prod_update_ok.mall" -> cmdIf = new ProdUpdateOkCommand();
            case "/mall.mall" -> cmdIf = new MallCommand();
            case "/cgProdList.mall" -> cmdIf = new MallCgProdListCommand();
            case "/prodView.mall" -> cmdIf = new MallProdViewCommand();
        }
        return cmdIf;
    }
}
