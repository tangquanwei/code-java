package algorithms;

import org.junit.jupiter.api.Test;

public class DynamicProgroming {
    @Test
    public void testFib() {
        // System.out.println("dsac");
        System.out.println(fib(10));
    }

    int fib(int N) {
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    int helper(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1)
            return n;
        // 已经计算过，不用再计算了
        if (memo[n] != 0)
            return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

}
