
/**
 *  This class is the main class of the "Haunted Castle" application. 
 *  It provids a text-based user interface to the "Haunted Castle".
 *  "Haunted Castle" is a very simple, text based travel game.  Users 
 *  can walk around a castle. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * @author Michael Kölling, David J. Barnes and Olaf Chitil
 * @version 3/2/2020
 */
public class GameMain
{
    private Game game;
    private Parser parser;

    /**
     * Initialise.
     */
    public GameMain()
    {
        game = new Game();
        parser = new Parser();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        System.out.println(game.welcome());
        System.out.println(getHelp());

        while (! game.finished()) {
            Command command = parser.getCommand();
            System.out.println(command.process(this, game));
        }
    }

    /**
     * Main method; used if the game is standalone, outside BlueJ.
     */
    public static void main(String[] args)
    {
        GameMain gameMain = new GameMain();
        gameMain.play();
    }

    /**
     * Tell player how to obtain help.
     */
    public String getHelp()
    {
        return "Type '" + parser.help() + "' if you need help.";
    }

    /**
     * Tell player available commands.
     */
    public String getCommands()
    {
        return "Your commands are: " + parser.commands();
    }
}
