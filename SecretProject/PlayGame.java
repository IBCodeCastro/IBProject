import java.util.Scanner;
/**
 * PlayGame initiates the game, sets up background story, and collects information
 * This information determines gender of player, gender of person needing to be saved, and names of both, 
 * It sends this information to the classes for text and the captured person
 * 
 * Tyler Castro
 * Verson 1.0
 */
public class PlayGame
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you a returning Player? (y/n)");
        String answer = scan.next();
        if(answer.equalsIgnoreCase("y"))
        {
            AreaLoader loader = new AreaLoader();
            loader.load();
        }
        else
        {
            System.out.println("*-------------------------------*");
            System.out.println("Welcome, Hero! What is your name?");
            System.out.println("*-------------------------------*");
            scan.nextLine();
            String name = scan.nextLine();
            Hero hero = new Hero(name);
            System.out.println("*--------------------------*");
            System.out.println("What is your gender? m or f.");
            System.out.println("*--------------------------*");
            String playerGender = scan.next();
            Lover lover = new Lover(playerGender);
            scan.nextLine();
            System.out.println("*---------------------------------------------*");
            System.out.println("You have a childhood friend. What is " + lover.hisHer + " name?");
            System.out.println("*---------------------------------------------*");
            String loverName = scan.nextLine();
            lover.setName(loverName);
            System.out.println("*----------------------------------------------------*");
            System.out.println("Well then, " + name + ", your quest is about to begin!");
            System.out.println("*----------------------------------------------------*");
            Text text = new Text(name, lover);
            text.opening();
            Tutorial tutorial = new Tutorial(hero, lover, text);
            tutorial.tutorial();
        }
    }
}