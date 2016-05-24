import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * En esta clase agregan los puntos 
 * y la vida que tienen el gato.
 * Esta clase se enacrga de verificar
 * si el gato toca o no a algun Item.
 * @author (Jessica Ortiz) 
 */
public class CatGame extends Cat
{
    private CounterImage health;
    private Counter points;
   
    protected CatGame()
    {
    }
    
    /**
     * Esta clase adiere el contador de los
     * puntos y la vida al world.
     */
    protected void addedToWorld(World world)
    {
        points = new Counter("Points: ");
        getWorld().addObject(points,700,50);  
        health = new CounterImage();
        getWorld().addObject(health,400,50); 
        points.setValue(0);
        health.setValue(100);
    }
    
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        currentImageGif();
        move();
        touching();
    }
    
    /**
     * Este metodo revisa si esta tocando
     * con alguno de los Item.
     */
    public void touching()
    {
        if(isTouching(Item.class))
           {
               eat();
            }
        if(health.getValue()<=0)
        {
           getWorld().removeObject(this);
        }
    }

    /**
     * Este metodo mueve al gato dependiendo 
     * de la tecla que se precione.
     */
    public void move()
    {
        int x = getX();
        int y = getY();
        
        if(Greenfoot.isKeyDown("up") && y > getHeight()/2)
        {
            moveUp(4);
        }
        else 
            if(Greenfoot.isKeyDown("down") && y < getWorld().getHeight()-getHeight()/2)
            {
                moveDown(4);
            }
            else
            {
                rotationInit();
            }
    
        if(Greenfoot.isKeyDown("right") && x < getWorld().getWidth()/2)
        {
            moveRight(4);
        }
        else if(Greenfoot.isKeyDown("left") && x > getWidth()/2)
        {
            moveLeft(4);
        }
    }
    
    /**
     * En esta clase se verifica si lo que toca el 
     * gato le da o le quita puntos o vidas y 
     * lo va registrando en el contador.
     */
        public void eat()
    {
        Item item=(Item)getOneIntersectingObject(Item.class);
      
        points(item.getPoints());
        health(item.getHealth());
      
        if(isTouching(Bad.class) || isTouching(Asteroid.class) || isTouching(Worm.class))
        {
            Greenfoot.playSound("Ew.mp3");
        }
        else if(isTouching(Enhacer.class))
        {
           if(!getObjectsInRange(800, Enemy.class).isEmpty())
           {
               Enemy enemy = getObjectsInRange(800, Enemy.class).get(0);
               enemy.exist(false);
           }
           Greenfoot.playSound("miaw.mp3");
        }
        else if(isTouching(Good.class))   
        {
           Greenfoot.playSound("miaw.mp3");
        }
        removeTouching(Item.class);
    }
    
    /**
     * Este metodo pone el valor que tiene
     * el contador de las vidas.
     */
    public void health(int hit)
    {
        health.add(hit);
        if(health.getValue()<0)
        {
            health.setValue(0);
        }
    }
    
    /**
     * Este metodo pone el valor que tiene
     * el contador de los puntos.
     */
    public void points(int hit)
    {
        points.add(hit);
        if(points.getValue()<0)
        {
            points.setValue(0);
        }
    }
    
    /**
     * Este metodo regresa el valor que
     * tienen los puntos.
     * @return points.getValue() Representa el valor.
     */
    public int getPoints()
    {
        return points.getValue();
    }
    
    /**
     * Este metodo regresa el valor que
     * tiene la vida.
     * @return health.getValue() Representa el valor.
     */
    public int getHealth()
    {
        return health.getValue();
    }
}
