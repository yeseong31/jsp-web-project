package student;

public class CommandFactory {
	
	private CommandFactory() {}
	
	private static CommandFactory instance = new CommandFactory();
	
	public static CommandFactory getInstance() {
		return instance;
	}
	
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		
		// 학생 정보 조회
		if (cmd.equals("insert")) { cmdIf = new InsertCommand(); } 
		// 학생 정보 삭제
		else if (cmd.equals("delete")) { cmdIf = new DeleteCommand(); } 
		// 학생 정보 검색
		else if (cmd.equals("find")) { cmdIf = new FindCommand(); }
		// 학생 목록 조회
		else if (cmd.equals("list")) { cmdIf = new ListCommand(); }
		// 메인 페이지
		else if (cmd.equals("student")) { cmdIf = new StudentCommand(); } 
		
		return cmdIf;
	}
	
}
	

// 생성자를 private으로 만들면 외부에서 객체를 만들 수 없으므로
// 클래스 안에서 member field로 객체를 생성하고,
// getInstance 메서드를 통해 그 객체를 반환하도록 한다.
// -> "싱글톤 객체"
