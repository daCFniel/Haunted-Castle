

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class PlayerTest
{
    private Room r1, r2;
    private Player player;
    
    /**
     * Default constructor for test class PlayerTest
     */
    public PlayerTest()
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
        r1 = new Room("room1");
        r2 = new Room("room2");
        player = new Player(r1, r2);
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
     * Check toString
     */
    @Test
    public void toString1()
    {
        assertEquals("you", player.toString());
    }
    
    /**
     * Check basic move.
     */
    @Test
    public void move()
    {
        player.move(r2);
        assertEquals(r2, player.getLocation());
    }
    
    /**
     * Check isAtGoal and move.
     */
    @Test
    public void isAtGoal()
    {
        assertEquals(false, player.isAtGoal());
        player.move(r2);
        assertEquals(true, player.isAtGoal());
    }
}
