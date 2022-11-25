
package tile;

import com.mycompany.game.Gamepanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;


public class TileManager {
    Gamepanel gp;
    Tile[] tile;
    int mapTile[][];
    
    public TileManager(Gamepanel gp){
        this.gp = gp;
        tile = new Tile[10];
        mapTile = new int[gp.maxScreenCol][gp.maxScreenRow];
        loadmap();
        getTileImage();
    }
    
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("tile\\Dirt.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("character\\Orc IDLE.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadmap(){
        try{
            File file = new File("map\\Map.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int column = 0 ;
            int row = 0;
            
            while(column<gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                while(column < gp.maxScreenCol){
                    String number[] = line.split(" ");
                    
                    int num = Integer.parseInt(number[column]);
                    
                    mapTile[column][row] = 0 ;
                    column++;
                }
                if(column == gp.maxScreenCol){
                    column = 0;
                    row++;
                }
                
        }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        int column = 0,row = 0 , x = 0,y = 0;
        
        while(column<gp.maxScreenCol && row < gp.maxScreenRow){
            int tileNum = mapTile[column][row]; 
            g2.drawImage(tile[tileNum].image, x,y,gp.titleSize,gp.titleSize, null);
            column++;
            x+= gp.titleSize;
            if(column == gp.maxScreenCol){
                column = 0;
                x = 0;
                y+= gp.titleSize;
                row++;                
            }
        }
        
    }
}
