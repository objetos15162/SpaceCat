import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    GifImage myGif = new GifImage("Pusheen.gif");
    GifImage myGif2 = new GifImage("PusheenShoot.gif");
    
    public boolean exist;
    private int positionToAtack;
    
    public Enemy()
    {
        positionToAtack = 660;
        exist = true;
    }
    
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 

    public void act() 
    {
       setImage(myGif.getCurrentImage());
       
       if(getX() > positionToAtack)
       {
           appear();
        }
       else
       {
           move();
           if(exist)
           {
               shoot();
               turn();
           }
           else
           {
               disappear();
            }
       }
    }   
    
    public void appear()
    {
        setRotation(-45);
        move(-4); 
    }
    
    public void disappear()
    {
        if(getY() < getWorld().getHeight()/2)
        {
            setRotation(15);
        }
        else 
        {
            setRotation(-15);
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public void move()
    {
        if(getRotation()==15)
        {
            setLocation(getX(), getY()-2);
        }
        else 
        {
            setLocation(getX(), getY()+2);
        }
    }
    
    public void turn()
    {
        int timeToMove = Greenfoot.getRandomNumber(300);
        
        if(timeToMove < 3 || getY() > getWorld().getHeight()-10)
        {
            setRotation(15);
        }
            else if(timeToMove > 297 || getY() < 10)
                 {
                     setRotation(-15);
                    }
    }
    
    public void shoot()
    {
       if(!getObjectsInRange(800, Cat.class).isEmpty() && Greenfoot.getRandomNumber(100) < 3)
            {
                getWorld().addObject(new bullet(), getX(), getY());
            }  
    }
    
    
    

    
    
    
    
}
