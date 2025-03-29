package org.example.DESHAW;
/*

    Check kara ki given string valid palindrome aahe ka — ignoring non-alphanumeric characters and case sensitivity.
    ✅ Logic:
    start and last pointers string cha two ends varun move kartat.
    For each character:
    Ignore jar toh non-alphanumeric asel (Character.isLetterOrDigit check).
    Compare karaycha tar toLowerCase() karun compare karto (case-insensitive).
    Jar mismatch zala tar return false.
    Loop end paryant match zala tar return true.
    ✅ Key Checks:
    Character.isLetterOrDigit(ch): checks if character is A-Z, a-z, or 0-9
    Character.toLowerCase(ch): ensures case-insensitive comparison
    ✅ Time & Space Complexity:
    Time: O(n)
    Space: O(1) (no extra space used)
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Is valid palindrome: "+isPalindrome("abba"));
    }
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
