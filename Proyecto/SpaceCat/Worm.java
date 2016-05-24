import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * This class contains the actor Worm.
 * This actor is an obstacle in the game. 
 * It contains the damage caused and the poins
 * detracts player
 * @author (Jessica Ortiz).
 */
public class Worm extends Item
{
    private GifImage myGif = new GifImage("gusanos.gif");
    
    /**
     * Constructor for objects of class Worm.
     */
    public Worm()
    {
        this(4);
    }
    
    public Worm(int speed)
    {
        super(speed);
        setValue(-20, -10);
    }
    
    /**
     * Act - do whatever the Worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         setImage(myGif.getCurrentImage());
         move(-super.getSpeed());
    }    
}
