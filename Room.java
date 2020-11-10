import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Class Room - a room in a game.
 *
 * This class is part of the "Haunted Castle" application. 
 * "Haunted Castle" is a very simple, text based travel game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling, David J. Barnes, Olaf Chitil and Daniel Bielech
 * @version 15/02/2020
 */

public class Room 
{
    private String description;
    private HashMap<Direction, Room> exits; // stores exits of this room.
    private HashMap<Direction, Room> dualExits; // stores dual exits of this room.
    private HashMap<Direction, Room> temp; // stores exits, temporary.
    private ArrayList<Character> characters; // stores characters in this room.
    private Stack<Character> charactersStack; // stack to store characters in this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * Initialise all collections.
     * @param description The room's description.
     * Pre-condition: description is not null.
     */
    public Room(String description) 
    {
        assert description != null : "Room.Room has null description";
        this.description = description;
        exits = new HashMap<Direction, Room>();
        dualExits = new HashMap<Direction, Room>();
        temp = new HashMap<Direction, Room>();
        characters = new ArrayList<Character>();
        charactersStack = new Stack<Character>();
        sane();
    }

    /**
     * Class invariant: getShortDescription() and getLongDescription() don't return null.
     */
    public void sane()
    {
        assert getShortDescription() != null : "Room has no short description" ;
        assert getLongDescription() != null : "Room has no long description" ;
    }

    /**
     * Define an exit and a dual exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     * Pre-condition: neither direction nor neighbor are null; 
     * there is no room in given direction yet.
     */
    public void setExit(Direction direction, Room neighbor) 
    {
        assert direction != null : "Room.setExit gets null direction";
        assert neighbor != null : "Room.setExit gets null neighbor";
        assert getExit(direction) == null : "Room.setExit set for direction that has neighbor";
        sane();
        exits.put(direction, neighbor);
        dualExits.put(direction.dual(), neighbor);
        sane();
        assert getExit(direction) == neighbor : "Room.setExit has wrong neighbor";
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     Characters: you;
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + getCharacterString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        // Ensure some fixed ordering of keys, so that return String uniquely defined.
        List<String> es = exits.keySet().stream().map(Direction::toString).sorted().collect(Collectors.toList());
        for(String e : es) {
            returnString += " " + e;
        }
        return returnString;
    }
    
    /**
     * Return a string describing characters in this room, for example
     * "Characters: You; Lady".
     * @return Details of the characters in current room.
     */
    private String getCharacterString()
    {       
        if(!characters.isEmpty()){
            String returnString = "\nCharacters: ";
            for(Character c : characters){
                charactersStack.push(c);
            }
            while(!charactersStack.isEmpty()){
            	returnString += charactersStack.pop().toString()+"; ";
            }
            return returnString;
        }        
        else{
            return "";
        }
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     * Pre-condition: direction is not null
     */
    public Room getExit(Direction direction) 
    {
        assert direction != null : "Room.getExit has null direction";
        sane();
        return exits.get(direction);
    }

    /**
     * Add given character to the room
     * @param c The character to add.
     * Pre-condition: character is not null.
     * Pre-condition: character itself has this room as location.
     */
    public void addCharacter(Character c)
    {
        characters.add(c);
    }

    /**
     * Remove given character from the room.
     * @param c The character to remove.
     * Pre-condition: character is not null.
     * Pre-condition: character itself has this room as location.
     */
    public void removeCharacter(Character c)
    {
        characters.remove(c);
    }
    
    /**
     * Change all exits of a room to their dual.
     * If the room is already dual
     * change all the exits back to normal.
     */
    public void dual()
    {
        if(temp.isEmpty()){
            temp.putAll(exits);
            exits.clear();
            exits.putAll(dualExits);
        }
        else{
            exits.clear();
            exits.putAll(temp);
            temp.clear();
        }
    } 
    
    /**
     * Return collection of available exits of the current room.
     */
    public HashMap<Direction, Room> getExits()
    {
        return exits;        
    }
    
    // Method used for testing/debuging
    /**
     * Return characters in current room.
     */
    public ArrayList<Character> getCharacters()
    {
        return characters;
    }
}

