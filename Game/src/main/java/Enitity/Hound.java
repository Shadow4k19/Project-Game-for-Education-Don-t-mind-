
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Hound extends Enemy {
     Gamepanel gp;
     //Blast blast = new Blast(gp);
     public ArrayList<Blast> blast1 = new ArrayList<Blast>();
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
            //State = "ATK";
            //gp.repaint();
            //thread.start();
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
             default:{
                 image = idle;
                 break;
             }
         }
          g2.drawImage(image,x, y, 200, 200,null);
            /*for (int i = 0; i < blast1.size(); i++) {
                Blast blast = blast1.get(i);
                blast.draw(g2, i);
                blast.updateBlast();
                blast.count++;
                if (blast.x < 0) {
                    blast1.remove(i);
                }
            }*/
     }
   Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while(true){
        State = "IDLE";
        //blast.updateBlast();
        gp.repaint();
        State = "ATK";
        blast1.add(new Blast(x,y+50));
        gp.repaint();
        try{
            thread.sleep(10);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    }
   });
}
