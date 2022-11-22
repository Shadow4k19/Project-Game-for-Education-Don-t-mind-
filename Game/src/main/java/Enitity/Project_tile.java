
package Enitity;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Project_tile extends Entity{
    public Entity player;
    public Project_tile(Gamepanel gp){
        super(gp);
    }
    public void set(int x , int y, String direction , boolean alive , Entity player){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.alive = alive;
        this.player = player;
        this.Hp = 80; 
        getImage();
    }
    @Override
    public void update(){
        switch(direction){
            case"left":{
                x-=speed;
                break;
            }
            case"right":{
                x+=speed;
                break;
            }}
            Hp--;
            if(Hp<=0){
                alive = false;
            }
               count++;
        if(count >10){
            if(sprite==1){
                sprite=2;
            }
            else if(sprite == 2){
                sprite=1;
            }
            count = 0;
        }   
        }
        public void getImage(){
        try{
        left1 = ImageIO.read(new File("attack animation\\Blast1.png"));
        right1 = ImageIO.read(new File("attack animation\\Blast.png"));
        }
        catch(Exception e){
            
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case"left":{
                image = left1;
            }
            case"right":{
                image = right1;
        }
    }
        g2.drawImage(image,x, y,100,100,null);
    }
    
}


