import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    GifImage myGif2 = new GifImage("Space1.gif");
    
    private SimpleTimer timer;
    private int timeLimit;
    private int timeFood;
    private int timeCount;
    private boolean spawnFood;
    public boolean spawnEnemy;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        timer = new SimpleTimer();
        timeLimit = 10;
        timeFood = 2;
        timeCount = 0;
        
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

    }
    
    public void act()
    {
        setBackground(myGif2.getCurrentImage());
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
        food food;
        int appear = Greenfoot.getRandomNumber(3);
      
        if( appear == 2)    
           {
               food = new Bad();
            }
        else 
            if( appear == 1)              
            {
                food = new Good();
            }
            else
            {
                food = new Asteroid();
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
    
    public void time()
    {
        if(timer.millisElapsed() > 1000)
        {
            timer.mark();
            timeCount++; 
            spawnFood = false;
        }
    }
 
}