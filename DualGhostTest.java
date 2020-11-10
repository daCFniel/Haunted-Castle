import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DualGhostTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/20202
 */
public class DualGhostTest
{
    Room r1, r2;
    Ghost g;

    /**
     * Default constructor for test class DualGhostTest
     */
    public DualGhostTest()
    {
        r1 = new Room("room1");
        r2 = new Room("room2");
        r1.setExit(Direction.NORTH, r2);
        r2.setExit(Direction.SOUTH, r1);
        g = new DualGhost(r1, "huibuh");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
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
     * Check that ghost dualises its room.
     */
    @Test
    public void dual1()
    {
        assertEquals(null, r1.getExit(Direction.NORTH));
    }

    /**
     * Check that ghost dualises its room.
     */
    @Test
    public void dual2()
    {
        assertEquals(r2, r1.getExit(Direction.SOUTH));
    }
    
    /**
     * Check that moving dualises room.
     */
    @Test
    public void move1()
    {
        g.move(r2);
        assertEquals(r1, r2.getExit(Direction.NORTH));
    }
}
