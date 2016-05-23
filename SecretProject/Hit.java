/**
 * Hit is a class that calculates whether or not an attack will hit
 * Gets passed a percent and uses an RNG to see if it hits
 * if x < % it hits
 * The crit method checks to see if the hit is a critical hit, which causes the player to deal 3x the damage
 * The crit uses the hit method to check if the RNG will be below the critical chance
 * 
 * Tyler Castro
 * Verson 1.1
 */
public class Hit
{
    public Hit()
    {
        
    }
    
    public boolean hit(double percent)
    {
        return percent > Math.random()*100;
    }
    
    public int crit(int damage, double percent)
    {
        if(this.hit(percent))
        {
            return damage*3;
        }
        else
        {
            return damage;
        }
    }
}
