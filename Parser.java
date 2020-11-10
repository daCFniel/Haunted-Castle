import java.util.Scanner;
import java.util.HashMap;

/**
 * This class is part of the "Haunted Castle" application. 
 * "Haunted Castle" is a very simple, text based travel game.  
 * 
 * This parser reads user input and tries to interpret it as a
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two-word command. It returns the command
 * as an object of interface Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command that says that input command is unknown.
 * 
 * @author  Michael Kölling, David J. Barnes, Olaf Chitil and Daniel Bielech
 * @version 10/02/2020
 */
public class Parser 
{
    private Scanner reader;         // source of command input
    private HashMap<String,Direction> directions;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        reader = new Scanner(System.in);
        directions = new HashMap<String,Direction>();
        for (Direction direction : Direction.values()) {
            directions.put(direction.toString(), direction);
        }
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word = null;

        System.out.print("\n> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word = tokenizer.next();      // get first word
            switch (word) {
                case "go" : Direction direction = parseEnum(tokenizer,directions);
                if (direction != null) {
                    return (GameMain ui, Game game) -> game.goRoom(direction);
                }
                break;
                case "help" : return (GameMain ui, Game game) -> game.help() + ui.getCommands();
                case "quit" : return (GameMain ui, Game game) -> game.quit();
                case "look" : return (GameMain ui, Game game) -> game.look();
            }

            // note: we just ignore the rest of the input line.
        }

        return (GameMain ui, Game game) -> "I do not understand this command.";
    }

    /**
     * Parse an value of a type that is an Enum.
     * The mapping from strings to values of the type is in the map.
     * Pre-condition: tokenizer is not null and map is not null.
     * If parsing fails, the result is null.
     */
    private <T> T parseEnum(Scanner tokenizer, HashMap<String,T> map)
    {
        assert tokenizer != null : "Parser.parseEnum gets null tokenizer";
        assert map != null : "Parser.parseEnum gets null map";
        if (tokenizer.hasNext()) {
            String word = tokenizer.next();
            return map.get(word);
        }
        return null;
    }

    /**
     * Returns a list of valid commands.
     */
    public String commands()
    {
        return "go <direction>, quit, help, look";
    }

    /**
     * Returns name of help command.
     */
    public String help()
    {
        return "help";
    }
}
