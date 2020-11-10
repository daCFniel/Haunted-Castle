/**
 * Type of any valid command of the game.
 * All commands implement this interface.
 * 
 * @author Olaf Chitil
 * @version 3/2/2020
 */
public interface Command
{
    /**
     * Process, that is, execute the command in the game.
     * @param ui  The user interface of the game.
     * @param game The actual game.
     * @return Message to the player.
     */
    public String process(GameMain ui, Game game); 
}

