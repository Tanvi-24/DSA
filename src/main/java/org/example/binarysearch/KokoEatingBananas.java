package org.example.binarysearch;

/*Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
*/

/*
    सोप्या शब्दात Marathi-English मध्ये समजावतो:
    Problem काय आहे?
    Koko ला h तासांच्या आत दिलेल्या piles मधले सगळे bananas खायचे आहेत.
    प्रत्येक तासाला ती फक्त एका pile मधून bananas खाते; एका तासात ती जास्तीत जास्त k bananas खाऊ शकते.
    Binary Search का वापरलाय?
    आपल्याला कमीत कमी अशी speed (k) शोधायची आहे की Koko दिलेल्या वेळेत (h तासांत) सगळे bananas खाऊ शकेल.
    Binary search वापरून आपण minimum (1) आणि maximum (piles मधली सगळ्यात मोठी pile) या speeds मधून योग्य speed शोधू शकतो.
    Binary Search logic काय आहे?
    मधली (mid) speed घेऊन check करतो की त्या speed ने सगळे piles खायला Koko ला किती तास लागतात (canEatInTime() मध्ये calculation केलंय).
    जर ती दिलेल्या वेळेत (h) पूर्ण करू शकत असेल, तर अजून कमी speed possible आहे का ते बघतो (left side ला जातो).
    नाहीतर speed वाढवतो (right side ला जातो).
    canEatInTime() काय करतं?
    प्रत्येक pile साठी pile/speed (ceiling करून) तास लागतील. सगळ्या piles चे total तास calculate करून दिलेल्या वेळेपेक्षा कमी आहेत का हे बघतो.
    Complexity किती?
    Binary search वापरल्यामुळे speed शोधायला वेळ कमी लागतो (Time Complexity: O(n * log m)).
    n: piles ची संख्या
    m: piles मधली सगळ्यात मोठी संख्या
    असं करून minimum possible speed मिळवतो ज्याने Koko दिलेल्या वेळेत bananas खाऊ शकेल.
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
