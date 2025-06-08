package algorithm.stack;

class Pg12909 { //올바른 괄호
    //https://school.programmers.co.kr/learn/courses/30/lessons/12909
    boolean solution(String s) {
        boolean answer = true;
        int cnt = 0;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // () : stack 자료구조 / pair / 남아있거나
        //s.length() <= 100,000 십만

       char[] elements = s.toCharArray();
       for(int i=0; i< elements.length; i++){
          if(cnt < 0) return false;
          if(elements[i] == '('){
              // 열린만큼 닫힌다
              cnt++;
          }else {
              cnt--;
          }
       }
       if(cnt !=0) return false;
       return answer;
    }
}
