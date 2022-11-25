
package com.mycompany.game;

import Backgound.backgound;
import Enitity.Aku;
import Enitity.Entity;
import Enitity.Hound;
import Enitity.Orc;
import Enitity.Player;
import Event.Event;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Gamepanel extends JPanel implements Runnable{
    
    final int originalTitlesize = 16;
    final int scale = 3 ;
    
    public final int titleSize = originalTitlesize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = titleSize * maxScreenCol;
    public final int screenHieght = titleSize * maxScreenRow;
    
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    public Player player = new Player(this, keyH,0,350,3);
    public Hound hound = new Hound(this);
    public Orc orc = new Orc(this);
    public Aku aku = new Aku(this);
    backgound backgound = new backgound(this);
    public UI ui = new UI(this);
    public Event event = new Event(this);
    public ArrayList<Entity> projecttile = new ArrayList<>();
    public ArrayList<Entity> projecttile1 = new ArrayList<>();
    /*public ArrayList<Entity> Entitylist = new ArrayList<>();*/
    
    public int gameState;
    public final int titlleState = 0;
    public final int playState = 1;
    public final int pauseState2 = 2;
    public final int gameoverState = 3;
    public final int winState = 4;
    public final int game_clear = 5;
    public int Stage = 4;
    int count = 0;
    int count1 = 0;
    
    int FPS = 60;
    
    public Gamepanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHieght));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupgame(){
        gameState = 0;
    }
    public void startGameThead(){
        gameThread = new Thread(this);
        gameThread.start();
        setupgame();
    }

    @Override
    public void run() {
       //double timePerFrame = 1000000000.0 / FPS ;
        double timePerUpdate = 1000000000.0 / FPS ;

        long previousTime = System.nanoTime() ;

        int frame = 0 ;
        int updates = 0 ;
        long lastCheck = System.currentTimeMillis() ;

        double deltaU = 0 ;
        double deltaF = 0 ;

        while(true) {
            long currentTime = System.nanoTime() ;

            deltaU += (currentTime - previousTime) / timePerUpdate ;
            deltaF += (currentTime - previousTime) / timePerUpdate ;
            previousTime = currentTime ;

            if(deltaU >= 1){
                update() ;
                updates++ ;
                deltaU-- ;
            }
            if(deltaF >= 1){
                repaint() ;
                frame++ ;
                deltaF-- ;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis() ;
                frame = 0 ;
                updates = 0 ;
            }
        }
    }
    
    public void update(){
        if(gameState == playState){
            player.update();
            for(int i = 0; i < projecttile.size(); i++) {
                projecttile.get(i).update() ;
            }
        if(Stage == 1){
            hound.update();
            for(int i = 0; i < projecttile1.size(); i++) {
                projecttile1.get(i).update() ;
            }
        }
        if(Stage == 2){
            orc.update();
        }
        if(Stage == 3){
            aku.update();
        }
        }
        if(gameState == pauseState2){
            //Pause;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        //tilem.draw(g2);
        if(gameState == titlleState){
            backgound.draw(g2);
            ui.draw(g2);
        }
        else{
        if(Stage==1){
            //System.out.println(Stage);
            backgound.draw(g2);
            player.draw(g2);
            hound.draw(g2);
            ui.draw(g2);
        }
        if(Stage == 2){
            //System.out.println(Stage);
            backgound.draw(g2);
            player.draw(g2);
            orc.draw(g2);
            ui.draw(g2);
        }
        if(Stage == 3){
            //System.out.println(Stage);
            backgound.draw(g2);
            player.draw(g2);
            aku.draw(g2);
            ui.draw(g2);
        }
        if(gameState == pauseState2){
            //Pause;
            ui.draw(g2);
        }
         for(int i = 0 ; i < projecttile.size();i++){
                 if(Stage == 1){
                    count++;
                 if(event.Check(projecttile.get(i).getBounds(),hound.getBounds())== true && count == 100){
                     hound.Hp-= 1;
                     //count++;
                     if(hound.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 else{
                      if(count == 20){
                         hound.Hp-=100;
                         count = 0;
                     }
                      if(hound.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 }
                 else if(Stage == 2){
                    count++;
                 if(event.Check(projecttile.get(i).getbound(),orc.getbound())&& count == 100){
                     orc.Hp-= 1;
                     if(orc.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 else{
                      if(count == 20){
                         orc.Hp-=100;
                         count = 0;
                     }
                      if(orc.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 }
                 else if(Stage == 3){
                    count++;
                 if(event.Check(projecttile.get(i).getbound(),aku.getbound())&&count == 100){
                     aku.Hp-= 1;
                     if(aku.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 else{
                      if(count == 15){
                         aku.Hp-=100;
                         count = 0;
                     }
                      if(aku.Hp <= 0){
                         gameState = 4;
                         player.setDefaultValues();
                     }
                 }
                 }
             }
         for(int i = 0 ; i < projecttile1.size() ; i++){
             if(event.Check(projecttile1.get(i).getBounds(), player.getBounds()) == true){
                 count1++;
                 if(count1==50){
                  player.Hp--;
                  count1 = 0;
                 }
             }
         }
         if(player.Hp <= 0||ui.Time == 0){
             gameState = gameoverState;
         }
         }
        }
}

