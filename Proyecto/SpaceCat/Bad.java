import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bad extends food
{
    public Bad()
    {
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
            setValue(value.get(typeFood), 0);
        else
            setValue(0, value.get(typeFood));
            
        setSpeed(4);
    }
    
    /**
     * Act - do whatever the Bad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }    
}
