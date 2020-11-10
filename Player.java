/**
 * Class Player
 * A single object represents the single player.
 * 
 * @author Olaf Chitil and Daniel Bielech
 * @version 10/02/2020
 */

public class Player extends Character
{
    private Room goal; // The goal of the game is to reach this room
    private int time; // The time to finish the game (number of movements of player)
    /**
     * Constructor, taking start room and goal room.
     * Initialising time.
     * Pre-condition: start location and goal room is not null.
     */
    public Player(Room start, Room goal)
    {
        super(start);
        this.goal = goal;
        time = 0;
    }
    
    /**
     * Check whether time limit has been reached.
     */
    public boolean isAtTimeLimit()
    {
        if(this.time == 12){
            return true;
        }
        return false; 
    }
    
    /**
     * Check whether goal has been reached.
     */
    public boolean isAtGoal()
    {
        if(super.getLocation().equals(this.goal)){
            return true;
        }
        return false; 
    }
    
    /**
     * Return a description.
     */
    public String toString()
    {
        return "you";
    }    
    
    /**
     * Increment time by one.
     * (player made one step).
     */
    public void incrementTime()
    {
        this.time++;
    }
}
