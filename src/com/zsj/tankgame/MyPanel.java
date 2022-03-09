package com.zsj.tankgame;

import com.sun.javaws.IconUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener ,Runnable{
    //define my tank
    Hero hero ;
    //define enemy tank
    Vector<EnemyTank> enemyTanks=new Vector<>();
    Vector<Node> nodes=new Vector<>();
    int enemyTankSize=8;
    //define bomb
    Vector<Bomb> bombs=new Vector<>();
    //define three bomb pictures
    Image image1 ;
    Image image2;
    Image image3;
    public MyPanel(String key) {
        //my tank
        File file = new File(Recorder.getRecordFile());
        if(file.exists()) {
            nodes = Recorder.getNodes();
        }else {
            System.out.println("文件不存在只能开启新游戏");
            key="1";
        }
        hero = new Hero(400,400);
        hero.setSpeed(9);
        switch (key){
            case "1"://new game
                //initialize enemy tank
                for(int i=0;i<enemyTankSize;i++){
                    EnemyTank enemyTank=new EnemyTank(100*(i+1),0);
                    //set direct
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(2);
                    new Thread((enemyTank)).start();
                    //give tank a shot
                    Shot shot=new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);

                }
                Recorder.setAllEnemyNum(0);
                break;
            case "2"://old game
                //initialize enemy tank
                for(int i=0;i<nodes.size();i++){
                    Node node=nodes.get(i);
                    EnemyTank enemyTank=new EnemyTank(node.getX(),node.getY());
                    //set direct
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirect(node.getDirect());
                    new Thread((enemyTank)).start();
                    //give tank a shot
                    Shot shot=new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);

                }
                break;
            default:
                System.out.println("你的输入有误。。。");
        }

        Recorder.setEnemyTanks(enemyTanks);
        image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2 .gif"));
        image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

    }
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.BOLD, 25));
        g.drawString("累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyNum()+"",1080,100);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,TankGame01.x_frame,TankGame01.y_frame);//black
        showInfo(g);
        //draw my tank
        if(hero!=null&&hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        //draw hero shot
        for(int i=0;i<hero.shots.size();i++){
            Shot shot=hero.shots.get(i);
            if(shot!=null&&shot.isLive){
                g.draw3DRect(shot.x,shot.y,2,2,false);
            }else{
                hero.shots.remove(shot);
            }
        }

        for(int i = 0; i< bombs.size();++i){
            Bomb bomb=bombs.get(i);
            if(bomb.life>6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life>3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            if(bomb.life==0){
                bombs.remove((bomb));
            }
        }

        for (int i = 0; i< enemyTanks.size();++i) {
            EnemyTank enemyTank=enemyTanks.get(i);
            //draw enemy tank
            if(enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                //draw enemy tank shots
                for (int j = 0; j< enemyTank.shots.size();++j) {
                    Shot shot=enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.fill3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }


        }
    }
    //draw tank
    public void drawTank(int x,int y,Graphics g,int directer,int type){
        switch ((type)){
            case 0://enemy
                g.setColor(Color.cyan);
                break;
            case 1://me
                g.setColor(Color.yellow);
                break;
        }
        switch (directer){
            case 0://up
                g.fill3DRect(x, y,10,60,false);//left tank track
                g.fill3DRect(x+30, y,10,60,false);//right tank track
                g.fill3DRect(x+10, y+10,20,40,false);//tank body
                g.fillOval(x+10,y+20,20,20);//tank warehouse
                g.drawLine(x+20,y+30,x+20,y);//barrel
                break;
            case 1://right
                g.fill3DRect(x, y,60,10,false);//left tank track
                g.fill3DRect(x, y+30,60,10,false);//right tank track
                g.fill3DRect(x+10, y+10,40,20,false);//tank body
                g.fillOval(x+20,y+10,20,20);//tank warehouse
                g.drawLine(x+30,y+20,x+60,y+20);//barrel
                break;
            case 2://down
                g.fill3DRect(x, y,10,60,false);//left tank track
                g.fill3DRect(x+30, y,10,60,false);//right tank track
                g.fill3DRect(x+10, y+10,20,40,false);//tank body
                g.fillOval(x+10,y+20,20,20);//tank warehouse
                g.drawLine(x+20,y+30,x+20,y+60);//barrel
                break;
            case 3://left
                g.fill3DRect(x, y,60,10,false);//left tank track
                g.fill3DRect(x, y+30,60,10,false);//right tank track
                g.fill3DRect(x+10, y+10,40,20,false);//tank body
                g.fillOval(x+20,y+10,20,20);//tank warehouse
                g.drawLine(x+30,y+20,x,y+20);//barrel
                break;

            default:
                System.out.println("no handle");
        }

    }
    public void hitEnemyTank(){
        for(int j=0;j<hero.shots.size();j++){
            Shot shot=hero.shots.get(j);
            if(shot!=null && shot.isLive){
                for(int i=0 ;i<enemyTanks.size();i++){
                    EnemyTank enemyTank=enemyTanks.get(i);
                    hitTank(shot,enemyTank);

                }
            }
        }
    }
    public void hitHero(){
        for(int j=0;j<enemyTanks.size();j++){
            EnemyTank enemyTank=enemyTanks.get(j);
            for(int i=0 ;i<enemyTank.shots.size();i++){
                Shot shot=enemyTank.shots.get(i);
                if(hero.isLive&&shot.isLive) {
                    hitTank(shot, hero);
                }

            }
        }
    }
    //decide whether hit a tank
    public void hitTank(Shot s,Tank enemyTank){
        switch (enemyTank.getDirect()){
            case 0:
            case 2:
                if(s.x>enemyTank.getX() && s.x<enemyTank.getX()+40
                        &&s.y> enemyTank.getY()&&s.y<enemyTank.getY()+60){
                    s.isLive=false;
                    enemyTank.isLive=false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                    if(enemyTank instanceof EnemyTank) {
                        enemyTanks.remove(enemyTank);
                        Recorder.addNum();
                    }

                }
                break;
            case 1:
            case 3:
                if(s.x>enemyTank.getX()&&s.x< enemyTank.getX()+60
                && s.y> enemyTank.getY()&&s.y< enemyTank.getY()+40){
                    s.isLive=false;
                    enemyTank.isLive=false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    if(enemyTank instanceof EnemyTank) {
                        enemyTanks.remove(enemyTank);
                        Recorder.addNum();
                    }
                    bombs.add(bomb);

                }
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirect(0);
            if(hero.getY()>0){
                hero.moveU();
            }
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirect(1);
            if(hero.getX()+60<TankGame01.x_frame){
                hero.moveR();
            }
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirect(2);
            if(hero.getY()+60<TankGame01.y_frame) {
                hero.moveD();
            }
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirect(3);
            if(hero.getX()>0) {
                hero.moveL();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_J){
                hero.shotEnemyTank();

        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//every 100ms repaint it
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();
            hitHero();


            this.repaint();
        }
    }
}
