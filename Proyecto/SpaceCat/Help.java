import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Help.
 * It contains image Help.
 * @author (Jessica Ortiz) 
 */
public class Help extends Actor
{
    public Help()
    {
    }
    
    /**
     * Act - do whatever the Help wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
    } 
    
    /**
     * @return the size in X image.
     */
    public int getWidth()
    {
        return getImage().getWidth();
    }
    
    /**
     * @return boolean 
     * This method indicates if the image is out.
     */
    public boolean isOutOnLeft()
    {
        if(getX() + getWidth()/2 < 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * This method remove the image.
     */
    public void remove()
    {
        getWorld().removeObject(this);
    }
}
