package org.example.HashMap;

import java.util.HashMap;
import java.util.Map;

public class FindMaxAverageScore {

    //{"Boby":100, "Charles": 23 , "Eric":200, "Charles": 100}

    public static void main(String[] args) {
        Map<String,Integer[]> studentScores =  new HashMap<>();
        studentScores.put("Boby", new Integer[]{100,200,400});
        studentScores.put("Charles",new Integer[]{23,100});
        studentScores.put("Eric",new Integer[]{200});

        float maxAverage = 0.0f;

        for (Map.Entry<String,Integer[]> map:studentScores.entrySet()) {
            Integer[] scores = map.getValue();
            float sum  = 0 ;
            for (int s:scores) {
                sum+=s;
            }
            maxAverage = Math.max(maxAverage,sum/scores.length);
        }

        System.out.println("Maximum average is "+ maxAverage);
    }
}
