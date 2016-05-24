import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este mundo es el entorno de juego.
 * 
 * @author (Jessica de Jesus Ortiz Tobias) 
 */
public class CatWorld extends SpaceWorld
{
    private CatGame cat;
    private Record record;
    private int level;
 
    private int timeObstacles;
    private int typeOfObstacle;
    private boolean spawnObstacles;
    
    private int timeEnemy;
    private int speedEnemy;
    private int probabilityToShoot;
    
    private int timeFood;
    private int probabilityOfFood;
    private int speedFood;
    private boolean spawnFood;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CatWorld (int bgX, int bgY)
    {    
        super(bgX, bgY);   
       
        loadSong("song2.mp3");
        
        record = new Record();
        
        level = 0;
        
        probabilityOfFood = 30;
        
        speedFood = 4;
        
        timeEnemy = 0;
        timeFood = 0;
        timeObstacles=0;
        
        speedEnemy = 4;
        probabilityToShoot = 1;
        
        typeOfObstacle = 0;
        
        spawnFood = false;
        spawnObstacles = false;
        
        prepare();      
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        cat = new CatGame();
        addObject(cat,75,300);
        
        playSong(40);
        
        getTimeSeconds().setPrefix("Time: ");
        addObject(getTimeSeconds(), 150, 50);
    }
    
    public void act()
    {
        scrollLeftBackground();
        time();
        timeOfSpawns();
        timeToAppear();
        sequence();
        appearEnhacer();
        if(getObjects(Cat.class).isEmpty())
        {
            if(getObjects(Label.class).isEmpty())
            {
                addObject(new Label("Press Enter", 40), getWidth()/2, getHeight()/2-50);
                addObject(new Label("To Exit", 40), getWidth()/2, getHeight()/2+50);
            }
            if(isKeyOncePress("enter"))
            {
                record.showImage();
                record.save(getTimeSeconds().getValue(), cat.getPoints());
                stopSong();
                Greenfoot.setWorld(new Menu());
                
            }
        }
    }
    /**
     * Este metodo se encarga de la secuencia
     * de como iran apareciendo los Item.
     */
    public void sequence()
    {
        if(timeEnemy == 2)
        {
            spawnFood = true;
            timeFood=0;
        }
        
        if(timeEnemy == 20)
        {
            spawnObstacles = true;
            timeObstacles=0;
            int random = Greenfoot.getRandomNumber(3);
            if( random == 0)
            {
                typeOfObstacle = 1;
            }
            else if( random == 1)
            {
                typeOfObstacle = 0;
            }
            else 
            {
                typeOfObstacle = 3;
            }
        }
    }
    
    /**
     * Este mtodo incrementa los contadores 
     * de los Item y del Enemy.
     */
    public void timeOfSpawns()
    {
        if(isOneSecond())
        {
            timeObstacles++;
            timeEnemy++;
        }
        
        if(isOneDSecond())
        {
            timeFood++;
        }
    }
    
    /**
     * Este metodo se encarga del tiempo en 
     * que apareceran los Item y el Enemy.
     */
    public void timeToAppear()
    {
        if(timeFood == 4 && spawnFood)
        {
             appearsFood();
             timeFood = 0;
        }

        if(timeObstacles == 3 && spawnObstacles)
        {
            appearsObstacle(typeOfObstacle);
            timeObstacles = 0;
        }
        
        if(timeEnemy == 40)
        {
            appearsEnemy();
        }
    }
    
    /**
     * Este metodo se encarga de aparecer la comida,
     * y los adiere.
     */
    public void appearsFood()
    {
        Item food ;
        int appear = Greenfoot.getRandomNumber(100);
      
        if( appear < probabilityOfFood )    
           {
               food = new Bad(speedFood);
            }
        else              
            {
                food = new Good(speedFood);
            }  
           
        addObject(food, getWidth() +20, Greenfoot.getRandomNumber(getHeight()));
        
    }
    
    /**
     * Este metodo se encarga de aparecer
     * la fruta que sirve como Bonus en el juego.
     */
    public void appearEnhacer()
    {
        if(!getObjects(Enemy.class).isEmpty() && Greenfoot.getRandomNumber(40) == 1 && getTimeDSeconds().getValue() == 2 && getObjects(Enhacer.class).isEmpty())
        {
           addObject(new Enhacer(4), getWidth() +20, Greenfoot.getRandomNumber(getHeight()));
        }
    }
    
    /**
     * @param obstacle variable para identificar 
     * los Asteroides y los Worms.
     * Este metodo se encarga de aparecer los 
     * obstaculos.
     */
    public void appearsObstacle(int obstacle)
    {
        Item obstacles;
        int appear = 0;
        
        if(obstacle == 3)
        appear = Greenfoot.getRandomNumber(3);
      
        if( obstacle == 0 || appear == 2 || appear == 3)    
           {
              obstacles = new Asteroid(speedEnemy);
               addObject(obstacles, getWidth() +50, Greenfoot.getRandomNumber(getHeight()));
           }
           
        if ( obstacle == 1 || appear == 1 || appear == 3)           
           {
               obstacles = new Worm(speedEnemy);
               addObject(obstacles, getWidth() +50, Greenfoot.getRandomNumber(getHeight()));
           } 
        
    }
    
    /**
     * Este metodo se encarga de aparecer
     * al Enemy.
     */
    public void appearsEnemy()
    {
            if(getObjects(Enemy.class).isEmpty())
            {
                addObject(new Enemy(speedEnemy, probabilityToShoot),getWidth(),100);
            }
    }
    
    /**
     * @param enemy
     * Este metodo checa si el enemigo esta
     * muerto.
     * Aumenta la dificultad del juego cada
     * vez que muere.
     * 
     */
    public void enemyIsDead(Actor enemy)
    {
        timeEnemy = 0;
        removeObject(enemy);
        level++;
        if(level % 2 == 0)
        {
            probabilityOfFood++;
        }
        if(level % 20 == 0)
        {
            speedFood++;
            speedEnemy++;
        }
        if(level % 10 == 0)
        {
            speedFood++;
            probabilityToShoot++;
        }
    }
    
}