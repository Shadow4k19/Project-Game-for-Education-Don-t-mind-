
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public abstract class Entity extends JPanel{
    Gamepanel gp;
    public Entity(Gamepanel gp){
        this.gp = gp;
    }
    public String name;
    public int atk;
    public int Hp;
    public boolean alive;
    public int size;
    public int count;
    public int sprite;
    public int x ,y;
    public int speed;
    public int jumphigh;
    public BufferedImage up1,up2 , left1, left2,right1,right2,Atkright,AtkLeft;
    public String direction;
    public Project_tile project_tile;
    public Project_tile project_tile1;
    
    public abstract void update();
    public abstract void draw(Graphics2D g2);
    public abstract Rectangle2D getbound();
}
