import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Text is the class that contains most of the lines of dialogue
 * Contains the hero and the lover classes
 * Only uses them for names and gender pronouns
 * Text includes things like Between Area dialogues
 * Sole purpose is to not have to clutter up the area classes with dialogue
 * Method names describe the scenario in which they are used
 * Now uses stored text files for the sections that don't have personalized sections
 * Personalized sections are the ones that have to use string variables somewhere in the middle 
 * because that would take multiple text files
 * 
 * Tyler Castro
 * Verson 3.0
 */
public class Text
{
    String name;
    Lover lover;
    Scanner scan = new Scanner(System.in);
    ReadFile reader = new ReadFile();
    /**
     * Constructor used to test the methods
     */
    public Text()
    {
        lover = new Lover("m", "Example Name");
    }

    /**
     * Constructor, gets the Hero and Lover classes that contain info like which pronoun to use and their names
     */
    public Text(String n, Lover q)
    {
        name = n;
        lover = q;
    }

    public void opening()
    {
        System.out.println("*-----------------------------------------------------------------------------------*");
        System.out.println("You live in  small, peaceful village of Amane in a world known as The Realm");
        System.out.println("Both of your parents went out on an excursion a couple years back and never returned");
        System.out.println("Your childhood fried " + lover.name + " takes care of you in their place");
        System.out.println("You spend your days doing odd jobs for as much Laz as you can, but it's barely enough");
        System.out.println("But that all changed when one day, the sky turned crimson");
        System.out.println("That day, the village was attacked by monsters!");
        System.out.println("Now, you must fight to protect " + lover.name);
        System.out.println("*-----------------------------------------------------------------------------------*");
    }

