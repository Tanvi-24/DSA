package org.example.Heaps;

import java.util.PriorityQueue;

public class NearbyCars {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        int index;

        public Point(int x, int y, int dist, int index){
            this.x = x;
            this.y = y;
            this.dist =dist;
            this.index = index;
        }

        @Override
        public int compareTo(Point p2){
            return this.dist - p2.dist;
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0;i<pts.length;i++){
            int dist = (int)Math.pow(pts[i][0],2)+(int)Math.pow(pts[i][1],2);
            pq.add(new Point(pts[i][0],pts[i][1],dist,i));
        }

        for(int i=0;i<k;i++){
            System.out.print("C" + pq.remove().index+" ");
        }
    }
}
