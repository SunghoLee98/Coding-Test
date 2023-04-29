import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] nvis = new boolean[n];
        ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
        Stack<Integer> dfs = new Stack<>();
        int answer = 0;
        int node;
        
        Arrays.fill(nvis, true);
        for(int i = 0; i < n; i++)
            grp.add(new ArrayList<Integer>());
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                //i가 나, j가 상대
                if(i == j)
                    continue;
                if(computers[i][j] == 0)
                    continue;
                grp.get(i).add(j);
                grp.get(j).add(i);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!nvis[i])
                continue;
            answer++;
            dfs.push(i);
            while(!dfs.isEmpty()){
                node = dfs.pop();
                nvis[node] = false;

                for(Integer e: grp.get(node)){
                    if(nvis[e])
                        dfs.push(e);
                }
            }
        }
        return answer;
    }
}