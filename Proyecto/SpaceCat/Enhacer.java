import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta fruta es un bonus para el jugador.
 * @author (Jessica Ortiz) 
 */
public class Enhacer extends Item
{
    /**
     * Constructor for objects of class Enhacer.
     */
    public Enhacer()
    {
        super();
        setValue(20, 100);
    } 
    
    public Enhacer(int speed)
    {
        super(speed);
        setValue(20, 100);
    }
    
    /**
     * Act - do whatever the Enhacer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
