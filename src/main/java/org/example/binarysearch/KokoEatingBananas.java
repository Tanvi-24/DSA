package org.example.binarysearch;

/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
*/
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;

        // Find max pile size
        int maxSpeed = 0;
        for (int pile : piles)
            maxSpeed = Math.max(maxSpeed, pile);

        // Binary search
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatInTime(piles, h, mid))
                maxSpeed = mid;
            else
                minSpeed = mid + 1;
        }

        return minSpeed;
    }

    private static boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0,s=0;
        for(int pile : piles) {
            s = (int) Math.ceil((double) pile / speed);
            hours+=s;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles= {3,6,7,11};
        int h=8;
        System.out.println(minEatingSpeed(piles,h));
    }
}
