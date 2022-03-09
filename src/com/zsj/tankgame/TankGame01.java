package com.zsj.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame01 extends JFrame {
    public static int x_frame=1000;
    public static int y_frame=750;
    MyPanel mp ;
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {

        TankGame01 tankGame01 = new TankGame01();

    }
    public TankGame01(){
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key=scanner.next();
        mp = new MyPanel(key);
        //mp into thread and start
        Thread thread=new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(x_frame+300,y_frame+65);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
        
    }
}
