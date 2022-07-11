package member;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class MemberProImpl2 implements MemberPro {

    private final Hashtable<String, Member> map;
    private final Scanner in;

    public MemberProImpl2() {
        this.map = new Hashtable<String, Member>();
        this.in = new Scanner(System.in);
    }

    @Override
    public void insert() {
        String name;
        do {
            System.out.print("이름 입력: ");
            name = in.next();
        } while (map.containsKey(name));
        System.out.print("전화번호 입력: ");
        String phone = in.next();
        map.put(name, new Member(name, phone));
    }

    @Override
    public void view() {
        Set<String> set = map.keySet();
        for (String name : set) {
            Member view = map.get(name);
            System.out.println(view.getName() + "님의 전화번호: " + view.getPhone());
        }
    }

    @Override
    public void delete() {
        System.out.print("삭제할 회원 이름 입력: ");
        String name = in.next();
        if (map.containsKey(name)) {
            map.remove(name);
            System.out.println("회원을 삭제했습니다.");
            return;
        }
        System.out.println("회원이 존재하지 않습니다.");
    }

    @Override
    public void edit() {
        System.out.print("수정할 회원 이름 입력: ");
        String name = in.next();
        if (map.containsKey(name)) {
            System.out.println("기존 전화번호: " + map.get(name).getPhone());
            System.out.print("새로운 전화번호 입력: ");
            String phone = in.next();
            map.get(name).setPhone(phone);
            System.out.println("회원 전화번호를 수정했습니다.");
            return;
        }
        System.out.println("회원이 존재하지 않습니다.");
    }

    @Override
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

}
