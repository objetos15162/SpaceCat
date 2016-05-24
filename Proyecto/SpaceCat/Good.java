import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Esta clase contiene comida buena.
 * Esta comida te da puntos o vida.
 * @author (Jessica Ortiz) 
 */
public class Good extends Item
{   
    /**
     * Constructor for objects of class Good.
     */
    public Good()
    {
        super();
    }
    
    public Good(int speed)
    {
        super(speed);
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
        
        int typeFood;
        
        do{
            typeFood = Greenfoot.getRandomNumber(image.size());
        }while((typeFood == 0 || typeFood == 1) && Greenfoot.getRandomNumber(20) != 1);
        
        setImage(image.get(typeFood));
        
        if(typeFood<2)
        {
            setValue(value.get(typeFood), 0);
        }
        else
        {
            setValue(0, value.get(typeFood));
        }

    }
    
    /**
     * Act - do whatever the Good wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    

}
