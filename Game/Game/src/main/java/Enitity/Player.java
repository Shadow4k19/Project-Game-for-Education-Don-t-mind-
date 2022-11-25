
package Enitity;

import com.mycompany.game.Gamepanel;
import com.mycompany.game.KeyHandler;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Player extends Entity{
    
    Gamepanel gp;
    KeyHandler keyH;
    public int lastPress;
    public long lassPress = 0;
    public int count = 0;
    public int sprite = 1;
    //public ArrayList<Blast> blast = new ArrayList<Blast>();
    
    public Player(Gamepanel gp,KeyHandler keyH,int x ,int y,int Hp){
        super(gp);
        this.gp = gp;
        this.keyH = keyH;
        this.x = x;
        this.y = y;
        this.Hp = Hp;
        thread.start();
        
        //theard.start();
        setDefaultValues();
        getImage();
    }
    
    public void setDefaultValues(){
        x = 0;
        y = 350;
        speed = 5;
        jumphigh = 150;
        direction = "right";
        project_tile = new Project_tile(gp);
        Hp = 10;
        alive = true;
    }
    public void update(){
        if(keyH.leftPressed==true||keyH.rightPressed==true||keyH.upPressed==true){
              if(System.currentTimeMillis()-lassPress>70){
        if(lastPress<2){
            if(keyH.upPressed == true){
                direction = "up";
                y -= jumphigh;
                Timer timer = new Timer(450,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        y += jumphigh;
                        gp.repaint();
                }
            });
            timer.setRepeats(false);
            timer.start();
            gp.repaint();
            }
            lastPress += 1;
            //System.out.println(lastPress);
        }
        lassPress = System.currentTimeMillis();
        }
            if(y==350){
            if(keyH.leftPressed == true){
                direction = "left";
                x -= speed;
            }
            else if(keyH.rightPressed == true){
                direction = "right";
                x += speed;
            }
        }
        count++;
        if(count >10){
            if(sprite == 1){
                sprite = 2;
            }
            else if(sprite == 2){
                sprite = 1;
            }
            count = 0;
        }    
    }
           if(keyH.ATK == true && project_tile.alive == false){
                //if(direction == "right")
                    project_tile.set(x+80,y,"right",true,this);
                //else
                    //project_tile.set(x-80,y,direction,true,this);
                
                gp.projecttile.add(project_tile);
                //System.out.println(direction);
            }

        if(lastPress==2&&y==350){
            lastPress = 0;
        }
        if(x<0){
            x = 0;
        }
        if(x>550){
            x = 550;
        }
            for(int i = 0 ; i < gp.projecttile.size();i++){
            if(gp.projecttile.get(i).alive == true){
                gp.projecttile.get(i).update();
            if(gp.projecttile.get(i).alive == false){
                gp.projecttile.remove(i);
            }
    }
}
}
    public BufferedImage getImage(){
        try{
            right1 = ImageIO.read(new File("character\\Main_Walk_03.png"));
            right2 = ImageIO.read(new File("character\\Main_Walk_04.png"));
            left1 = ImageIO.read(new File("character\\Main_Walk_01.png"));
            left2 = ImageIO.read(new File("character\\Main_Walk_02.png"));
            up2 = ImageIO.read(new File("character\\Main_Jump_01.png"));
            up1 = ImageIO.read(new File("character\\Main_Jump_02.png"));
            Atkright = ImageIO.read(new File("character\\Main_ATK_02.png"));
            AtkLeft = ImageIO.read(new File("character\\Main_ATK_1.png"));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return left1;
    }
       public void draw(Graphics2D g2){
         
         BufferedImage image1 = null;
         switch(direction){
             case"left":
                 if(sprite == 1){
                    image1 = left1 ;
                 }
                 else if(sprite == 2){
                    image1 = left2;
                 }
                 if(keyH.ATK == true){
                     image1 = AtkLeft;
                 }
                 break;
             case"right":
                 if(sprite==1){
                    image1 = right1;
                 }
                 else if(sprite==2){
                     image1 = right2;
                 }
                 if(keyH.ATK == true){
                     image1 = Atkright;
                 }
                 break;
             case"up":
                 image1 = up1;
                 break;
         }
          g2.drawImage(image1,x, y, 100, 100,null);
         if(y == 350){
             image1 = left1;
             gp.repaint();
         }
         for(int i = 0 ; i< gp.projecttile.size(); i++){
            if(gp.projecttile.get(i)!= null){
                gp.projecttile.get(i).draw(g2);
                gp.projecttile.get(i).update();
            }
            if(gp.projecttile.get(i).alive == false){
                gp.projecttile.remove(i);
            }
        }
       }

    Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        while(true){
        gp.repaint();       
        try{
            thread.sleep(1000);
        }catch(Exception e){
            System.err.println(e);
        }
        
    }
    }
})  ;
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,1,1));
    }
}
    
