
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;


public class Blast {
    
    public int Speed;
    public int x;
    public int y;
    public int count;

    public Blast() {
     SetDefaultBlast();
     getImageBlast(count);
    }
    
    public void SetDefaultBlast(){
        x = 580;
        y = 355;
        Speed = 5;
    }
    
    public void updateBlast(){
         Timer timer = new Timer(Speed,new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        x -= Speed;
                     }
    });
         timer.setDelay(1000);
         timer.setRepeats(false);
         timer.start();
         if(x<=0){
             //dispear
             x = 580;
         }
    }
    public BufferedImage getImageBlast(int count){
        BufferedImage image = null;
        try{
           if(count == 1){
           image = ImageIO.read(new File("attack animation\\Blast.png"));
           return image;
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }
  
    public void draw(Graphics2D g2,int count){
        g2.drawImage(getImageBlast(count),x, y, 150, 100,null);
    }
    
}
