package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Orc extends Enemy{
    Gamepanel gp;
     public Orc(Gamepanel gp){
         this.gp = gp;
         thread.start();
         setDefaultValues();
         getImage();
     }
      public void setDefaultValues(){
        x = 600;
        y = 285;
        Hp = 1500;
        size = 150;
        State = "IDLE";
    }
        public BufferedImage getImage(){
        BufferedImage image = null;
        try{
            idle = ImageIO.read(new File("character\\Orc IDLE.png"));
            
            atk = ImageIO.read(new File("character\\Orc_Atk.png"));
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
     }
   Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while(true){
        State = "IDLE";
        //blast.updateBlast();
        gp.repaint();
        State = "ATK";
        //blast1.add(new Blast(x,y+50));
        gp.repaint();
        try{
            thread.sleep(10);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    }
   });
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
    }

