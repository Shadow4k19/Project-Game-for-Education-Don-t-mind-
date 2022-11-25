
package Enitity;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Blast extends JPanel{
  public int x;
  public int y;
  public String direction;
  BufferedImage image;
  public Blast(int x ,int y,String direction){
      this.x = x;
      this.y = y;
      this.direction = direction;
  }
  public void update(){
      switch(direction){
          case"left":{
              x-=3;
          }
          case"right":{
              x+=3;
          }
      }
  }
   public BufferedImage getImage(String direction){
        try{
        switch(direction){
        case"left":{
            image = ImageIO.read(new File("attack animation\\Blast1.png"));
        }
        case"right":{
            image = ImageIO.read(new File("attack animation\\Blast.png"));
        }
        }
        }
        catch(Exception e){
            
        }
        return image;
   }
  public Rectangle2D getbound(){
    return (new Rectangle2D.Double(x,y,25,25));
  }	
}
