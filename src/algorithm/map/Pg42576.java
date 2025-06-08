package algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class Pg42576 { //완주하지 못한 선수
    //https://school.programmers.co.kr/learn/courses/30/lessons/42576
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. -> 이중for문이면 10만X10만 100억 -> 100초
        // map 키값 중복 안됨 -> 최선: O(1), 최악:  O(N)
        // value 중복 됨
        // 참가자 이름 중복 될 수 있음
        // return (((v = get(key)) != null) || containsKey(key))  ? v : defaultValue;
        // -> 키값이 있으면 키값 반환 없으면 디폴트값 반환
        // 참가자 명단 - 완주명단 = completion에 없는 사람

        Map<String, Integer> comp = new HashMap<>();
        for(int i=0; i < completion.length; i++){
            Integer standard = 1;
            Integer res =  comp.containsKey(completion[i]) ? standard+1 : standard;
            comp.put(completion[i], res);
        }

        for(int i=0; i < participant.length; i++){
            //comp.getOrDefault(participant[i], 0);
            if(!comp.containsKey(participant[i])){
                answer = participant[i];
            }
        }
        int mid = answer.length()/2;

        return answer;
    }

}
