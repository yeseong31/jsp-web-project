package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberProImpl implements MemberPro {

    private final List<Member> list;
    private final Scanner in;

    public MemberProImpl() {
        list = new ArrayList<>();
        in = new Scanner(System.in);
    }

    @Override
    public void insert() {
        System.out.print("이름 입력: ");
        String name = in.next();
        System.out.print("전화번호 입력: ");
        String phone = in.next();
        Member member = new Member(name, phone);
        list.add(member);
    }

    @Override
    public void view() {
        for (Member view : list) {
            System.out.println(view.getName() + "님의 전화번호: " + view.getPhone());
        }
    }

    @Override
    public void delete() {
        System.out.print("삭제할 회원 이름 입력: ");
        String name = in.next();
        for (Member delete : list) {
            if (delete.getName().equals(name)) {
                list.remove(delete);
                System.out.println("회원을 삭제했습니다.");
                return;
            }
        }
        System.out.println("회원이 존재하지 않습니다.");
    }

    @Override
    public void edit() {
        System.out.print("수정할 회원 이름 입력: ");
        String name = in.next();
        for (Member edit : list) {
            if (edit.getName().equals(name)) {
                System.out.println("기존 전화번호: " + edit.getPhone());
                System.out.print("새로운 전화번호 입력: ");
                String phone = in.next();
                edit.setPhone(phone);
                System.out.println("회원 전화번호를 수정했습니다.");
                return;
            }
        }
        System.out.println("회원이 존재하지 않습니다.");
    }

    @Override
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

}
