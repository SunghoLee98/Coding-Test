import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] grp = new int[n+1][n+1];
        
        for(int i = 1; i < n+1; i++){
            Arrays.fill(grp[i], 2000002);
            grp[i][i] = 0;
        }
        for(int[] f: fares){
            grp[f[0]][f[1]] = f[2];
            grp[f[1]][f[0]] = f[2];
        }
        
        for(int k = 1; k < n+1; k++){
            for(int i = 1; i < n+1; i++){
                for(int j = 1; j < n+1; j++){
                    grp[i][j] = Math.min(grp[i][j], grp[i][k] + grp[k][j]);
                }
            }
        }
        
        answer = 3000003;
        for(int i = 0; i < n+1; i++){
            answer = Math.min(answer, grp[s][i] + grp[i][a] + grp[i][b]);
        }
        return answer;
    }
}