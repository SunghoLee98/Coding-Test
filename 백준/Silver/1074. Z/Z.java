import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2, N);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        dfs(0, N, 0, 0, R, C, 0);
        System.out.println(ans);
    }

    static void dfs(int depth, int N, int x, int y, int R, int C, int cnt){
        int size = N / (int)Math.pow(2, depth);
        if(size == 1) {ans = cnt; return;}
        if(R >= x + size/2 && C >= y + size / 2) dfs(depth+1, N, x + size/2, y + size/2, R, C, cnt + (size*size/4*3));
        else if(R >= x + size/2) dfs(depth+1, N, x + size/2, y, R , C, cnt + (size*size/4*2));
        else if(C >= y + size/2) dfs(depth+1, N, x, y + size/2, R, C, cnt+ (size*size/4*1));
        else dfs(depth+1, N, x, y, R, C, cnt);

    }
}