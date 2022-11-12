
package com.mycompany.game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class KeyHandler implements KeyListener{
    
    Gamepanel gp;
    public boolean upPressed, leftPressed ,rightPressed,ATK;
    public KeyHandler(Gamepanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(gp.gameState == gp.titlleState){
            if(code == KeyEvent.VK_W){
                if(gp.ui.Commandnum !=0){
                gp.ui.Commandnum--; 
                }
            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.Commandnum !=3){
                gp.ui.Commandnum++;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.Commandnum == 0){
                    gp.gameState = gp.playState;
                    gp.Stage = 1;
                }
                if(gp.ui.Commandnum == 1){
                    gp.gameState = gp.playState;
                    gp.Stage = 2;
                }
                if(gp.ui.Commandnum == 2){
                    gp.gameState = gp.playState;
                    gp.Stage = 3;
                }
                if(gp.ui.Commandnum == 3){
                    System.exit(0);
                }
            }
            if(code == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }
        }
        if(gp.gameState == gp.playState){
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titlleState;
            }
        }
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_J){
            ATK = true;
        }
        if(code == KeyEvent.VK_P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState2;
                
            }
            else if(gp.gameState == gp.pauseState2){
                gp.gameState = gp.playState;
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
           int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
         if(code == KeyEvent.VK_J){
            ATK = false;
        }
    }
    
}
