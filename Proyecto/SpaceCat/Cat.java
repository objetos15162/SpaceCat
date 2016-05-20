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
    
    public Cat()
    {
    }
    
    public void act() 
    {
        setImage(myGif.getCurrentImage());
    }  
    
    public void moveUp(int speed)
    {
        setLocation(getX(), getY()-speed);
        setRotation(-15);
    }
    
    public void moveDown(int speed)
    {
        setLocation(getX(), getY()+speed);
        setRotation(15);
    }
    
    public void moveRight(int speed)
    {
        move(speed);
    }
    
    public void moveLeft(int speed)
    {
        move(-speed);
    }
    
    public void moveTo(int x, int y, int speed)
    {
       if(getX() == x && getY() == y)
       {
           setRotation(0);
           return;
       }
       
       turnTowards(x, y);
       move(speed);
       
       if(getY() > y)
       {
           setRotation(-15);
       }
       else if(getY() < y)
       {
           setRotation(15);
       }
       else
       {
           setRotation(0);
       }    
    }
    
    public void rotationInit()
    {
        setRotation(0);
    }
    
    public int getWidth()
    {
        return getImage().getWidth();
    }
    
    public int getHeight()
    {
        return getImage().getHeight();
    }
    
    public boolean isLookStraight()
    {
        if(getRotation()!=0)
        {
            return false;
        }
        return true;
    }
    
    public boolean isLookUp()
    {
        if(getRotation() == 360-15)
        {
            return true;
        }
        return false;
    }
    
    public boolean isLookDown()
    {
        if(getRotation() == 15)
        {
            return true;
        }
        return false;
    }
    
    public Actor getObjectInFront(int x, java.lang.Class<?> cls)
    {
        if(x > getX())
        {
            return getOneObjectAtOffset(x - getX(), 0, cls);
        }
        return null;
    }
    

}