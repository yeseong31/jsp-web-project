package board.controller;

public class CommandFactory {

	private CommandFactory() {}
	
	private static final CommandFactory instance = new CommandFactory();
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		return switch (cmd) {
			case "/board_list.do" -> new BoardListCommand();
			case "/board_writeForm.do" -> new BoardWriteFormCommand();
			case "/board_writePro.do" -> new BoardWriteProCommand();
			case "/board_content.do" -> new BoardContentCommend();
			case "/board_deleteForm.do" -> new BoardDeleteCommand();
			case "/board_deletePro.do" -> new BoardDeleteProCommand();
			case "/board_updateForm.do" -> new BoardUpdateCommand();
			case "/board_updatePro.do" -> new BoardUpdateProCommand();
			default -> null;
		};
	}
	
}
