package student;

public class CommandFactory {
    // 1. private 생성자를 만든다.
    private CommandFactory() {}

    // 2. 내부에서 객체를 생성한다.
    private static final CommandFactory instance = new CommandFactory();

    // 3. static으로 선언된 instance를 내보내는 메서드를 만든다.
    public static CommandFactory getInstance() { return instance; }

    public CommandIf createCommand(String cmd) {
        CommandIf cmdIf = null;
        if (cmd == null || cmd.equals("")) cmd = "index";
        switch (cmd) {
            case "insert" -> cmdIf = new InsertCommand();
            case "delete" -> cmdIf = new DeleteCommand();
            case "find" -> cmdIf = new FindCommand();
            case "list" -> cmdIf = new ListCommand();
            case "index" -> cmdIf = new IndexCommand();
        }
        return cmdIf;
    }
}
