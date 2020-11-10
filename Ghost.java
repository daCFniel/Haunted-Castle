import java.util.List;
import java.util.Collections;
import java.util.Random;

/**
 * Class Ghost
 * A ghost in the castle.
 * 
 * @author Olaf Chitil and Daniel Bielech
 * @version 10/02/2020
 */

public class Ghost extends Character
{
    private String description; // description of the ghost
    private Random randomizer; // instance of class Random to generate random number

    /**
     * Constructor initialising location and description.
     * And randomizer.
     * Pre-condition: location not null.
     * Pre-condition: description not null.
     */
    public Ghost(Room loc, String desc)
    {
        super(loc);
        this.description = desc;
        randomizer = new Random();
    }

    /**
     * Return the description.
     */
    public String toString()
    {
        return description; 
    }

    /**
     * Go to a random room.
     * @param rooms all rooms available
     * Pre-condition: the list is not empty.
     */
    public void goRandom(List<Room> rooms)
    {
        super.move(rooms.get(randomizer.nextInt(rooms.size()))); // move to a random room, to achieve this generate random number in range 0 - number of rooms (exclusive).
    }
    
    /**
     * Return randomizer.
     */
    protected Random getRandomizer()
    {
        return randomizer;
    }
}
