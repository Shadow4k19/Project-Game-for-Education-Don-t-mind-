
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
    public UI(Gamepanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80B = new Font("Arial",Font.BOLD,80);
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
        }
        if(gp.gameState == gp.pauseState2){
            drawPause();
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
}
