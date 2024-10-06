package org.example.StringProblems;

public class ExcelSheetColumnTItle {

    //efficient solution
    //start calculating from last character
    public String convertToTitle(int columnNumber) {
        StringBuilder result=new StringBuilder();
        while(columnNumber>0)
        {
            columnNumber--;
            int rem=columnNumber%26;
            result.insert(0,(char)('A'+rem));
            columnNumber/=26;
        }
        return result.toString();
    }

    //my solution
    public String convertToTitleUsingRecursion(int columnNumber) {
        char[] alphabets = {'0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        if(columnNumber<alphabets.length){
            return String.valueOf(alphabets[columnNumber]);
        }

        int quotient = columnNumber/26;
        int remainder = columnNumber%26;
        String character="";
        if(remainder == 0){
            if(quotient<alphabets.length){
                character=character+alphabets[quotient-1];
                character=character+'Z';
            }
            else{
                character=character+convertToTitle(quotient-1);
                character=character+'Z';
            }
        }
        else{
            if(quotient<alphabets.length){
                character=character+alphabets[quotient];
            }
            else{
                character=character+convertToTitle(quotient);
            }
            if(remainder<alphabets.length){
                character=character+alphabets[remainder];
            }
            else{
                character=character+convertToTitle(remainder);
            }
        }
        return character;

    }
    public static void main(String[] args) {
        ExcelSheetColumnTItle excelSheetColumnTItle=new ExcelSheetColumnTItle();
        System.out.println(excelSheetColumnTItle.convertToTitle(55));
        System.out.println(excelSheetColumnTItle.convertToTitleUsingRecursion(55));
    }
}