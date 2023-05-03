import java.util.*;
class Solution {
    int answer = 0;
    Queue<Integer[]> bfs  = new LinkedList<>();
    ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
    int cnt, idx, acnt;
    boolean zcnt = false;
    Integer[] node;
    public int solution(String begin, String target, String[] words) {
        //가장 짧다 -> bfs?
        int lens = words.length;
        int clen = begin.length();
        boolean[] vis = new boolean[lens + 1];
        
        Arrays.fill(vis, false);
        for(int i = 0; i < lens + 1; i++)
            grp.add(new ArrayList<Integer>());
        
        idx = 0;
        for(String e: words){
            cnt = 0;
            idx++;
            if(e.equals(target))
                zcnt = true;
            for(int i = 0; i < clen; i++){
                if(begin.charAt(i) != e.charAt(i))
                    cnt++;
            }
            if(cnt == 1)
                grp.get(0).add(idx);
        
            for(int i = 0; i < lens; i++){
                if(e.equals(words[i]))
                    continue;
                acnt = 0;
                for(int j = 0; j < clen; j++){
                    if(e.charAt(j) != words[i].charAt(j))
                        acnt++;
                }
                if(acnt == 1)
                grp.get(idx).add(i+1);
                
            } 
        }
        if(!zcnt)
            return 0;
        
        
        Integer[] tmp = {0,0};
        bfs.add(tmp);
        vis[0] = true;
        while(!bfs.isEmpty()){     
            node = bfs.remove();
            if (node[0] != 0)
                {if(words[node[0] - 1].equals(target))
                    return node[1];}
            
            for(Integer n: grp.get(node[0])){
                if(vis[n])
                    continue;
                Integer[] newNode = {n, node[1] + 1};
                //System.out.println(node[0] + "   added" + n + "   len:" + (node[1]+1));
                bfs.add(newNode);
                vis[n] = true;      
            }
          // System.out.println("done;");  
        } 
        return answer;
    //aab -> abb
    //abb -> aba
    //aba -> abb
        
    
    }
}