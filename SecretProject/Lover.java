
/**
 * Lover is the class that stores the information about the love interest
 * Contains nothing but the gender specific pronouns (Determined by the player's gender) and the name
 * 
 * Tyler Castro
 * Verson 2.1
 */
public class Lover
{
    String hisHer;
    String himHer;
    String heShe;
    String name;
    String boyGirl;
    /**
     * Constructor, establishes which pronoun to use
     */
    public Lover(String gender)
    {
        if(gender.equalsIgnoreCase("f"))
        {
            hisHer = "his";
            himHer = "him";
            heShe = "he";
            boyGirl = "boy";
        }
        else
        {
            hisHer = "her";
            himHer = "her";
            heShe = "she";
            boyGirl = "girl";
        }
        name = "";
    }

    /**
     * Constructor, establishes which pronoun to use and the name
     */
    public Lover(String gender, String n)
    {
        name = n;
        if(gender.equalsIgnoreCase("f"))
        {
            hisHer = "his";
            himHer = "him";
            heShe = "he";
            boyGirl = "boy";
        }
        else
        {
            hisHer = "her";
            himHer = "her";
            heShe = "she";
            boyGirl = "girl";
        }
    }

    /**
     * Sets the name of the love interest
     */
    public void setName(String n)
    {
        name = n;
    }
}
