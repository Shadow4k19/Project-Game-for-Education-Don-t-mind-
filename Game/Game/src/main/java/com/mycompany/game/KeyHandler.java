
package com.mycompany.game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                    gp.player.setDefaultValues();
                    gp.hound.setDefaultValues();
                    gp.ui.Commandnum = 0;
                }
                if(gp.ui.Commandnum == 1){
                    gp.gameState = gp.playState;
                    gp.Stage = 2;
                    gp.player.setDefaultValues();
                    gp.orc.setDefaultValues();
                    gp.ui.Commandnum = 0;
                }
                if(gp.ui.Commandnum == 2){
                    gp.gameState = gp.playState;
                    gp.Stage = 3;
                    gp.player.setDefaultValues();
                    gp.aku.setDefaultValues();
                    gp.ui.Commandnum = 0;
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
                gp.ui.setTime();
            }
        }
        if(gp.gameState == gp.gameoverState){
            if(code == KeyEvent.VK_ESCAPE){
                gp.ui.setTime();
                gp.gameState = gp.titlleState;
            }
          if(code == KeyEvent.VK_W){
                if(gp.ui.Commandnum !=0){
                gp.ui.Commandnum--; 
                }
            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.Commandnum !=1){
                gp.ui.Commandnum++;
                }
        }
             if(code == KeyEvent.VK_ENTER){
                if(gp.ui.Commandnum == 0){
                    gp.gameState = gp.playState;
                    gp.player.setDefaultValues();
                    gp.ui.setTime();
                    if(gp.Stage == 1){
                        gp.hound.setDefaultValues();
                    }
                     if(gp.Stage == 2){
                        gp.orc.setDefaultValues();
                    }
                    if(gp.Stage == 3){
                        gp.aku.setDefaultValues();
                    }
                    gp.repaint();
                }
                if(gp.ui.Commandnum == 1){
                    gp.gameState = gp.titlleState;
                    gp.repaint();
                    gp.ui.Commandnum = 0;
                }
        }
        }
        if(gp.gameState == gp.winState){
            if(code == KeyEvent.VK_ESCAPE){
                gp.gameState = gp.titlleState;
                gp.ui.setTime();
            }
          if(code == KeyEvent.VK_W){
                if(gp.ui.Commandnum !=0){
                gp.ui.Commandnum--; 
                }
            }
            if(code == KeyEvent.VK_S){
                if(gp.ui.Commandnum !=1){
                gp.ui.Commandnum++;
                }
        }
             if(code == KeyEvent.VK_ENTER){
                if(gp.ui.Commandnum == 0){
                    gp.gameState = gp.playState;
                    gp.ui.setTime();
                    gp.player.setDefaultValues();
                    if(gp.Stage == 1){
                        System.err.println(gp.Stage);
                        gp.Stage = 2;
                        gp.hound.setDefaultValues();
                    }
                    else if(gp.Stage == 2){
                        System.err.println(gp.Stage);
                        gp.Stage = 3;
                        gp.orc.setDefaultValues();
                    }
                    else if(gp.Stage == 3){
                        System.err.println(gp.Stage);
                         gp.aku.setDefaultValues();
                         gp.gameState = gp.game_clear;
                     }
                    gp.repaint();
                }
                if(gp.ui.Commandnum == 1){
                    gp.gameState = gp.titlleState;
                    gp.ui.Commandnum = 0;
                    gp.repaint();
                }
        }
        }
         if(gp.gameState == gp.game_clear){
             //gp.ui.drawGame_clear();
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
