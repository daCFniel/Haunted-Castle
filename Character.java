/**
 * Class Character
 * A character in the game.
 * 
 * @author Olaf Chitil and Daniel Bielech
 * @version 10/02/2020
 */
public class Character
{
    private Room location;

    /**
     * Constructor setting a location.
     * Adding character to the room.
     * Pre-condition: location is not null.
     */
    public Character(Room loc)
    {
        assert loc != null : "Character.Character has null room";
        location = loc;
        sane();
        location.addCharacter(this);
        sane();
    }

    /**
     * Class invariant: location is never null.
     */
    public void sane()
    {
        assert getLocation() != null : "Character: location is null" ;
    }

    /**
     * Get current location of character.
     */
    public Room getLocation()
    {
        return location;
    }
    
    /**
     * Set current location to a given location.
     * @param loc Location to be set.
     */
    public void setLocation(Room loc)
    {
        this.location = loc;
    }

    /**
     * Move character to a given room.
     * This involves removing the character from the room it was before.
     * Works also if previous and new room are the same.
     * Pre-condition: room is not null.
     */
    public void move(Room loc)
    {
        assert loc != null : "Character.move to null room";
        sane();
        location.removeCharacter(this);
        location = loc;
        location.addCharacter(this);
        sane();
    }
}