import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.PrintStream;
import greenfoot.GreenfootImage;
 
/**
 * Custom Font.
 * 
 * @author Lollygag
 * @version 2014
 */
public class CustomFont  
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static GreenfootImage drawString(String str, Color color, String font, float size)
    {
        // put your code here 
        int strLength = (str.length() + 2) * (int)size;
        GreenfootImage img = new GreenfootImage(strLength-650, (int)size+20);
        img.setColor(color);
        img.setFont(getFont(font, size));
        img.drawString(str, 0, (int)size);
        return img;
    }
     
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    private static java.awt.Font getFont(String name, float size)
    {
        // put your code here
        java.awt.Font font = null;
        try
        {
            java.awt.Font tmpFont = java.awt.Font.createFont(0, CustomFont.class.getResourceAsStream("/fonts/" + name + ".TTF"));
            font = tmpFont.deriveFont(size);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
        catch (FontFormatException e)
        {
            System.err.println(e.getMessage());
        }
        return font;
    }
}




