
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Entity {
    Gamepanel gp;
    public Entity(Gamepanel gp){
        this.gp = gp;
    }
    public String name;
    public int atk;
    public int Hp;
    public boolean alive;
    public int count;
    public int sprite;
    public int x ,y;
    public int speed;
    public int jumphigh;
    public BufferedImage up1,up2 , left1, left2,right1,right2,Atkright,AtkLeft;
    public String direction;
    public Project_tile project_tile;
    
    public void update(){
        
    }
    public void draw(Graphics2D g2){
        
    }
     public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
}