    public void forestEncounter()
    {
        System.out.println("*-------------------------------------------------------------------------------*");
        System.out.println("You defeat the Goblin Lord Xdgaf, but it's too late");
        System.out.println("While you were dealing with him, he had his minions kidnap " + lover.name);
        System.out.println("You chase after them into the forest, where you easily lose sight of them");
        System.out.println("\"Dammit!\", you shout, \"I couldn't protect " + lover.himHer + "!\"");
        reader.readIn("ForestEncounter");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void forestToCastle()
    {
        reader.readIn("Forest");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void castleToLabyrinth()
    {
        System.out.println("*------------------------------------------------------------------------------------*");
        System.out.println("\"Are you absolutely sure that this is the only way to save " + lover.name + "?\", you ask");
        reader.readIn("Castle");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void labyrinthToTemple()
    {
        reader.readIn("Labyrinth");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void getBlessing()
    {
        reader.readIn("Blessing");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void templeToHell()
    {
        System.out.println("*-------------------------------------------------------------------------------------------------*");
        System.out.println("\"Now that you've got Her Ladyship's blessing, you've become like a real hero\", cheers Marie");
        System.out.println("\"What was the purpose to all of that?\", you question");
        System.out.println("\"Well, we're going to rescue your " + lover.boyGirl + "friend from the evil clutches of the evil guy\"");
        reader.readIn("Temple");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void endlessEight()
    {
        reader.readIn("Infinity");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void endlessIntro()
    {
        reader.readIn("EndlessIntro");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void lunchIncident()
    {
        reader.readIn("Lunch");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void timeLoop(Object x)
    {
        reader.readIn("TimeLoop1");
        System.out.println("\"Let's see, this would be the attempt number " + x + "\"");
        System.out.println("\"We've done the exact same thing " + x + " times!?\"");
        reader.readIn("TimeLoop2");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void endlessFalseEnd(int x)
    {
        reader.readIn("Riddle" + x);
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void endlessFinale()
    {
        reader.readIn("EndlessFinale");
        System.out.println("You're not just some random person, you're the hero, " + name);
        System.out.println("And it's time for you to destory the one that trapped you here");
        System.out.println("The world around you shimmers, and you find yourself back in the cave, with your gear next to you");
        System.out.println("\"Oh, we're back\", Marie says");
        System.out.println("\"Lets make this creep pay!\", you shout");
        System.out.println("*-------------------------------------------------------------------------------------------------*");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void hellToHellCastle()
    {
        reader.readIn("Hell");
        System.out.println("\"That sword's name is Zettō Kanna, the Absolute Sword. We just call it the Plane.\"");
        System.out.println("\"So what's up with it? Why is it so special, other than it being a straight katana?\"");
        System.out.println("\"The sword is unbreakable. No matter what is done to it, it will neither bend nor break\"");
        System.out.println("\"Are the other swords special like this?\"");
        System.out.println("\"Yes. And some may not look like a sword, but they are blades nonetheless. Now go, you must hurry\"");
        System.out.println("\"Thank you so much for this, I swear that I shall defeat the Demon King and return\"");
        System.out.println("....");
        System.out.println("The path to the castle is long and arduous, but you finally arrive at the gates, which seem to be unguarded");
        System.out.println("\"Well, let's go in, shall we?\", Marie quips");
        System.out.println("You push open the gate and slip inside");
        System.out.println("*----------------------------------------------------------------------------------------------------*");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }
    
    public void swordWall()
    {
        reader.readIn("SwordWall");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }
    
    public void altar()
    {
        reader.readIn("Altar");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void castleToFinal()
    {
        reader.readIn("HellCastle");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }
    
    public void finalInterrupt()
    {
        reader.readIn("Final");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }
    
    public void finisher()
    {
        reader.readIn("Finisher");
        System.out.println("Press any key + enter to continue");
        String s = scan.next();
    }

    public void badEnd()
    {
        System.out.println("*---------------------------------------------------------------------*");
        System.out.println("You have failed, " + name);
        System.out.println("The Demon King has triumphed, and has enslaved everyone");
        System.out.println("You live out the rest of your days as a plaything for the Demon King");
        System.out.println("Eventually, your spirit breaks and you give in and accept your position");
        System.out.println("Sometimes you look back and think \"What could I have done differently?\"");
        System.out.println("\"Can I still save " + lover.himHer + "\"");
        System.out.println("But then you remember your position and silently weep");
        System.out.println("" + name + " is found dead a short while later, and is remembered as a failure");
        System.out.println("\"Good job, hero\", mocks a hypnotized" + lover.name);
        System.out.println("\"I always knew you were a failure\"");
        System.out.println("*---------------------------------------------------------------------*");
        System.out.println("\t\tBAD END\n");
    }

    public void goodEnd()
    {
        System.out.println("*---------------------------------------------------------------------------------------*");
        System.out.println("Congratulations, " + name + ", you have defeated the Demon King and saved The Realm!");
        System.out.println("                              You are a true hero!");
        System.out.println("As the Demon King falls, the door to the room behind him swings open");
        System.out.println("Out rushes your childhood friend, and you lovingly embrace each other");
        System.out.println("\"Sorry I'm late\", you say");
        System.out.println("\"What took you so long, dummy\", " + lover.name + " says sheepishly");
        System.out.println("In the following years, you and " + lover.name + " are wed and have one daughter, whom you decide to name Marie");
        System.out.println("As a reward for your accomplishments, you are given the throne");
        System.out.println("Your first order as king is to rebuild your village");      
        System.out.println("Your next order is to hire Katherine as the Royal physician");
        System.out.println("The Realm is enjoying an era of peace and prosperity known as \"The " + name + " Era\"");
        System.out.println("With your bloodline at the throne, The Realm will remain peaceful for many years to come");
        System.out.println("*---------------------------------------------------------------------------------------*");
        System.out.println("\t\tGOOD END\n");
    }

    public void credits()
    {
        System.out.println("\t\tCredts:\n");
        System.out.println("Designer: Tyler Castro");
        System.out.println("Programmer: Tyler Castro");
        System.out.println("Quality Assurance: Tyler Castro");
        System.out.println("Koalaty Insurance: Indiana Jancich");
        System.out.println(name + ": You (The Player)");
        System.out.println(lover.name + ": Some Bits of Code (Sorry, " + lover.heShe + " isn't real)");
        System.out.println("Marie: More code (Yeah, not real. Sorry)");
        System.out.println("Anything else: Probably Tyler");
        System.out.println("Special thanks to Mr. Wolfard:");
        System.out.println("For putting up with me");
        System.out.println("\nThank you so much for playing my game!");
    }
}

class ReadFile
{
    public ReadFile()
    {

    }

    public void readIn(String name)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(name + ".txt"));
            for (String line; (line = br.readLine()) != null;) 
            {
                System.out.print(line + "\n");
            }
        }
        catch(IOException whoops)
        {
            System.out.println("That file does not exist");
        }
    }
}