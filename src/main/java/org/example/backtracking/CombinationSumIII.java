package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

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
        int n = 7, k=3;
        System.out.println(combinationSum3(k,n));

    }

}
