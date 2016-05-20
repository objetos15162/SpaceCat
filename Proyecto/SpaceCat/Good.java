import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Good here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Good extends food
{   
    public Good()
    {
        ArrayList<String> image;
        image = new ArrayList<String>();
        image.add("fresa.png");
        image.add("dona.png");
        image.add("soda.png");
        image.add("paleta.png");
        
        ArrayList<Integer> value;
        value = new ArrayList<Integer>();
        value.add(1);
        value.add(1);
        value.add(5);
        value.add(10);
        
        int typeFood = Greenfoot.getRandomNumber(image.size());
        
        setImage(image.get(typeFood));
        
        if(typeFood<2)
        {
            setValue(value.get(typeFood), 0);
        }
        else
        {
            setValue(0, value.get(typeFood));
        }
            
        setSpeed(4);
    }
    
    /**
     * Act - do whatever the Good wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }    
    

}
