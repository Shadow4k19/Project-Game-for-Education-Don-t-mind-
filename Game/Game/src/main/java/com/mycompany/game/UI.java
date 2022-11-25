
package com.mycompany.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public class UI {
    Gamepanel gp;
    Graphics2D g2;
    Font arial_40,arial_80B;
    public String message;
    public boolean messageOn = false;
    public int Commandnum = 0 ;
    public int Time = 0;
    public UI(Gamepanel gp){
        this.gp = gp;
        time.start();
        setTime();
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80B = new Font("Arial",Font.BOLD,80);
    }
    public void setTime(){
        Time = 60;
    }
    public void showMassage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if(gp.gameState == gp.titlleState){
            drawTitleScreen();
        }
        if(gp.gameState == gp.playState){
           //Nothing to do
        }
        if(gp.Stage != 0&&Commandnum !=3&& gp.gameState == gp.playState){
            drawPlay();
            //setTime();
            if(gp.Stage == 1){
                g2.drawString("Hp = "+gp.hound.Hp,550,550);
                g2.setColor(Color.black);
                g2.drawString("Time = "+Time, 255, 40);
            }
            if(gp.Stage == 2){
                g2.drawString("Hp = "+gp.orc.Hp,550,550);
                g2.setColor(Color.black);
                 g2.drawString("Time = "+Time, 255, 40);
            }
            if(gp.Stage == 3){
                g2.drawString("Hp = "+gp.aku.Hp,550,550);
                 g2.setColor(Color.black);
                 g2.drawString("Time = "+Time, 255, 40);
            }
        }
        if(gp.gameState == gp.pauseState2){
            drawPause();
        }
        if(gp.gameState == gp.gameoverState){
            drawGameOVER();
        }
        if(gp.gameState == gp.winState){
            drawWin();
        }
        if(gp.gameState == gp.game_clear){
            drawGame_clear();
        }
    }
    public void drawGame_clear(){
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHieght);
        gp.backgound.draw(g2);
        String text = "Game Clear";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        int y = gp.screenHieght/4;
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        y = gp.screenHieght/2;
        text = "ESC";
        g2.drawString(text, x+200, y+50);
    }
    public void drawWin(){
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHieght);
        gp.backgound.draw(g2);
        String text = "State Clear";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        int y = gp.screenHieght/4;
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        y = gp.screenHieght/2;
        text = "Next";
        g2.drawString(text, x+200, y+50);
        if(Commandnum == 0){
            g2.drawString(">", x+180, y+50);
        }
        text = "Main Menu";
        g2.drawString(text, x+175, y+100);
        if(Commandnum == 1){
            g2.drawString(">", x+150, y+100);
        }
    }
    public void drawGameOVER(){
        g2.setColor(Color.black);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHieght);
        gp.backgound.draw(g2);
        String text = "GAME OVER";
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - lenght/2;
        int y = gp.screenHieght/4;
        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        y = gp.screenHieght/2;
        text = "Retry";
        g2.drawString(text, x+220, y+50);
        if(Commandnum == 0){
            g2.drawString(">", x+200, y+50);
        }
        text = "Main Menu";
        g2.drawString(text, x+195, y+100);
        if(Commandnum == 1){
            g2.drawString(">", x+170, y+100);
        }
    }
    public void drawPause(){
        String text = "PAUSE";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        
        int x = gp.screenWidth/2 - lenght/2;
        
        int y = gp.screenHieght/2;
        g2.drawString(text, x, y); 
    }
    public void drawTitleScreen(){
        g2.setColor(Color.black);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,85F));
        String text = "ADVENTURE TIME";
        int lenght = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        
        int x = gp.screenWidth/2 - lenght/2;
        
        int y = gp.titleSize*3;
        g2.drawString(text, x+5, y+5);
        
        g2.setColor(Color.white);
        g2.drawString(text,x,y);
        
        text = "STAGE1";
         g2.setFont(g2.getFont().deriveFont(Font.BOLD,50F));
         y = gp.titleSize*5;
         g2.setColor(Color.black);
         g2.drawString(text, x+55, y+5);
         g2.setColor(Color.white);
         g2.drawString(text, x+50, y);
         if(Commandnum == 0){
             g2.drawString(">", x+20, y);
         }
         text = "STAGE2";
         y = gp.titleSize*7;
         g2.setColor(Color.black);
         g2.drawString(text, x+55, y+5);
         g2.setColor(Color.white);
         g2.drawString(text, x+50, y);
         if(Commandnum == 1){
             g2.drawString(">", x+20, y);
         }
         text = "STAGE3";
         y = gp.titleSize*9;
         g2.setColor(Color.black);
         g2.drawString(text, x+55, y+5);
         g2.setColor(Color.white);
         g2.drawString(text, x+50, y);
         if(Commandnum == 2){
             g2.drawString(">", x+20, y);
         }
         text = "EXIT";
         y = gp.titleSize*11;
         g2.setColor(Color.black);
         g2.drawString(text, x+55, y+5);
         g2.setColor(Color.white);
         g2.drawString(text, x+50, y);
         if(Commandnum == 3){
             g2.drawString(">", x+20, y);
         }
    }
    public void drawPlay(){
        String text = "HP = ";
        int x = 50;
        int y = 550;
        g2.setColor(Color.white);
        g2.drawString(text+gp.player.Hp,x,y);
    }
    Thread time = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {                            
                    try {
                    if(gp.gameState != gp.pauseState2){
                        Time--;
                        gp.repaint();
                        time.sleep(1000);
                    }
                    } catch (Exception e) {
                    System.err.println(e);
                    }
                    }
                    }
                });
}
