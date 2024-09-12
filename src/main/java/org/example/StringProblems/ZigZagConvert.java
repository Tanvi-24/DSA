package org.example.StringProblems;

public class ZigZagConvert {
    public static String convert(String s, int numRows) {
        int cols = s.length()/2==0?s.length()/2:s.length()/2+1;
        char [][]str = new char[numRows][cols];
        int k =0;
        int zigzag;
        int j=0,i=0;

        if(numRows==1 || s.length()<numRows){
            return s;
        }

        while(k<s.length()&&i<numRows&&j<cols){
           //first add character in 1st column wrt to number of rows
            while(i<numRows&&k<s.length()&&j<cols){
                str[i][j]=s.charAt(k);
                k++;
                i++;
            }
            //get the last second row and traverse row in upward direction and increase the col number until you reach row zero
            i=numRows-2;
            j++;
            //if row is already zero add the character their and start the loop again
            if(i==0&&k<s.length()&&j<cols){
                str[i][j]=s.charAt(k);
            }
            //get the last second row and traverse row in upward direction and increase the col number until you reach row zero
            while(i!=0&&k<s.length()&&i<numRows&&j<cols){
                str[i][j] = s.charAt(k);
                j++;
                i--;
                k++;
            }

        }

        //read the matrix row wise and append the characters to form a string
        StringBuilder sb = new StringBuilder();
        for(i=0;i<numRows;i++){
            for(j=0;j<cols;j++){
                if(Character.isLetter(str[i][j])||str[i][j]==','||str[i][j]=='.')
                    sb.append(str[i][j]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str,3));

    }
}
