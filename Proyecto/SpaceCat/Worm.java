import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Worm here.
 * This class contains the actor Worm
 * This actor is an obstacle in the game
 *
 */
public class Worm extends food
{
    GifImage myGif = new GifImage("gus.gif");
    
    /**
     * Act - do whatever the Worm wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Worm()
    {
        setSpeed(5);
      
    }
    
    public void act() 
    {
         setImage(myGif.getCurrentImage());
         
    }    
}
