
package com.mycompany.game;

import Backgound.backgound;
import Enitity.Hound;
import Enitity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import tile.TileManager;

public class Gamepanel extends JPanel implements Runnable{
    
    final int originalTitlesize = 16;
    final int scale = 3 ;
    
    public final int titleSize = originalTitlesize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = titleSize * maxScreenCol;
    public final int screenHieght = titleSize * maxScreenRow;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    Hound hound = new Hound(this);
    backgound backgound = new backgound(this);
    
    int FPS = 60;
    
    //set Position player
    int playerX = 100;
    int playerY = 350;
    int playerSpeed = 5;
    int playerJumphigh = 150;
    int lastPress = 0 ;
    long lassPress = 0;
    
    int MonsterX = 600;
    int MonsterY = 285;
    
    double drawInterval = 1000000000/FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;
    
    public Gamepanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHieght));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
}
    public void startGameThead(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime)/drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>= 1000000000){
                drawCount = 0;
                timer = 0;
            }
           
    }
    }
    
    public void update(){
        player.update();
        hound.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        //tilem.draw(g2);
        backgound.draw(g2);
        
        player.draw(g2);
        hound.draw(g2);
        Timer timer = new Timer(-1000000000,new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e) {
                hound.draw(g2);
                repaint();
            }
        });
        timer.setDelay(10000000);
        timer.setRepeats(false);
        timer.stop();
        g2.dispose();

    }
    
}
