public class CoinChange {

    // Function to count the number of ways to make change for a given amount using the given coin denominations
    public static int helper(int[] coins, int amount, int index) {
        // Base case: when the amount is exactly 0, we found a way to make change
        if (amount == 0) {
            return 1;
        }

        // Base case: when the amount is negative or no more coins are left, there is no way to make change
        if (amount < 0 || index == coins.length) {
            return 0;
        }

        // Include the current coin and keep the index the same (since we have an infinite supply of each denomination)
        int includeCurrentCoin = helper(coins, amount - coins[index], index);

        // Exclude the current coin and move to the next denomination
        int excludeCurrentCoin = helper(coins, amount, index + 1);

        // Return the sum of the two possibilities
        return includeCurrentCoin + excludeCurrentCoin;
    }

    public static int countWaysToMakeChange(int[] coins, int amount){
        return helper(coins, amount, 0); 
    }


    public static void main(String[] args) {
        int[] coins = {1, 2}; // Coin denominations
        int amount = 3; // Amount to make change for
        int ways = countWaysToMakeChange(coins, amount);
        System.out.println("Number of ways to make change for " + amount + " using given coin denominations: " + ways);
    }
}