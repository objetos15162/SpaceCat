import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private int value;
    private int target;
    private Color fontColor;
    private String prefix;
    
    
    public Counter()
    {
        this(new String());

    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        value = 0;
        target = 0;
        this.prefix = prefix;
        fontColor = new Color(255,255,255);
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add(int score)
    {
        target += score;
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }

    /**
     * Set a new counter value.  This will not animate the counter.
     */
    public void setValue(int newValue)
    {
        target = newValue;
        value = newValue;
        updateImage();
    }
    
    /**
     * Sets a text prefix that should be displayed before
     * the counter value (e.g. "Score: "). 
     */
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
        updateImage();
    }
    
    public void setFontColor(Color fontColor)
    {
        this.fontColor = fontColor;
        updateImage();
    }

    /**
     * Update the image on screen to show the current value.
     */
    protected void updateImage()
    {
        GreenfootImage text = CustomFont.drawString(prefix + String.format("%05d", value), fontColor, "8-bit",15);
        
            setImage(text);
    }
}
