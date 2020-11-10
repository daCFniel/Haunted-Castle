import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  This class is the central class of the "Haunted Castle" application. 
 *  "Haunted Castle" is a very simple, text based game.  Users 
 *  can walk around some castle. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 * @author  Michael Kölling, David J. Barnes, Olaf Chitil and Daniel Bielech
 * @version 10/02/2020
 */

public class Game 
{
    private boolean finished;
    private Player player;
    private ArrayList<Room> rooms; // stores all rooms.
    private ArrayList<Ghost> ghosts; // stores all ghosts.

    /**
     * Create the game and initialise its internal map.
     * Initialise collections of all rooms and all ghots.
     */
    public Game() 
    {
        finished = false;
        rooms = new ArrayList<Room>();
        ghosts = new ArrayList<Ghost>();
        player = createScenario();
    }

    /**
     * Create all the rooms and link their exits together.
     * Also create characters.
     * Add rooms and ghosts to the collections.
     */
    private Player createScenario()
    {
        Room gate, hall, greatHall, staircase, kitchen, chapel, hall2, 
        toilet, bedroom, dungeon;
        
        Ghost lady, headless, skeleton, jack;
               
        // create the rooms
        gate = new Room("at the main gate");
        hall = new Room("in the entrance hall");
        greatHall = new Room("in the great hall");
        staircase = new Room("at the staircase");
        kitchen = new Room("in the kitchen");
        chapel = new Room("in the chapel");
        hall2 = new Room("in the upper hall");
        toilet = new Room("in the toilet");
        bedroom = new Room("in the bedroom");
        dungeon = new Room("in the dungeon");
        
        // initialise room exits
        gate.setExit(Direction.NORTH, hall);
        hall.setExit(Direction.SOUTH, gate);
        hall.setExit(Direction.NORTH, staircase);
        hall.setExit(Direction.WEST, kitchen);
        hall.setExit(Direction.EAST, greatHall);
        kitchen.setExit(Direction.EAST, hall);
        greatHall.setExit(Direction.WEST, hall);
        greatHall.setExit(Direction.SOUTH, chapel);
        chapel.setExit(Direction.NORTH, greatHall);
        staircase.setExit(Direction.SOUTH, hall);
        staircase.setExit(Direction.DOWN, dungeon);
        dungeon.setExit(Direction.UP, staircase);
        staircase.setExit(Direction.UP, hall2);
        hall2.setExit(Direction.DOWN, staircase);
        hall2.setExit(Direction.SOUTH, toilet);
        toilet.setExit(Direction.NORTH, hall2);
        hall2.setExit(Direction.WEST, bedroom);
        bedroom.setExit(Direction.EAST, hall2);
        
        // add rooms to the collection        
        Collections.addAll(rooms, gate, hall, kitchen, greatHall, chapel, staircase, dungeon, hall2, toilet, bedroom);
        
        // create and initialise ghosts
        lady = new Ghost(toilet, "white lady");
        headless = new Ghost(dungeon, "creepy headless");
        skeleton = new SolidGhost(chapel, "spooky skeleton");
        jack = new DualGhost(bedroom, "deadly jack");
        
        // add ghosts to the collection
        Collections.addAll(ghosts, lady, headless, skeleton, jack);
        
        return new Player(gate, bedroom);
    }

    /**
     * Return the player object.
     */
    public Player getPlayer()
    {
        return player;
    }
    
    /**
     * Return whether the game has finished or not.
     */
    public boolean finished()
    {
        return finished;
    }

    /**
     * Opening message for the player.
     */
    public String welcome()
    {
        return "\nWelcome to the Haunted Castle!\n" +
        "Haunted Castle is a new game.\n" +
        player.getLocation().getLongDescription() + "\n";
    }

    // implementations of user commands:
    /**
     * Give some help information.
     */
    public String help() 
    {
        return "You are lost. You are alone. You wander around the castle.\n";
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room and return its long description; otherwise return an error message.
     * Make all the ghost move.
     * Check if you reach a goal or not.
     * Check if you ran out of time.
     * @param direction The direction in which to go.
     * Pre-condition: direction is not null.
     */
    public String goRoom(Direction direction) 
    {
        assert direction != null : "Game.goRoom gets null direction";

        // Try to leave current room.
        Room nextRoom = player.getLocation().getExit(direction);

        if (nextRoom == null) {
            return "There is no exit in that direction!";
        }
        else {     
            player.move(nextRoom);
            
            for(Ghost ghost : ghosts){
               ghost.goRandom(rooms);
            }
            
            player.incrementTime();
            if(player.isAtGoal()){
               return goalReached();         
            }
            if(player.isAtTimeLimit()){
               return timesUp();
            }
                
            return player.getLocation().getLongDescription();
        }
    }

    /**
     * Execute quit command.
     */
    public String quit()
    {
        finished = true;
        return "Thank you for playing.  Good bye.";
    }
    
    /**
     * Execute look command.
     */
    public String look()
    {
        return player.getLocation().getLongDescription(); 
    }
    
    /**
     * Return a message for a player when they reach the goal
     * and finish the game.
     */
    public String goalReached()
    {   
        finished = true;
        return player.getLocation().getLongDescription() + 
            "\nCongratulations! You reached the goal.\nThank you for playing.  Good bye.";
        //"Congratulations! You are "+player.getLocation().getShortDescription()+". You WON!";
    }
    
    /**
     * Return a message for a player when they run out of time
     * and finish the game.
     */
    public String timesUp()
    {
        finished = true;
        return player.getLocation().getLongDescription() + 
            "\nLost! You ran out of time.\nThank you for playing.  Good bye.";
        //Failure! You ran out of time. You LOST!";
    }
    
    // Method used for testing/debugging
    /**
     * Very basic representation of the map.
     * Print characters in each room
     * and description of each room.
     */
    public void mapPreview()
    {
          System.out.println();
                for(Room room : rooms){
                System.out.println(room.getCharacters() + " " + room.getShortDescription());
            }
    }
}
