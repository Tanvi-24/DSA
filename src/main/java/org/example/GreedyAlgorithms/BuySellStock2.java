package org.example.GreedyAlgorithms;

public class BuySellStock2 {

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};  // Example prices for 7 days
        int maxProfit = maximizeProfit(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }

    public static int maximizeProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int sharesOwned = 0;

        for (int i = 0; i < n - 1; i++) {
            // If the price is expected to rise tomorrow, buy shares today
            if (prices[i + 1] > prices[i]) {
                int sharesToBuy = Math.min(10, 100 - sharesOwned); // You can buy at most 10 shares
                sharesOwned += sharesToBuy;
                maxProfit -= sharesToBuy * prices[i]; // Subtract cost of buying shares
                System.out.println("Buying " + sharesToBuy + " shares on day " + (i + 1) + " at price " + prices[i]);
            }
            // If the price is expected to drop tomorrow, sell all shares today
            else if (prices[i + 1] < prices[i] && sharesOwned > 0) {
                maxProfit += sharesOwned * prices[i]; // Add profit from selling shares
                System.out.println("Selling " + sharesOwned + " shares on day " + (i + 1) + " at price " + prices[i]);
                sharesOwned = 0; // Reset the number of shares owned to 0
            }
        }

        // Finally, if shares are still owned on the last day, sell them
        if (sharesOwned > 0) {
            maxProfit += sharesOwned * prices[n - 1];
            System.out.println("Selling remaining " + sharesOwned + " shares on day " + n + " at price " + prices[n - 1]);
        }

        return maxProfit;
    }
}

