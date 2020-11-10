
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CharacterTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class CharacterTest
{
    private Room r1, r2;
    private Character alex;

    /**
     * Default constructor for test class CharacterTest
     */
    public CharacterTest()
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
        alex = new Character(r1);
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
     * Check getLocation.
     */
    @Test
    public void getLocation()
    {
        assertEquals(r1, alex.getLocation());
    }
    
    /**
     * Check move.
     */
    @Test
    public void move()
    {
        alex.move(r2);
        assertEquals(r2, alex.getLocation());
    }
}
