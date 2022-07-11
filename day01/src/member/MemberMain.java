package member;

import java.io.IOException;

public class MemberMain {

    public static void main(String[] args) throws IOException {
        MemberPro pro = new MemberProImpl();
        // MemberPro pro2 = new MemberProImpl2();

        while (true) {
            System.out.println("-----------------------------------------------");
            System.out.println("1. 입력 / 2. 출력 / 3. 삭제 / 4. 수정 / 5. 종료");
            // 한 글자를 입력 받음 (Scanner를 사용해도 무방함)
            int select = System.in.read() - 48;
            System.in.skip(5);  // '엔터 키' 입력 무시

            switch (select) {
                case 1 -> pro.insert();
                case 2 -> pro.view();
                case 3 -> pro.delete();
                case 4 -> pro.edit();
                case 5 -> pro.exit();
                default -> {System.out.println("잘못 입력했습니다. 다시 입력해 주세요."); return;}
            }
        }
    }

}
