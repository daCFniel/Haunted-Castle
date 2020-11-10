import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SolidGhostTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class SolidGhostTest
{
    Room r1, r2;
    SolidGhost g;
    
    /**
     * Default constructor for test class SolidGhostTest
     */
    public SolidGhostTest()
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
        r1.setExit(Direction.NORTH, r2);
        r2.setExit(Direction.SOUTH, r1);
        g = new SolidGhost(r1, "huibuh");
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
     * Check that after goRandom a ghost is still in some room.
     */
    @Test
    public void goRandom1()
    {
        List<Room> rooms = Arrays.asList(r1,r2);
        g.goRandom(rooms);
        assertTrue(rooms.contains(g.getLocation()));
    }
        
    /**
     * Check that after goRandom the ghost is in the only neighbouring
     * room.
     */
    @Test
    public void goRandom2()
    {
        g.goRandom(new LinkedList<Room>());
        assertEquals(r2, g.getLocation());
    }
}
