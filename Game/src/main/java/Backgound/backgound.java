
package Backgound;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class backgound {
    public final int x = 0;
    public final int y = 10;
    public final int width = 800;
    public final int hight = 550;
    Gamepanel gp ;
    public backgound(Gamepanel gp){
        this.gp = gp;
    }
    public BufferedImage getImage(){
        BufferedImage image = null;
        try{
            image = ImageIO.read(new File("tile\\Map_01.png"));
        }catch(Exception e){
            System.err.println(e);
        }
        return image;
    }
    public void draw(Graphics2D g){
        g.drawImage(getImage(),x,y,width,hight,null);
    }
}
