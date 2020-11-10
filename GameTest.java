import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameTest.
 *
 * @author  Olaf Chitil
 * @version 4/2/2020
 */
public class GameTest
{
    private Game game;

    /**
     * Default constructor for test class GameTest
     */
    public GameTest()
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
        game = new Game();
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
     * Check that at start not yet finished.
     */
    @Test
    public void notFinished()
    {
        assertEquals(false, game.finished());
    }

    /**
     * Check that finished after quit.
     */
    @Test
    public void quitFinishes()
    {
        assertEquals("Thank you for playing.  Good bye.",game.quit());
        assertEquals(true, game.finished());
    }

    /**
     * Check looking at start.
     */
    @Test
    public void lookAtStart()
    {
        assertEquals(game.getPlayer().getLocation().getLongDescription(), game.look());
    }

    /**
     * Go in wrong direction.
     */
    @Test
    public void goWrong()
    {
        assertEquals("There is no exit in that direction!",
            game.goRoom(Direction.WEST));
    }

    /**
     * Go to goal.
     */
    @Test
    public void goGoal()
    {
        String ig1 = game.goRoom(Direction.NORTH);
        String ig2 = game.goRoom(Direction.NORTH);
        String ig3 = game.goRoom(Direction.UP);
        String result = game.goRoom(Direction.WEST);
        assertEquals(game.getPlayer().getLocation().getLongDescription() + 
            "\nCongratulations! You reached the goal.\nThank you for playing.  Good bye.",
            result);
    }

    /**
     * Run out of time.
     */
    @Test
    public void timeout()
    {
        String ig1 = game.goRoom(Direction.NORTH);
        String ig2 = game.goRoom(Direction.SOUTH);
        String ig3 = game.goRoom(Direction.NORTH);
        String ig4 = game.goRoom(Direction.SOUTH);
        String ig5 = game.goRoom(Direction.NORTH);
        String ig6 = game.goRoom(Direction.SOUTH);
        String ig7 = game.goRoom(Direction.NORTH);
        String ig8 = game.goRoom(Direction.SOUTH);
        String ig9 = game.goRoom(Direction.NORTH);
        String ig10 = game.goRoom(Direction.SOUTH);
        String ig11 = game.goRoom(Direction.NORTH);
        String result = game.goRoom(Direction.SOUTH);
        assertEquals(game.getPlayer().getLocation().getLongDescription() + 
            "\nLost! You ran out of time.\nThank you for playing.  Good bye.", 
            result);
    }

    /**
     * Check looking after a step.
     */
    @Test
    public void lookAfterStep()
    {
        String ignore = game.goRoom(Direction.NORTH); 
        assertEquals(game.getPlayer().getLocation().getLongDescription(), game.look());
    }
}
