package algorithm.set;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj10814 {
    /*
    * 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬
    */
    public static void main(String[] args) throws  IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken()); // 회원 수
        ArrayList<Member> members = new ArrayList<>(); // 회원 관리 리스트

        // 회원 정보 저장
        for (int i = 0; i < n; i++) {
            Member member = new Member();
            st = new StringTokenizer(in.readLine());
            member.setAge(Integer.parseInt(st.nextToken()));
            member.setName(st.nextToken());

            members.add(member);
        }

        // 나이 순 정렬 + 가입 순 유지
        // 안정 정렬 사용 (Collections.sort() 또는 List.sort())
        members.sort(Comparator.comparingInt(Member::getAge));


        for (Member m : members) {
            out.write(m.toString() + "\n");

            //toString 오바라이드로 간결화
            //out.write(m.getAge() + " " + m.getName() + "\n");
        }
        out.flush();
    }

    static class Member {
        int age;
        String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
