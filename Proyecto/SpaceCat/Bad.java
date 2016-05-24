import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 *
 * This class contains the badFood.
 * Esta comida proboca daño.
 * @author (Jessica Ortiz) 
 */
public class Bad extends Item
{
    /**
     * Constructor for objects of class Bad.
     */
    public Bad()
    {
        super();
    }
    
    public Bad(int speed)
    {
        super(speed);
        ArrayList<String> image;
        image = new ArrayList<String>();
        image.add("brocoli.png");
        image.add("cebollin.png");
        image.add("lechuga.png");
        
        ArrayList<Integer> value;
        value = new ArrayList<Integer>();
        value.add(-1);
        value.add(-5);
        value.add(-10);
        
        int typeFood = Greenfoot.getRandomNumber(image.size());
        
        setImage(image.get(typeFood));
        
        if(typeFood<1)
        {
            setValue(value.get(typeFood), 0);
        }
        else
        {
            setValue(0, value.get(typeFood));
        }
    }
    
    
    /**
     * Act - do whatever the Bad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
}
