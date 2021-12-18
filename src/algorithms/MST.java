package algorithms;

import java.util.Arrays;

// 最小生成树（Minimum Spanning Tree）算法
// 在图中找一棵包含图中的所有节点的树。专业点说，生成树是含有图中所有顶点的「无环连通子图」
// 对于加权图，每条边都有权重，所以每棵生成树都有一个权重和
// 一般来说，我们都是在无向加权图中计算最小生成树的，所以使用最小生成树算法的现实场景中，图的边权重一般代表成本、距离这样的标量
// 对于添加的这条边，如果该边的两个节点本来就在同一连通分量里，那么添加这条边会产生环；
// 反之，如果该边的两个节点不在同一连通分量里，则添加这条边不会产生环
public class MST {
    // Kruskal 算法
    // graph[[v1,v2,w(edge)]]
    int kruskal(int n, int[][] graph) {
        // 编号1-n
        UF uf = new UF(n + 1);
        // 对边权排序
        Arrays.sort(graph, (a, b) -> a[2] - b[2]);
        // 总权
        int mst = 0;
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v))
                continue;
            mst += weight;
            uf.union(u, v);
        }
        return uf.count() == 2 ? mst : -1;
    }
}
