import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class SolidGhost
 * A solid ghost in the castle.
 * 
 * @author Olaf Chitil and Daniel Bielech
 * @version 12/02/2020
 */

public class SolidGhost extends Ghost
{
    private ArrayList<Room> availableExits; // stores available exits of current room
    /**
     * Constructor initialising location and description.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public SolidGhost(Room loc, String desc)
    {
        super(loc, desc);
    }
        
    /**
     * Go to a random neighbouring room.
     * If there is no neighbour, then stay in current room.
     * @param rooms all rooms available - actually ignored
     */
    public void goRandom(List<Room> rooms)
    {
        availableExits = new ArrayList<Room>(); // Array to store available exits from current room
        for(Direction exit : getLocation().getExits().keySet()){
                availableExits.add(getLocation().getExits().get(exit));
        }
        if(availableExits.size() == 1){  // If there is only one exit, go there
            move(availableExits.get(0));
        }
        else{ // If there are two or more exits, go to the random chosen exit
            move(availableExits.get(getRandomizer().nextInt(availableExits.size()))); 
        }
    }
}
