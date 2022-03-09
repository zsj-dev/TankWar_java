package com.zsj.tankgame;

public class Shot implements Runnable{
    int x;
    int y;
    int direct;
    int speed=4;
    boolean isLive=true;


    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct){
                case 0://up
                    y-=speed;
                    break;
                case 1://right
                    x+=speed;
                    break;
                case 2://down
                    y+=speed;
                    break;
                case 3://left
                    x-=speed;
                    break;
            }
            if(!(x>=0&&x<=TankGame01.x_frame&&y>=0&&y<=TankGame01.y_frame&&isLive)){
                isLive=false;
                break;
            }

        }
    }
}
