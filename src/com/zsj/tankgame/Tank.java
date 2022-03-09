package com.zsj.tankgame;

import java.util.Vector;

public class Tank {
    private int x;//tank X-axis
    private int y;//tank Y-axis
    private int direct;//0 up 1 right 2 down 3 left
    private int speed=2;
    boolean isLive =true;
    Vector<Shot> shots=new Vector<>();

    Shot shot = null;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveU(){
        y-=speed;
    }

    public void moveR(){
        x+=speed;
    }
    public  void moveD(){
        y+=speed;
    }
    public void moveL(){
        x-=speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
