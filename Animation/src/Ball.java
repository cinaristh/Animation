import java.util.Random;

import static java.lang.Math.random;

public class Ball {
    private int x ;
    private double y ;
    private int dx = 5;
    private double dy = 0;


    public Ball(){
         x= (int)(Math.random()*380);
         y = Math.random()*380;
    }

    public int getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void updatePosition(){
        x += dx;

        y += dy;
        dy=dy+1;
        if (x > 370) {
            dx = -dx;


        }
        if (x < 1) {
            dx = -dx;
        }



        if (y > 370) {
            dy=dy*-0.95;

        }
        if (y<0){
            dy=1;
        }
    }


}
