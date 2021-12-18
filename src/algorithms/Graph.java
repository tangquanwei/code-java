package algorithms;

import java.io.BufferedInputStream;
import java.util.*;

public class Graph {
    // 防止重复遍历同一个节点
    boolean[] visited;

    // 从节点 s 开始 DFS 遍历，将遍历过的节点标记为 true
    void traverse(List<Integer>[] graph, int s) {
        if (visited[s]) {
            return;
        }
        /* 前序遍历代码位置 */
        // System.out.println(Arrays.deepToString(graph));
        // 将当前节点标记为已遍历
        visited[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        /* 后序遍历代码位置 */
    }

    int[][] readGraph(int n) {
        int[][] res = new int[n][n];
        try (Scanner in = new Scanner(new BufferedInputStream(System.in))) {
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    res[i][j] = in.nextInt();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

