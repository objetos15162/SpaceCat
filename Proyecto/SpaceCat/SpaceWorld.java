import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;
/**
 * This class contains the movement 
 * of the background image. 
 * 
 * @author (Jessica de Jesús Ortiz Tobías) 
 */
public class SpaceWorld extends World
{
    private GifImage backGround;
    private GreenfootSound song;
    private String keyPress;
    
    private SimpleTimer timer;
    private Counter timeSeconds;
    private Counter timeDSeconds; //DeciSeconds ( Seconds/10 )
    private boolean isOneSecond;
    private boolean isOneDSecond;
    
    private int Volume;
    private int MaxVolume;
    
    private int bgX, bgY;

    /**
     * class constructor...
     */
    protected SpaceWorld()
    {    
        this(0,0);
    }
    
    protected SpaceWorld(int bgX, int bgY)
    {
        super(800, 600, 1, false); 
        backGround = new GifImage("Space1.gif");
        
        Volume = 1;
        MaxVolume = 70;
        
        keyPress = new String();
        
        timer = new SimpleTimer();
        
        timeSeconds = new Counter();
        timeDSeconds = new Counter();
        
        isOneSecond = false;
        isOneDSecond = false;
        
        this.bgX = bgX;
        this.bgY = bgY;
    }
    
    /**
     * This method moves the background Up.
     */
    protected void scrollUpBackground()
    {
        positionBackground(bgX, bgY--);
        bgY = (bgY <= -getHeight()) ? 0 : bgY;
    }
    
    /**
     * This method moves the background Down.
     */
    protected void scrollDownBackground()
    {
        positionBackground(bgX, bgY++);
        bgY = (bgY >= getHeight()) ? 0 : bgY;
    }
    
    /**
     * This method moves the background to the Left.
     */
    protected void scrollLeftBackground()
    {
        positionBackground(bgX--, bgY);
        bgX = (bgX <= -getWidth()) ? 0 : bgX;
    }
    
    /**
     * This method moves the background to the Rigth.
     */
    protected void scrollRigthBackground()
    {
        positionBackground(bgX++, bgY);
        bgX = (bgX >= getWidth()) ? 0 : bgX;
    }

    /**
     * THis method contains the position of the background.
     * @param x and y to position.
     */
    protected void positionBackground(int x, int y)
    {
        setBackground(backGround.getCurrentImage());
        GreenfootImage bg = new GreenfootImage(getBackground());
      
        int dy = (y<0)?getHeight():-getHeight();
        int dx = (x<0)?getWidth():-getWidth();
    
        getBackground().drawImage(bg, x, y);
        getBackground().drawImage(bg, x, y + dy);
        getBackground().drawImage(bg, x + dx, y);
        getBackground().drawImage(bg, x + dx, y + dy);
    }
    
    /**
     * This method handles time.
     * Initializes time variables.
     */
    protected void time()
    {
        if(timer.millisElapsed() > 100)
        {
            timer.mark();
            timeDSeconds.add(1);
            isOneDSecond = true;
            if(timeDSeconds.getValue() % 10 == 0)
            {
                isOneSecond = true;
                timeSeconds.add(1);
                timeDSeconds.setValue(0);
            }
        }
    }
    
    /**
     * This method reproduces the song.
     * It puts the song a volume
     * with @param volume.
     */
    protected void playSong(int volume)
    {
        song.play();
        song.setVolume(50);
    }   
    
    /**
     * This method stops the song.
     */
    protected void stopSong()
    {
        song.stop();
    }
    
    /**
     * This method returns the song.
     * @return the variable song.
     */
    protected GreenfootSound getSong()
    {
        return song;
    }
    
    /**
     * This method set the song.
     * @Param song of type GreenfootSound.
     */
    protected void setSong(GreenfootSound song)
    {
        this.song = song;
    }
    
    /**
     * This method load the Song.
     * with @param name is for the name of the song.
     */
    protected void loadSong(String name)
    {
        song = new GreenfootSound(name);
    }
    
    /**
     * @param key is the Strinf of the key.
     * This method checks if a key is pressed.
     * @return boolean if it is true or false.
     */
    protected boolean isKeyOncePress(String key)
    {
        if(keyPress.isEmpty() && Greenfoot.isKeyDown(key))
        {
            keyPress = key;
            return true;
        }
        else if(!keyPress.isEmpty() && !Greenfoot.isKeyDown(keyPress))
        {
            keyPress = "";
        }
        return false;
    }
    
    /**
     * This method returns the Y coordinate in the background.
     * @return bgY 
     */
    protected int getBgY()
    {
        return bgY;
    }
    
    /**
     * This method returns the X coordinate in the background.
     * @return bgX 
     */
    protected int getBgX()
    {
        return bgX;
    }
    
    /**
     * This method calls the point coordinates.
     * @Param bgX coordinate x.
     * @Param bgY coordinate y.
     */
    protected void setBg(int bgX, int bgY)
    {
        this.bgY = bgY;
        this.bgX = bgX;
    }  
    
    /**
     * @faster speed of movement.
     * @moveX movement x.
     * This method moves the Labels.
     */
    protected void moveLabels(boolean faster, int moveX)
    {
        Iterator it = getObjects(Label.class).iterator();
        
        while(it.hasNext())
        {
            Label label = (Label)it.next();
            if(faster && (label.getX() + label.getWidth()/2 < (getWidth()*3)/4 || label.getX() - label.getWidth()/2 > getWidth()/4))
            {
                label.setLocation(label.getX() + (moveX + 1), label.getY());  
            }
            else
            {
                label.setLocation(label.getX() + moveX, label.getY()); 
            }
        }
    }
    
    /**
     * This method removes Labels that are screen.
     * @return numberObjectRemoves number of objects removed.
     */
    protected int removeLabels()
    {
        Iterator it = getObjects(Label.class).iterator();
        int numberObjectRemoved = 0;
        
        while(it.hasNext())
        {
            Label label = (Label)it.next();
            if (label.isOffScreen() && label.getX()<getWidth())
            {
                removeObject(label);
                numberObjectRemoved++;
            } 
        }
        return numberObjectRemoved;
    } 

    /**
     * This method return a variable of type Counter.
     * @return timeSecond variable del tipo Counter.
     */
    protected Counter getTimeSeconds()
    {
        return timeSeconds;
    }
    
    /**
     * Este metodo regresa una variable de tipo Counter.
     * @return timeDSecond regresa deciSegundos.
     */
    protected Counter getTimeDSeconds() //DeciSeconds ( Seconds/10 )
    {
        return timeDSeconds;
    }
    
    /**
     * Este metodo regresa un falso o verdadero
     * si a pasado o no un segundo.
     * @return boolean 
     */
    protected boolean isOneSecond()
    {
        if(isOneSecond)
        {
            isOneSecond = false;
            return true;
        }
        return false;
    }
    
    /**
     * Este metodo regresa un falso o verdadero
     * si a pasado o no un deciSegundo.
     * @return boolean 
     */
    protected boolean isOneDSecond()
    {
        if(isOneDSecond)
        {
            isOneDSecond = false;
            return true;
        }
        return false;
    }
}
