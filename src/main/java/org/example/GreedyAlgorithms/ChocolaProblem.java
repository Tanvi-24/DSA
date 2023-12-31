package org.example.GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int h=0,v=0;
        int hp =1, vp =1;
        int n=4,m=3;
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};
        int cost = 0;
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());

        while (v< costVer.length && h<costHor.length){
            //vertical cost < horizontal cost
            if(costVer[v]<costHor[h]){//horizontal cut
                cost+= costHor[h]*vp;
                hp++;
                h++;
            }
            else { //vertical cut
                cost+=costVer[v]*hp;
                vp++;
                v++;
            }
        }

        while (h<costHor.length){
            cost+= costHor[h]*vp;
            hp++;
            h++;
        }

        while (v<costVer.length){
            cost+= costVer[v]*hp;
            vp++;
            v++;
        }
        System.out.println("Min cost of cuts "+cost);
    }

}
