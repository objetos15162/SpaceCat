import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este metodo de Bullet representa a la
 * bala que lanza el enemigo.
 * @author (Jessica Ortiz) 
 */
public class Bullet extends Actor
{
    private int position;
    private int speed;
    private CatGame target;
    
    /**
     * clas constructor...
     */
    public Bullet()
    {
        this(4);
    }
    
    public Bullet(int speed)
    {
        this.speed = speed;
    }
    
    /**
     * Este metodo adiere la Bullet al mundo.
     * @param world Representa al mundo.
     */
    protected void addedToWorld(World world)
    {
        target = getObjectsInRange(800, CatGame.class).get(0);
      
        double x = target.getX();
        double y = target.getY();
      
        double x2 = getX();
        double y2 = getY();
      
        position = (int)( y2 - ( x2 * ( ( y2 - y ) / ( x2 - x ) ) ) ); //formula de la recta y pendiente
    }
    
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       move();
        
       if(isAtEdge() || hit())
       {   
           getWorld().removeObject(this); 
       }
    }    
    
    /**
     * Este metodo se encarga del movimiento de la Bullet.
     */
    public void move()
    {
       int rotation = getRotation();
       
       turnTowards(0,position);
       move(speed);
       setRotation(rotation + 6);
    }
    
    /**
     * Este metodo se encarga del dañp que causa la Bullet
     * al jugador.
     * Regresa un boolean.
     * @param boolean false o true.
     */
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
