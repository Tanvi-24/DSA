package org.example.StringProblems;

/*You are given a string S. Every sub-string of identical letters is replaced by a single instance of
that letter followed by the hexadecimal representation of the number of occurrences of that letter.
Then, the string thus obtained is further encrypted by reversing it [ See the sample for more clarity ].
Print the Encrypted String.*/
public class EncryptString2 {

    public static String encryptString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int count = 1;
            while(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(s.charAt(i));
            if(count>9){
                sb.append(Integer.toString(count,16));
            }
            else{
                sb.append(count);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaa";

        System.out.println("Encrypted string is "+encryptString(s));
        System.out.println("Encrypted string is "+encryptString("abc"));
    }

}
