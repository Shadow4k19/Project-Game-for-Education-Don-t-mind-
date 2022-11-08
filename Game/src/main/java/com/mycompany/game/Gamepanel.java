
package com.mycompany.game;

import Backgound.backgound;
import Enitity.Blast;
import Enitity.Hound;
import Enitity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

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
    public ArrayList<Blast> blast1 = new ArrayList<Blast>();
    
    int FPS = 60;
    
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
                //System.out.println("FPS : " + frame + " | UPS : "+ updates);
                //System.out.println(TILES_SIZE) ;
                frame = 0 ;
                updates = 0 ;
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
        for (int i = 0; i < blast1.size(); i++) {
            Blast blast = blast1.get(i);
            blast.draw(g2, i);
            blast.updateBlast();
            blast.count++;
            if (blast.x < 0) {
                blast1.remove(i);
            }
            }

    }
    
}
