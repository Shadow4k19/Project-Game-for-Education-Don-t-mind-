
package Enitity;

import com.mycompany.game.Gamepanel;
import com.mycompany.game.KeyHandler;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Player extends Entity {
    
    Gamepanel gp;
    KeyHandler keyH;
    public int lastPress = 0;
    public long lassPress = 0;
    
    public Player(Gamepanel gp,KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
        getImage();
        
    }
    public void setDefaultValues(){
        x = 0;
        y = 350;
        speed = 5;
        jumphigh = 150;
        direction = "right";
    }
    public void update(){
        if(System.currentTimeMillis()-lassPress>900){
        if(lastPress<=2){
             lastPress++;
            if(keyH.upPressed == true){
                direction = "up";
                y -= jumphigh;
                Timer timer = new Timer(450,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        y += jumphigh;
                        gp.repaint();
                        //keyH.upPressed = false;
                }
            });
            timer.setRepeats(false);
            timer.start();
            gp.repaint();
            }
        }
        lassPress = System.currentTimeMillis();
        }
        if(lastPress==2&&y==350){
            lastPress = 0;
        }
        else if(keyH.leftPressed == true){
            direction = "left";
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            direction = "right";
            x += speed;
        }
          if(x<0){
            x = 0;
        }
        if(x>550){
            x = 550;
        }
    }

    public BufferedImage getImage(){
        try{
            right1 = ImageIO.read(new File("character\\Maincharacter IDLE.png"));
            left1 = ImageIO.read(new File("character\\Maincharacter IDLE - Copy.png"));
            up = ImageIO.read(new File("character\\Maincharacter IDLE.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return left1;
    }
       public void draw(Graphics2D g2){
         
         BufferedImage image1 = null;
         switch(direction){
             case"left":
                 image1 = left1 ;
                 break;
             case"right":
                 image1 = right1;
                 break;
             case"up":
                 image1 = up;
                 break;
         }
          g2.drawImage(image1,x, y, 100, 100,null);
     }
}
    
