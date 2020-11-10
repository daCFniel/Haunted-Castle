import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Arrays;

/**
 * The test class GhostTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class GhostTest
{
    Room r1, r2;
    Ghost g;
    
    /**
     * Default constructor for test class GhostTest
     */
    public GhostTest()
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
        g = new Ghost(r1, "huibuh");
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
     * Check toString.
     */
    @Test
    public void toString1()
    {
        assertEquals("huibuh", g.toString());
    }
    
    /**
     * Check that after goRandom a ghost is still in some room.
     */
    @Test
    public void goRandom1()
    {
        List<Room> rooms = Arrays.asList(r1,r2);
        g.goRandom(rooms);
        assertTrue(rooms.contains(g.getLocation()));
    }
}
