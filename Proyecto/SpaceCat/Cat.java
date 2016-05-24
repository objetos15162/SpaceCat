import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Esta clase contiene todo lo relacionado 
 * con el gato.
 * Movimiento, velocidad, tamaño, etc.
 * @author (Jessica Ortiz) 
 */
public class Cat extends Actor
{
    private GifImage myGif = new GifImage("NyanCat.gif");
    
    public Cat()
    {
        setImage(myGif.getCurrentImage());
    }
    
    public void act() 
    {
        setImage(myGif.getCurrentImage());
    }  
    
    /**
     * Este metodo hace el movimiento del gato
     * hacia arriba.
     * @param speed Representa la velocidad con 
     * la que hace el movimiento.
     */
    public void moveUp(int speed)
    {
        setLocation(getX(), getY()-speed);
        setRotation(-15);
    }
    
    /**
     * Este metodo hace el movimiento del gato
     * hacia abajo.
     * @param speed Representa la velocidad con 
     * la que hace el movimiento.
     */
    public void moveDown(int speed)
    {
        setLocation(getX(), getY()+speed);
        setRotation(15);
    }
    
    /**
     * Este metodo hace el movimiento del gato
     * hacia la derecha.
     * @param speed Representa la velocidad con 
     * la que hace el movimiento.
     */
    public void moveRight(int speed)
    {
        move(speed);
    }
    
    /**
     * Este metodo hace el movimiento del gato
     * hacia la izquierda.
     * @param speed Representa la velocidad con 
     * la que hace el movimiento.
     */
    public void moveLeft(int speed)
    {
        move(-speed);
    }
    
    /**
     * @param x representa la posicion en direccion a X.
     * @param y representa la posicion en direccion a y.
     * @param speed representa la velocidad.
     * Este metodo se encarga de mover al gato en diagonal.
     */
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
    
    /**
     * Este metodo mete el valor de la posicion.
     */
    public void rotationInit()
    {
        setRotation(0);
    }
    
    /**
     * Este metodo regresa el tamaño de la imagen a lo ancho.
     * @return getImaage().getWidth() representa el tamaño.
     */
    public int getWidth()
    {
        return getImage().getWidth();
    }
    
    /**
     * Este metodo regresa el tamaño de la altura de la imagen.
     * @return getImaage().getHeight() representa el tamaño.
     */
    public int getHeight()
    {
        return getImage().getHeight();
    }
    
    /**
     * Este metodo verifica si el gato esta mirando
     * hacie el frente.
     * Regresa un boolean.
     * @param boolean representa un false o true.
     */
    public boolean isLookStraight()
    {
        if(getRotation()!=0)
        {
            return false;
        }
        return true;
    }
    
    /**
     * Regresa un booleando si esta o no mirando 
     * el gato hacia arriba.
     * @param boolen false o true.
     */
    public boolean isLookUp()
    {
        if(getRotation() == 360-15)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Regresa un booleando si esta o no mirando 
     * el gato hacia abajo.
     * @param boolen false o true.
     */
    public boolean isLookDown()
    {
        if(getRotation() == 15)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Regresa un booleando si se encuentra un
     * Label frente al gato.
     * @param boolen false o true.
     */
    public boolean isLabelInFront(int x, Label label)
    {
        Actor actor = getOneObjectAtOffset(x, 0, Label.class);
        if( actor != null && actor.equals(label))
        {
            return true;
        }
        return false;
    }
    
    public void currentImageGif()
    {
        setImage(myGif.getCurrentImage());
    }
}