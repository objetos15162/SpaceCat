import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    GifImage myGif = new GifImage("NyanCat.gif");
    
    private Counter health;
    private Counter points;
    
    public Cat()
    {
       
    }
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected void addedToWorld(World world)
    {
        points = new Counter("Points: ");
        getWorld().addObject(points,634,48);  
        health = new Counter("Healt: ");
        getWorld().addObject(health,334,48); 
        health.setValue(100);
    }
    
    public void act() 
    {
        setImage(myGif.getCurrentImage());
        
        move();
        
        if(isTouching(food.class))
           {
               eat();
            }
        if(health.getValue()<=0)
        {
           getWorld().removeObject(this);
        }
    }    

    public void move()
    {
        if(Greenfoot.isKeyDown("up"))
        {
           setLocation(getX(), getY()-4);
           setRotation(-15);
        }
        else 
            if(Greenfoot.isKeyDown("down"))
            {
                setLocation(getX(), getY()+4);
                setRotation(15);
            }
            else
                setRotation(0);
    
        if(Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth()/2)
          {
              move(4);
            }
            else if(Greenfoot.isKeyDown("left"))
                {
                    move(-4);
                }
    }
    
    public void eat()
    {
        food food=(food)getOneIntersectingObject(food.class);
      
        points(food.getPoints());
        health(food.getHealth());
      
        if(isTouching(Bad.class))
        {
            Greenfoot.playSound("Ew.mp3");
        }
        else
            if(isTouching(Good.class))
            {
                if(!getObjectsInRange(800, Enemy.class).isEmpty())
                {
                     Enemy enemy = getObjectsInRange(800, Enemy.class).get(0);
                     enemy.exist=false;
                    }
                 Greenfoot.playSound("miaw.mp3");
            }  
      
            //Enemy fod=getObjectsInRange(800, Enemy.class).get(0);
        removeTouching(food.class);
    }
    
    public void health(int hit)
    {
        health.add(hit);
        if(health.getValue()<0)
        {
            health.setValue(0);
        }
    }
    
    public void points(int hit)
    {
        points.add(hit);
        if(points.getValue()<0)
        {
            points.setValue(0);
        }
    }
}