

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DirectionTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class DirectionTest
{
    /**
     * Default constructor for test class DirectionTest
     */
    public DirectionTest()
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
     * Check that each direction yields the expected description.
     */
    @Test
    public void descriptions()
    {
        assertEquals("north", Direction.NORTH.toString());
        assertEquals("west", Direction.WEST.toString());
        assertEquals("south", Direction.SOUTH.toString());
        assertEquals("east", Direction.EAST.toString());
        assertEquals("up", Direction.UP.toString());
        assertEquals("down", Direction.DOWN.toString());
    }
    
    /**
     * Check dual is correct.
     */
    @Test
    public void dual()
    {
        assertEquals(Direction.NORTH, Direction.SOUTH.dual());
        assertEquals(Direction.SOUTH, Direction.NORTH.dual());
    }
    
    /**
     * Check dual of a dual gives original.
     */
    @Test
    public void dualdual()
    {
        for (Direction d : Direction.values()) {
            assertEquals(d, d.dual().dual());
        }
    }
}
