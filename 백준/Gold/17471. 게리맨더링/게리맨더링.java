import java.util.*;
import java.io.*;

public class Main {
    static int ans = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] populations = new int[N + 1];
        boolean[][] grp = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++)
            populations[i] = Integer.parseInt(st.nextToken());

        int num;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                grp[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i = 1; i < N; i++)
            comb(grp, populations, N, i, new int[i], 0, 1);

        ans = (ans == 1000) ? -1 : ans;
        System.out.println(ans);
    }

    public static void comb(boolean[][] grp, int[] populations, int N, int r, int[] area, int depth, int index) {
        if (depth == r) {
            if (isAvailable(grp, N, area)) {
                ans = Math.min(ans, calculatePopulation(populations, area, N));
            }
            return;
        }

        for (int i = index; i < N + 1; i++) {
            area[depth] = i;
            comb(grp, populations, N, r, area, depth + 1, i + 1);
        }
    }


    public static boolean isAvailable(boolean[][] grp, int N, int[] area) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N + 1];

        //area check
        q.add(area[0]);
        int node, cnt = 1;
        v[area[0]] = true;
        while (!(q.isEmpty())) {
            node = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (v[i] || !grp[node][i] || !contains(area, i)) continue;

                cnt++;
                v[i] = true;
                q.add(i);
            }
        }
        if (cnt != area.length) return false;

        //!area check
        for(int i = 1; i < N+1; i++){
            if(contains(area, i)) continue;

            v[i] = true;
            q.add(i);
            break;
        }
        cnt++;

        while (!(q.isEmpty())) {
            node = q.poll();

            for (int i = 1; i < N + 1; i++) {
                if (v[i] || !grp[node][i] || contains(area, i)) continue;

                cnt++;
                v[i] = true;
                q.add(i);
            }
        }
        if (cnt != N) return false;

        return true;
    }

    public static int calculatePopulation(int[] populations,  int[] area, int N){
        int ar = 0, other = 0;

        for(int i = 1; i < N+1; i++){
            if(contains(area, i)) ar += populations[i];
            else other += populations[i];
        }
        return Math.abs(ar - other);
    }
    public static boolean contains(int[] area, int i) {
        for(int a: area) if (a == i) return true;
        return false;
    }
}