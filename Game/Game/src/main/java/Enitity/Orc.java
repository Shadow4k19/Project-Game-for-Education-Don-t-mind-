package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Orc extends Entity{
    Gamepanel gp;
     public Orc(Gamepanel gp){
         super(gp);
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
        direction = "IDLE";
    }
        public BufferedImage getImage(){
        BufferedImage image = null;
        try{
            left1 = ImageIO.read(new File("character\\Orc_1.png"));
            
            left2 = ImageIO.read(new File("character\\Orc_2.png"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return left1;
    }
         public void update(){
            direction = "IDLE";
            gp.repaint();
            Timer timer = new Timer(120, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    direction = "ATK";
                    gp.repaint();
                }
            });
            timer.setRepeats(false);
            timer.start();
            count++;
        if(count == 120){
           project_tile = new Project_tile(gp);
           project_tile.set(x-80,y+50,"left",true,this);
           gp.projecttile1.add(project_tile);
           count = 0;
        }
        for(int i = 0 ; i < gp.projecttile1.size();i++){
            if(gp.projecttile1.get(i).alive == true){
                gp.projecttile1.get(i).update();
            if(gp.projecttile1.get(i).alive == false){
                gp.projecttile1.remove(i);
            }
    }
    }
}
 
                     
     public void draw(Graphics2D g2){
         
         BufferedImage image = null;
         
         switch(direction){
             case"IDLE":
                 image = left1;
                 break;
             case"ATK":
                 image = left2;
                 break;
             default:{
                 image = left1;
                 break;
             }
         }
          g2.drawImage(image,x, y, 200, 200,null);
        for(int i = 0 ; i< gp.projecttile1.size(); i++){
            if(gp.projecttile1.get(i)!= null){
                gp.projecttile1.get(i).draw(g2);
                gp.projecttile1.get(i).update();
            }
            if(gp.projecttile1.get(i).alive == false){
                gp.projecttile1.remove(i);
            }
     }
     }
   Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while(true){
        gp.repaint();
        //update();
        try{
            thread.sleep(1000);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    }
   });
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,1,1));
    }
    }

