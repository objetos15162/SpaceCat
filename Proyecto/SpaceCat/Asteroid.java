import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * This class contains the actor Asteroid.
 * This actor is an obstacle in the game.
 * It contains the damage caused and the poins
 * detracts player.
 * @author (Jessica Ortiz).
 */
public class Asteroid extends Item
{
    /**
     * Constructor for objects of class Asteroid.
     */
    public Asteroid()
    {
        this(5);
    }
    
    public Asteroid(int speed)
    {
        super(speed);
        setValue(-10, -20);
    }
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
         super.act();
    }    
}
