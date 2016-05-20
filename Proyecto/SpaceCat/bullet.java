import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Actor
{
    private int position;
    private CatGame target;
    
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public bullet()
    {
    }
    
    protected void addedToWorld(World world)
    {
     target = getObjectsInRange(800, CatGame.class).get(0);
      
      double x = target.getX();
      double y = target.getY();
      
      double x2 = getX();
      double y2 = getY();
      
      position = (int)( y2 - ( x2 * ( ( y2 - y ) / ( x2 - x ) ) ) ); 
    }
    
    public void act() 
    {
       move();
        
       if(isAtEdge() || hit())
           getWorld().removeObject(this);  
    }    
    
    public void move()
    {
       int rotation = getRotation();
       
       turnTowards(0,position);
       move(4);
       setRotation(rotation + 6);
       
    }
    
    public boolean hit()
    {
        if(isTouching(CatGame.class))
        {
            target.health(-20);
            return true;
        }
        return false;
    }
}
