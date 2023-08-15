import java.io.*;
import java.util.*;

public class Main {
    static int blue = 0, white = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map, 0, 0, 0, N);
        System.out.print(white + "\n" + blue);

    }
    public static void dfs(int[][] map, int depth, int x, int y, int N){
        int cnt = 0, size = N / (int)Math.pow(2, depth);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cnt += map[x+i][y+j];
            }
        }

        if(cnt == 0) {white++; return;}
        else if (cnt == size * size) {blue++; return;}

        dfs(map, depth+1, x, y, N);
        dfs(map, depth+1, x + size/2, y, N);
        dfs(map, depth+1, x, y + size/2, N);
        dfs(map, depth+1, x + size/2, y + size/2,  N);
    }
}