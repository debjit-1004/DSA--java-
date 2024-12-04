class _29_minimum_cost_stair_DP {
    // Method to calculate the minimum cost to reach the top
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // dp array to store the minimum cost to reach each step
        int[] dp = new int[n + 1];

        
        dp[0] = 0; // Cost to reach step 0
        dp[1] = 0; // Cost to reach step 1

        // Filling the dp array
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        // The minimum cost to reach the top
        return dp[n];
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Example cost array
        int[] cost = {10, 15, 20};

        // Compute and print the result
        System.out.println("Minimum cost to climb stairs: (test1)" + minCostClimbingStairs(cost));

        // Another test case
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost to climb stairs:(test2) " + minCostClimbingStairs(cost2));
    }
}