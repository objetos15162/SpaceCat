import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase contiene todos los Item que iran
 * apareciendo a lo largo del juego.
 * 
 * @author (Jessica de Jesus Ortiz Tobias) 
 */
public class Item extends Actor
{
    private int points;
    private int health;
    private int speed;
    
    /**
     * Constructor for objects of class Food.
     */
    public Item()
    {
        speed = 4;
    }
    
    public Item(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * Act - do whatever the food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX()-speed, getY());
        
        if(getX() < -50)
        {
            getWorld().removeObject(this);
        }
        turn(1);
    }    
    
    /**
     * @param health representa la vida.
     * @param point representa los puntos
     * Mete los valores de los puntos y la vida.
     */
    public void setValue(int health, int points)
    {
        this.points = points;
        this.health = health;
    }
    
    /**
     * Regresa el valor que tiene los puntos.
     * @return points Representa los puntos.
     */
    public int getPoints()
    {
        return points;
    }
    
    /**
     * Regresa el valor que tiene la vida.
     * @return health Representa la vida.
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * @param speed Representa la velocidad.
     * Mete el valor de la velocidad.
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * Regresa el valor que tiene la velocidad.
     * @return speed Representa la velocidad.
     */
     public int getSpeed()
    {
        return speed;
    }
}
