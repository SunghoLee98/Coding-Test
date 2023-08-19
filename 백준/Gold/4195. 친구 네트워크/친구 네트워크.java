import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<Integer> union = new ArrayList<>();

            String p1, p2;
            int cnt, root1, root2;
            for(int i = 0; i < N; i++){

                st = new StringTokenizer(br.readLine());

                p1 = st.nextToken();
                p2 = st.nextToken();

                addMember(map, union, p1);
                addMember(map, union, p2);

                root1 = findUnion(union, map.get(p1));
                root2 = findUnion(union, map.get(p2));

                if(root1 != root2) unionAssemble(union, root1, root2);

                sb.append(Math.abs(union.get(findUnion(union, root1)))).append("\n");
            }
        }
        System.out.print(sb.toString());
    }

    private static void unionAssemble(ArrayList<Integer> union, int root1, int root2) {
        if(union.get(root1) > union.get(root2)){
            int temp = root1;
            root1 = root2;
            root2 = temp;
        }

        union.set(root1, union.get(root1) + union.get(root2));
        union.set(root2, root1);
    }

    public static int findUnion(ArrayList<Integer> union, int value){
        ArrayDeque<Integer> q = new ArrayDeque<>();

        while(union.get(value) >= 0){
            q.add(value);
            value = union.get(value);
        }
        while(!(q.isEmpty())){
            union.set(q.poll(), value);
        }
        return value;
    }

    public static void addMember(HashMap<String, Integer> map, ArrayList<Integer> union, String p){
        if(map.containsKey(p)) return;

        map.put(p, map.size());
        union.add(-1);
    }
}