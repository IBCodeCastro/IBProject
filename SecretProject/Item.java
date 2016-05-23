/**
 * Item is the class that stores the information about an item
 * Contains the name of the item and how much it is worth
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class Item
{
    String name;
    int value;
    /**
     * Constructor, establishes name of item and its value
     */
    public Item(String n, int v)
    {
        name = n;
        value = v;
    }
    
    /**
     * Returns the value
     */
    public int getValue()
    {
        return value;
    }
    
    /**
     * Returns the name
     */
    public String getName()
    {
        return name;
    }
}
