import java.util.*;

class Node{
    int x,y;
    int way = 0;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    Node(int x, int y, int way){
        this.x = x;
        this.y = y;
        this.way = way;
    }
    Node(Node node){
        this.x = node.x;
        this.y = node.y;
        this.way = node.way;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        Node n = (Node) obj;
        if((n.x == this.x) && (n.y == this.y)) return true;
        else return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    Queue<Node> bfs = new LinkedList<>();
    Node node = new Node(-1, -1);
    Node temp = new Node(-1, -1);
    boolean[][] vis = new boolean[101][101];
    HashMap<Integer, HashSet<Node>> wy = new HashMap<Integer,HashSet<Node>>(4);
    int rSize = 0;    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        //from CX, CY -> to iX, iY
        //SET에 먼저 걸림돌을 다 넣어 놓는다?
        // 좌측하단 : (r[0], r[1]) 우측상단 : (r[2], r[3])
        //해쉬 맵으로, 직사각형마다 같은 키, 다른 밸류로...
        HashSet<Node> ob = new HashSet<Node>();
        for(int i = 0; i < 101; i++)
            Arrays.fill(vis[i], false);
        
        for(int[] r: rectangle){
            for(int i = r[0] * 2 + 1; i < r[2] * 2; i++){
                for(int j = r[1] * 2 + 1; j < r[3] * 2; j++){
                    Node tmp = new Node(i, j);              
                    ob.add(tmp);
                }
            }
        }     
        
        for(int[] r: rectangle){
            HashSet<Node> newr = new HashSet<Node>(400);
            for(int i = r[0] * 2; i < r[2] * 2 + 1; i++){
                Node r1 = new Node(i, r[1] * 2);
                Node r2 = new Node(i, r[3] * 2);
                if(!ob.contains(r1))
                    newr.add(r1);
                if(!ob.contains(r2))
                    newr.add(r2);
            }
            for(int i = r[1] * 2; i < r[3] * 2 + 1; i++){
                Node c1 = new Node(r[0] * 2, i);
                Node c2 = new Node(r[2] * 2, i);
                if(!ob.contains(c1))
                    newr.add(c1);
                if(!ob.contains(c2))
                    newr.add(c2);
            }
            wy.put(rSize, newr);
            rSize++;
        }
                
        Node me = new Node(characterX * 2, characterY * 2);
        Node des = new Node(itemX * 2, itemY * 2);
        bfs.add(me);
        vis[me.x][me.y] = true;
        
        while(!bfs.isEmpty()){
            node = bfs.poll();
            
            if(node.equals(des))
                return node.way / 2;
            node.way += 1;
            for(int i = 0; i < 4; i++){
                Node temp = new Node(node);
                temp.x += dx[i];
                temp.y += dy[i];
                
                if((temp.x < 0) || (temp.x > 100) || (temp.y < 0) || (temp.y > 100))
                    continue;
                if(vis[temp.x][temp.y])
                    continue;
                if(!check(node, temp))
                    continue;
                
                vis[temp.x][temp.y] = true;
                bfs.add(temp);
            }
        }
       
        int answer = 0;
        return answer;
    }
    
    public boolean check(Node crr, Node pas){
        for(int i = 0; i < rSize; i++){
            HashSet<Node> tempSet = wy.get(i);
            if(tempSet.contains(crr) && tempSet.contains(pas))
                return true;
        }
        return false;
    }
}