import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Enemy here.
 * 
 * This is the class enemy.
 * This contains the methods for moving, actor appears
 * and desappear.
 * Also it contains the turn of actor.
 * In this class has the method to shoot.
 * 
 * @author (Jessica Ortiz) 
 */
public class Enemy extends Actor
{
    private GifImage myGif = new GifImage("Pusheen.gif");
    private GifImage myGif2 = new GifImage("PusheenShoot.gif");
    
    private boolean exist;
    private int positionToAtack;
    private int speed;
    private int probabilityToShoot;
    private boolean existe;
    
    /**
     * Class constructor...
     */
    public Enemy()
    {
        this(4,4);
    }
    
    public Enemy(int speed, int probabilityToShoot)
    {
        positionToAtack = 660;
        exist = true;
        this.speed = speed;
        this.probabilityToShoot = probabilityToShoot;
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
    
    /**
     * This method appear the Enemy.
     * This method performs the movement the cat 
     * made to appear.
     */
    public void appear()
    {
        setRotation(-45);
        move(-speed); 
    }
    
    /**
     * This method desappear the Enemy.
     * This method performs the movement the cat 
     * made to desappear.
     */
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
            CatWorld world= getWorldOfType(CatWorld.class);
            world.enemyIsDead(this);
        }
    }
    
    /**
     * This method move the Enemy while in CatWorld.
     * Muves Up and Down.
     */
    public void move()
    {
        if(getRotation()==15)
        {
            setLocation(getX(), getY()-speed);
        }
        else 
        {
            setLocation(getX(), getY()+speed);
        }
    }
    
    /**
     * This class perform a slight turn 
     * the actor does when moved Up and Down.
     */
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
    
    /**
     * This class performs the shoot.
     */
    public void shoot()
    {
       if(!getObjectsInRange(800, Cat.class).isEmpty() && Greenfoot.getRandomNumber(100) < probabilityToShoot)
            {
                getWorld().addObject(new Bullet(speed), getX(), getY());
            }  
    }
    
    /**
     * Este metodo regresa un bolean si 
     * existe o no el enemigo.
     * @return boolean false o true.
     */
    public boolean exist()
    {
        return exist;
    }
    
    /**
     * Este metodo mete el valor que tiene
     * el booleano.
     * @param exist booleano que representa
     * un true o false.
     */
    public void exist(boolean exist)
    {
        this.exist = exist;
    }
    
    
}
