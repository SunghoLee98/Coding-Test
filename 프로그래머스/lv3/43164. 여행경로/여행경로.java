import java.util.*;

class Solution {
    Stack<String> stk = new Stack<>();
    int idx = 1;
    int len;
    boolean done = false;
    public String[] solution(String[][] tickets) {
        
        boolean[] vis = new boolean[tickets.length];
        
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });
        
        Arrays.fill(vis, false);
        dfs(vis, tickets, "ICN");
        
        len = stk.size();
        
        String[] answer = new String[len];
        
        
        while(!stk.isEmpty()){
            System.out.print(stk.peek() + " ");
            answer[len - idx] = stk.pop();
            idx++;
        }
        return answer;
    }
    
    public void dfs(boolean[] vis, String[][] tickets, String node){ 
        if(stk.size() == tickets.length){
            stk.add(node);
            return;
            }
        System.out.println(node);
        for(int i = 0; i < vis.length; i++){
            if(vis[i] || !(node.equals(tickets[i][0])))
                continue;
            vis[i] = true;
            stk.add(node);
            dfs(vis, tickets, tickets[i][1]);
            if(stk.size() > tickets.length)
                return;
            stk.pop();
            vis[i] = false;
        }    
    }
}