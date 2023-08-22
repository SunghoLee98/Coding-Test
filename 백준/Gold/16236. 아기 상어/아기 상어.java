import java.io.*;
import java.util.*;

class Shark implements Comparable<Shark>{
    int size;
    int x;
    int y;
    int dist = 0;
    int ate = 0;

    public Shark(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public Shark clone(int tx, int ty) {
        Shark copy = new Shark(tx, ty, this.size);

        copy.dist = this.dist+1;
        copy.ate = this.ate;

        return copy;
    }

    @Override
    public int compareTo(Shark p) {
        if(dist != p.dist) return dist - p.dist;

        if(x != p.x) return x - p.x;

        return y - p.y;
    }

}

public class Main {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        Shark shark = new Shark(-1, -1, 2);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9) {
                    shark.x = i;
                    shark.y = j;
                    map[i][j] = 0;
                }
            }
        }

        int ans = 0;
        do {
            ans += shark.dist;
            shark = findFish(map, shark, N);
        }while(shark.dist != -1);
        System.out.println(ans);
    }

    public static Shark findFish(int[][] map, Shark shark, int N) {
        PriorityQueue<Shark> q = new PriorityQueue<>();
        boolean[][] v = new boolean[N][N];

        shark.dist = 0;
        q.add(shark);
        v[shark.x][shark.y] = true;
        int tx, ty;
        while(!q.isEmpty()) {
            shark = q.poll();


            if(map[shark.x][shark.y]  > 0 && map[shark.x][shark.y]  < shark.size) {
                map[shark.x][shark.y] = 0;
                if(++shark.ate == shark.size) {
                    shark.size++;
                    shark.ate = 0;
                }
                return shark;
            }
            for(int i = 0; i < 4; i++) {
                tx = shark.x + dx[i];
                ty = shark.y + dy[i];

                if(isOut(tx, ty, N)) continue;
                if(v[tx][ty] || map[tx][ty] > shark.size) continue;

                v[tx][ty] = true;
                q.add(shark.clone(tx, ty));
            }
        }

        shark.dist = -1;
        return shark;
    }

    public static boolean isOut(int x, int y, int N) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

}