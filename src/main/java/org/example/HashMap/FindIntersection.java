package org.example.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIntersection {

    public static List<Integer> getIntersection(int[] array1,int[] array2){
        List<Integer> result = new ArrayList<>();

        Map<Integer,Integer> numsMap1 = new HashMap<>();
        for(int i=0;i<array1.length;i++){
            numsMap1.put(array1[i],numsMap1.getOrDefault(array1[i],0)+1);
        }

        for(int num:array2){
            if(numsMap1.containsKey(num)&&numsMap1.get(num)>0){
                result.add(num);
                numsMap1.put(num,numsMap1.get(num)-1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = {1,1,2,2,2,3};
        int []array2= {1,1,1,2,2,3,4,5};
        System.out.println(getIntersection(array1,array2));
    }
}
