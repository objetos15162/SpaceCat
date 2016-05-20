import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scroll here.
 * 
 * @author (Jessica de Jesús Ortiz Tobías) 
 */
public class SpaceWorld extends World
{
    private GifImage backGround;
    private GreenfootSound song;
    private boolean isKeyOnce;
    private String keyPress;
    
    protected SimpleTimer timer;
    protected int timeCount;
    protected int bgX, bgY;

    protected SpaceWorld()
    {    
        this(0,0);
    }
    
    protected SpaceWorld(int bgX, int bgY)
    {
        super(800, 600, 1, false); 
        backGround = new GifImage("Space1.gif");
        
        keyPress = null;
        isKeyOnce = false;
        timer = new SimpleTimer();
        timeCount = 0;
        this.bgX = bgX;
        this.bgY = bgY;
    }
    
    protected void scrollUpBackground()
    {
        positionBackground(bgX, bgY--);
        bgY = (bgY <= -getHeight()) ? 0 : bgY;
    }
    
    protected void scrollDownBackground()
    {
        positionBackground(bgX, bgY++);
        bgY = (bgY >= getHeight()) ? 0 : bgY;
    }
    
    protected void scrollLeftBackground()
    {
        positionBackground(bgX--, bgY);
        bgX = (bgX <= -getWidth()) ? 0 : bgX;
    }
    
    protected void scrollRigthBackground()
    {
        positionBackground(bgX++, bgY);
        bgX = (bgX >= getWidth()) ? 0 : bgX;
    }

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
    
    protected void time()
    {
        if(timer.millisElapsed() > 1000)
        {
            timer.mark();
            timeCount++;
        }
    }
    
    protected void playSong()
    {
        song.play();
    }   
    
    protected void stopSong()
    {
        song.stop();
    }
    
    protected void loadSong(String name)
    {
        song = new GreenfootSound(name);
    }
    
    protected boolean isKeyOncePress(String key)
    {
        if(Greenfoot.isKeyDown(key) && !isKeyOnce)
        {
            keyPress = key;
            isKeyOnce = true;
            return true;
        }
        else if(key != null && !Greenfoot.isKeyDown(keyPress) && isKeyOnce)
        {
            key = null;
            isKeyOnce = false;
        }
        return false;
    }
}
