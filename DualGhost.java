import java.util.List;
import java.util.Collections;
/**
 * Class DualGhost
 * A dual ghost in the castle.
 * 
 * @author Olaf Chitil and Daniel Bielech
 * @version 15/2/2020
 */

public class DualGhost extends Ghost
{
    /**
     * Constructor initialising location and description.
     * Setting and starting room to dual.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public DualGhost(Room loc, String desc)
    {
        super(loc, desc);
        getLocation().dual();
    }
    
    /**
     * Bring exits of current room back to normal.
     * Go to a random room.
     * Then change its exits to dual. 
     * @param rooms all rooms available 
    */
    public void goRandom(List<Room> rooms)
    {
        getLocation().dual(); 
        super.goRandom(rooms); // move to a random room, to achieve this generate random number in range 0 - number of rooms (exclusive).
        getLocation().dual();
    }
    
    /**
     * Bring exits of current room back to normal.
     * Move character to a given room.
     * This involves removing the character from the room it was before.
     * Works also if previous and new room are the same.
     * Change its exits to dual.
     * This method overrides Character.move method.
     * Pre-condition: room is not null.
     * */
    
    public void move(Room loc)
    {
        assert loc != null : "Character.move to null room";
        sane();
        getLocation().dual(); 
        getLocation().removeCharacter(this);
        setLocation(loc);
        getLocation().addCharacter(this);
        getLocation().dual(); 
        sane();
    }
     
}
