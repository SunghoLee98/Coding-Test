import java.util.*;

class Solution {
    int answer = -1;
    int col, row;
        
    public int solution(int[][] maps) {
        int mcol = maps.length;
        int mrow = maps[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int[] node = new int[]{0,0,1};
        boolean[][] nvis = new boolean[mcol][mrow]; 
        
        for (int i = 0; i < mcol; i++)
            Arrays.fill(nvis[i], true);
        
        bfs.add(node);
        while(!bfs.isEmpty() && (node[2] < 10001)){
            node = bfs.poll();
            if((node[0] == (mcol-1)) && (node[1] == (mrow-1))){
                //도착지 도착
                answer = node[2];
                break;
            }
            col = node[0];
            row = node[1];
            node[2]++;
            
            if (col != 0) {
                node[0] = col-1;
                if(maps[node[0]][node[1]] != 0){
                    maps[node[0]][node[1]] = 0;
                    int[] temp = node.clone();
                    bfs.add(temp);
                    //System.out.println("x: " + node[0] + "  y: " + node[1] + "  len: " + node[2]);
                    
                }
            }
            if (col != (mcol-1)){
                node[0] = col+1;
                if(maps[node[0]][node[1]] != 0){
                    maps[node[0]][node[1]] = 0;
                    int[] temp = node.clone();
                    bfs.add(temp);
                   // System.out.println("x: " + node[0] + "  y: " + node[1] + "  len: " + node[2]);
                }
            }
            node[0] = col;
            if (row != 0) {
                node[1] = row-1;
                if(maps[node[0]][node[1]] != 0){
                    maps[node[0]][node[1]] = 0;
                    int[] temp = node.clone();
                    bfs.add(temp);
                  //  System.out.println("x: " + node[0] + "  y: " + node[1] + "  len: " + node[2]);
                }
            }
            if (row != (mrow-1)){
                node[1] = row+1;   
                if(maps[node[0]][node[1]] != 0){
                    maps[node[0]][node[1]] = 0;
                    int[] temp = node.clone();
                    bfs.add(temp);
                   // System.out.println("x: " + node[0] + "  y: " + node[1] + "  len: " + node[2]);
                }
            }    
        }        
        return answer;
    }
}