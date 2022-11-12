
package Enitity;

import com.mycompany.game.Gamepanel;


public class Project_tile extends Entity{
    Entity player;
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
    }
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
    }

