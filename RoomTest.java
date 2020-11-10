import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoomTest.
 *
 * @author  Olaf Chitil
 * @version 3/2/2020
 */
public class RoomTest
{
    private Room maze, r1, r2;

    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        maze = new Room("in the maze");
        maze.setExit(Direction.EAST, maze);
        maze.setExit(Direction.WEST, maze);
        r1 = new Room("room 1");
        r2 = new Room("room 2");
        r1.setExit(Direction.NORTH, r2);
        r2.setExit(Direction.SOUTH, r1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Check short description.
     */
    @Test
    public void shortDescription()
    {
        assertEquals("in the maze", maze.getShortDescription());
    }

    /**
     * Check long description.
     */
    @Test
    public void longDescription()
    {
        assertEquals("You are in the maze.\nExits: east west", maze.getLongDescription());
    }

    /** 
     * Check existing exit.
     */
    @Test
    public void exitExists()
    {
        assertEquals(maze, maze.getExit(Direction.WEST)); 
    }

    /**
     * Check non-existing exit.
     */
    @Test
    public void exitNonExists()
    {
        assertEquals(null, maze.getExit(Direction.NORTH));
    }

    /**
     * Check long description with a character.
     */
    @Test
    public void longDescriptionChar()
    {
        Character tom = new Ghost(maze,"Tom");
        assertEquals("You are in the maze.\nExits: east west\nCharacters: Tom; ",
            maze.getLongDescription());
    }

    /**
     * Check long description with two characters.
     */
    @Test
    public void longDescriptionChar2()
    {
        Character jason = new Ghost(maze, "Jason");
        Character david = new Ghost(maze, "David");
        assertEquals("You are in the maze.\nExits: east west\nCharacters: David; Jason; ",
            maze.getLongDescription());
    }
    
    /**
     * Check dual of a room.
     */
    @Test
    public void dual1()
    {
        r1.dual();
        assertEquals(null, r1.getExit(Direction.NORTH));
    }
    
    /**
     * Check dual of a room.
     */
    @Test
    public void dual2()
    {
        r1.dual();
        assertEquals(r2, r1.getExit(Direction.SOUTH));
    }
}