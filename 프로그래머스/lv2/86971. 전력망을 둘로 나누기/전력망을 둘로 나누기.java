import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.lang.Math;
class Solution {
    public int solution(int n, int[][] wires) {
        ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++)
            grp.add(new ArrayList<Integer>());
        
        for(int[] eachwire: wires){
            grp.get(eachwire[0]).add(eachwire[1]);
            grp.get(eachwire[1]).add(eachwire[0]);
        }
        
        //와이어를 하나씩 끊어보며
        System.out.println(grp);
        boolean nvis[] = new boolean[n+1];
        Arrays.fill(nvis, true);
        
        Stack<Integer> dfs = new Stack<>();
        ArrayList<Integer> clses = new ArrayList<>();
        
        int cnt, node;
        int cls = n / 2;
        int answer = n + 1;
        System.out.println(cls);
        for(int[] eachwire: wires){
            grp.get(eachwire[0]).remove(Integer.valueOf(eachwire[1]));
            grp.get(eachwire[1]).remove(Integer.valueOf(eachwire[0]));
            dfs.push(1);
            //탐색
            cnt = 0;
            while(!dfs.empty()){
                node = dfs.pop();
                cnt++;
                nvis[node] = false;
                for(Integer eachN: grp.get(node)){
                    if(nvis[eachN])
                        dfs.push(eachN); 
                }           
            }
            //탐색 종료
            answer = (Math.abs(n-2*cnt) < answer) ? Math.abs(n-2*cnt) : answer;
            Arrays.fill(nvis,true);
            grp.get(eachwire[0]).add(eachwire[1]);
            grp.get(eachwire[1]).add(eachwire[0]);
        }
        return answer;
    }
}