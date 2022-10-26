
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Hound extends Enemy{
     Gamepanel gp;
     Blast blast = new Blast();
     public Hound(Gamepanel gp){
         this.gp = gp;
         setDefaultValues();
         getImage();
     }
      public void setDefaultValues(){
        x = 600;
        y = 285;
        size = 150;
        State = "IDLE";
    }
        public BufferedImage getImage(){
        BufferedImage image = null;
        try{
            idle = ImageIO.read(new File("character\\Hound IDLE.png"));
            
            atk = ImageIO.read(new File("character\\Hound_Atk.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return idle;
    }
        public void update(){
        Timer timer = new Timer(3000,new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        State = "ATK";
                        blast.updateBlast();
                        gp.repaint();
                     }
    });
    timer.setDelay(10000);
    timer.setRepeats(false);
    timer.start();
    State = "IDLE";
    gp.repaint();
    
    }
     public void draw(Graphics2D g2){
         
         BufferedImage image = null;
         
         switch(State){
             case"IDLE":
                 image = idle;
                 break;
             case"ATK":
                 image = atk;
                 break;
         }
          g2.drawImage(image,x, y, 200, 200,null);
          blast.draw(g2,1);
     }
}
