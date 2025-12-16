import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 번호 작은 것부터 방문해야 하므로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
