import java.io.*;
import java.util.*;

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0, x, y, tx, ty, node, population, cnt;
        boolean flag = true;
        ArrayDeque<Integer> q, union;
        boolean[][] v;
        while(flag) {
            flag = false;
            q = new ArrayDeque<>();
            union = new ArrayDeque<>();
            v = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(v[i][j]) continue;

                    population = map[i][j];
                    cnt = 1;
                    v[i][j] = true;
                    q.add(i * N + j);
                    union.add(i * N + j);
                    while(!(q.isEmpty())) {
                        node = q.poll();

                        x = node / N;
                        y = node % N;

                        for(int k = 0; k < 4; k++) {
                            tx = x + dx[k];
                            ty = y + dy[k];

                            if(isOut(tx, ty, N)) continue;
                            if(!isUnion(map, x, y, tx, ty, L, R) || v[tx][ty]) continue;

                            population += map[tx][ty];
                            cnt++;
                            v[tx][ty]  = true;
                            q.add(tx * N + ty);
                            union.add(tx * N + ty);
                        }
                    }

                    if(cnt <= 1) {
                        union.clear();
                        continue;
                    }
                    population /= cnt;
                    while(!(union.isEmpty())) {
                        node = union.poll();
                        flag  = true;
                        map[node/N][node%N] = population;
                    }
                }
            }
            ans++;
        }
        System.out.println(ans-1);
    }

    public static boolean isOut(int x, int y, int N) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    public static boolean isUnion(int[][] map, int x, int y, int tx, int ty, int L, int R) {
        return Math.abs(map[x][y] - map[tx][ty]) <= R && Math.abs(map[x][y] - map[tx][ty]) >= L;
    }

}