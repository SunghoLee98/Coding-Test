import java.util.*;
class Solution {
    HashSet<Integer> his = new HashSet<Integer>();
    public int solution(int k, int[][] dungeons) {
        boolean[] vis = new boolean[dungeons.length];
        int answer = -1;
        
        Arrays.fill(vis, false);
        
        dfs(dungeons, vis, k, 0);
        
        for(Integer e: his)
            answer = (e > answer) ? e : answer;
        return answer;
    }
    
    public void dfs(int[][] dungeons, boolean[] vis, int tir, int cnt){
       // System.out.println(Arrays.toString(vis) + " " + cnt);

            
        for(int i = 0; i < vis.length; i++){
            if( vis[i] ||  (dungeons[i][0] > tir))
                continue;
            //방문 아직 안했다면
            vis[i] = true;
            dfs(dungeons, vis, tir-dungeons[i][1], cnt + 1);
            vis[i] = false;
        }
        //System.out.println(cnt);
        his.add(cnt);
    }
}