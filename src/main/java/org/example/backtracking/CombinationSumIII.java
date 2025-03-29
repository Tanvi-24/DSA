package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;
/*
    CombinationSumIII (Backtracking) in Brief:
    Ha code combinationSum3 madhe, given number (n) cha sum asnare exact k numbers che unique combinations
    shodhto, fakt 1 te 9 numbers vaprun.
    Backtracking approach vaprun, combine method madhe recursion karun sagle possible combinations check
     karto; jar exact sum ani required size (k) cha combination bhetla tar result madhe add karto,
     nahi tar discard karto ani pudhe jat rahato.
    Overall:
    Recursion ani backtracking mule efficient ani accurate combinations generate kele jatat;
    unnecessary combinations avoid kele jatat.
 */
public class CombinationSumIII {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<9;i++){
            combine(i,n,k,new ArrayList<>(),result);
        }

        return result;
    }

    public static void combine(int i,int n, int k, List<Integer> list, List<List<Integer>>result){

        if(n == 0 && list.size() == k){
            if(!result.contains(list)){
                result.add(new ArrayList<>(list));
                return;
            }
        }

        if(i>n || i>9){
            return;
        }


        if(!list.contains(i)){
            list.add(i);
        }
        combine(i+1,n-i,k,list,result);
        list.remove(list.size()-1);
        combine(i+1,n,k,list,result);


    }

    public static void main(String[] args) {
        int n = 8, k=3;
        System.out.println(combinationSum3(k,n));

    }

}
