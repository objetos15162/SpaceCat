import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Jessica de Jesus Ortiz Tobias) 
 * @version (a version number or a date)
 */
public class CatWorld extends SpaceWorld
{
    private int level;
    
    private int timeLimit;
    private int timeFood;

    private boolean spawnFood;
    public boolean spawnEnemy;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CatWorld (int bgX, int bgY)
    {    
        super(bgX, bgY);   
        loadSong("song2.mp3");
        timeLimit = 10;
        timeFood = 2;
        spawnFood = false;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cat cat = new Cat();
        addObject(cat,75,297);
        playSong();
    }
    
    public void act()
    {
        scrollLeftBackground();
        time();
        
        if(timeCount%timeFood == 0 && spawnFood == false)
        {
            appearsFood();
            spawnFood = true;
        }
        appearsEnemy();
    }
    
    public void appearsFood()
    {
        food food ;
        int appear = Greenfoot.getRandomNumber(3);
      
        if( appear == 2)    
           {
               food = new Bad();
            }
        else              
            {
                food = new Good();
            }  
           
        addObject(food, getWidth(), Greenfoot.getRandomNumber(getHeight()));
    }
    
    public void appearsObstacle()
    {
        food food;
        int appear = Greenfoot.getRandomNumber(3);
      
        if( appear == 2)    
           {
               food = new Asteroid();
            }
        else            
            {
                food = new Worm();
            }
        addObject(food, getWidth(), Greenfoot.getRandomNumber(getHeight()));
    }
    
    public void appearsEnemy()
    {
        if(timeCount == 5)
        {
            if(getObjects(Enemy.class).isEmpty())
            {
                addObject(new Enemy(),getWidth(),100);
            }
            timeCount = 0;
        }
    }
}