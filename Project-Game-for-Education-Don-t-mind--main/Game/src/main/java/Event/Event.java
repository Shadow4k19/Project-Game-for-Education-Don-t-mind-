
package Event;

import com.mycompany.game.Gamepanel;
import java.awt.geom.Rectangle2D;


public class Event {
    Gamepanel gp;
    public Event(Gamepanel gp){
        this.gp = gp;
    }
    public boolean Check(Rectangle2D a,Rectangle2D b){
        return !(a.intersects(b));
    }
}
