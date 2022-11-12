
package Enitity;

import com.mycompany.game.Gamepanel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Blast extends Project_tile{
    Gamepanel gp;
    public Blast(Gamepanel gp) throws IOException{
        super(gp);
        this.gp = gp;
        name = "blast";
        speed = 5;
        atk = 3;
        alive = false;
        getImage();
    }
    public void getImage() throws IOException{
        left1 = ImageIO.read(new File("attack animation//Blast.png"));
        right1 = ImageIO.read(new File("attatck animetion//Blast1.png"));
    }
}
