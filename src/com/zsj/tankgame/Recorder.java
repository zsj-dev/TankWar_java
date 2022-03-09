package com.zsj.tankgame;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyNum=0;
    private static BufferedWriter bw=null;
    private static BufferedReader br=null;
    private static String recordFile="src\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks=null;
    private static Vector<Node> nodes=new Vector<>();

    public static String getRecordFile() {
        return recordFile;
    }

    public static Vector<Node> getNodes(){
        try {
            br=new BufferedReader(new FileReader(recordFile));
            allEnemyNum=Integer.parseInt(br.readLine());
            String line ="";
            while ((line= br.readLine())!=null){
                String[] s = line.split(" ");
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1])
                        , Integer.parseInt(s[2]));
                nodes.add(node);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;


    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static int getAllEnemyNum() {
        return allEnemyNum;
    }

    public static void setAllEnemyNum(int allEnemyNum) {
        Recorder.allEnemyNum = allEnemyNum;
    }
    public static void addNum(){
        Recorder.allEnemyNum++;

    }
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyNum+"\r\n");
            for(int i=0;i<enemyTanks.size();i++){
                EnemyTank enemyTank=enemyTanks.get(i);
                String record =enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                bw.write(record+"\r\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
