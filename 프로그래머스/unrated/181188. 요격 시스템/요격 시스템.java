import java.util.*;

class Solution {
    HashSet<Integer[]> set = new HashSet<Integer[]>();
    boolean done;
    public int solution(int[][] targets) {
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
            
        for(int[] t: targets){
            done = false;
            for(Integer[] s: set){
                //t가 s중 겹치는 공간이 있나?
                //없다면 어떡하지ㅎㅎ
                //s가 targets보다 왼쪽에 존재하는건 확정, 
                
                if(s[1] > t[0]){ // 이래야 겹침
                    done = true;
                    s[0] = (s[0] < t[0]) ? t[0] : s[0];
                    break;
                }
            }
            if(!done)
                set.add(new Integer[]{t[0],t[1]});
        }
        return set.size();
    }
}