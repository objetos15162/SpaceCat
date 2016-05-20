import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class food here.
 * 
 * @author (Jessica de Jesus Ortiz Tobias) 
 * @version (a version number or a date)
 */
public class food extends Actor
{
    private int points;
    private int health;
    private int speed;

    /**
     * Act - do whatever the food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
        turn(1);
    }    
    
    public void setValue(int health, int points)
    {
        this.points = points;
        this.health = health;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
