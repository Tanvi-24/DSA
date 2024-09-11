package org.example.StringProblems;

public class RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        char direction = 'N';
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i) == 'G'){
                if(direction == 'N'){
                    y++;
                }
                else if(direction == 'S'){
                    y--;
                }
                else if(direction == 'E'){
                    x++;
                }
                else{
                    x--;
                }
            }
            else if(instructions.charAt(i) == 'L'){
                if(direction == 'N'){
                    direction = 'W';
                }
                else if(direction == 'S'){
                    direction = 'E';
                }
                else if(direction == 'E'){
                    direction = 'N';
                }
                else{
                    direction = 'S';
                }
            }
            else{
                if(direction == 'N'){
                    direction = 'E';
                }
                else if(direction == 'S'){
                    direction = 'W';
                }
                else if(direction == 'E'){
                    direction = 'S';
                }
                else{
                    direction = 'N';
                }
            }
        }

        boolean isCircle = false;
        if((x == 0 && y == 0) || (direction != 'N')){
            isCircle = true;
        }
        return isCircle;
    }

    public static void main(String[] args) {
        System.out.println("is robot in a circle - "+isRobotBounded("GG"));
        System.out.println("is robot in a circle - "+isRobotBounded("GL"));
    }
}
