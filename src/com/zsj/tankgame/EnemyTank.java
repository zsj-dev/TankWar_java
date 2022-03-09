package com.zsj.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<EnemyTank> enemyTanks=new Vector<>();


    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
    public boolean isTouchTank(){
        switch (this.getDirect()){
            case 0:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                        }else{
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }

                        }
                    }

                }
                break;
            case 1:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    && this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }
                        }else{
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    && this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }

                        }
                    }

                }
                break;
            case 2:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    && this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    && this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }
                        }else{
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    && this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    && this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }

                        }
                    }

                }
                break;
            case 3:
                for(int i=0;i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    && this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }
                        }else{
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    && this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    && this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }

                        }
                    }

                }
                break;


        }
        return false;
    }

    @Override
    public void run() {
        do {
            if (isLive && shots.size() < 3) {
                switch (getDirect()) {
                    case 0:
                        shot = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        shot = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        shot = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        shot = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(shot);
                new Thread(shot).start();

            }
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0&&!isTouchTank()) {
                            moveU();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < TankGame01.x_frame&&!isTouchTank()) {
                            moveR();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < TankGame01.y_frame&&!isTouchTank()) {
                            moveD();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0&&!isTouchTank()) {
                            moveL();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }


            setDirect((int) (Math.random() * 4));

        } while (isLive);
    }
}
