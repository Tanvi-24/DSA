package org.example.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class  MinOfIndianCoins {
    public static void main(String[] args) {
        int coins[] = {2000,1000,500,200,100,50,20,10,5,2,1};
        int count = 0;
        int amount = 1059;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while (coins[i]<=amount) {
                    count++;
                    amount = amount - coins[i];
                    ans.add(coins[i]);
                }
            }
        }

        System.out.println("total (min) coins used is "+count);
        for (int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+ " ");
        }
    }
}
