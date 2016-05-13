import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class menus extends World
{
    GifImage myGif2 = new GifImage("Space1.gif");
    private SimpleTimer timer;
    private int timeCount;
    private int bgX, bgY;
    private int index;
    private ArrayList<Label> labels;
   
    /**
     * Constructor for objects of class menu.
     * 
     */
    public menus()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, false); 
        labels = new ArrayList<Label>();
        labels.add(new Label("SpaceCat",100));
        labels.add(new Label("Universidad Autonoma de S.L.P",50));
        labels.add(new Label("Faculcultad de Ingenieria",50));
        labels.add(new Label("Programacion Orientada a Objetos",50));
        labels.add(new Label("Profesor: Eloy",100));
        labels.add(new Label("Jessica de Jesus Ortiz Tobias",50));
        timer = new SimpleTimer();
        timeCount = 0;
        bgX = 0;
        bgY = 0;
        index = 0;
        
    }
    
        public void act()
    {
        time();
        animation();

    }
    
    private void animation()
    {
        Label label = labels.get(index);
       
        if(timeCount < 10)
        {
            scrollUpBackground();
            if(timeCount > 5)
            {
                if(getObjects(Label.class).isEmpty())
                {
                    addObject(label, getWidth()/2, getHeight());  
                }
                else if(label.getY() > getHeight()/2)
                {
                    label.setLocation(label.getX(), label.getY()-2);
            
                }
            }
        }
        else
        {
            scrollLeftBackground();
            if(getObjects(Label.class).isEmpty())
            {
                 addObject(label, getWidth()+500, getHeight()/2);  
            }
            else if(label.getX() > (getWidth()*3)/4 || label.getX() < getWidth()/4)
            {
                label.setLocation(label.getX()-3, label.getY());  
            }
            else
            {
                label.setLocation(label.getX()-2, label.getY());  
            }
            if(label.getX()<-200)
            {
                    removeObject(label);
                    index++;
            }
        }
    }
    
    
    
    
    private void scrollUpBackground()
    {
        bgY = (bgY <= -getHeight())?0:bgY;
        positionBackground(bgX, bgY--);
    }
    
    private void scrollDownBackground()
    {
        bgY = (bgY >= getHeight())?0:bgY;
        positionBackground(bgX, bgY++);
    }
    
    private void scrollLeftBackground()
    {
        bgX = (bgX <= -getWidth())?0:bgX;
        positionBackground(bgX--, bgY);
    }
    
    private void scrollRigthBackground()
    {
        bgX = (bgX >= getWidth())?0:bgX;
        positionBackground(bgX++, bgY);
    }

    private void positionBackground(int x, int y)
    {
        setBackground( myGif2.getCurrentImage());
        GreenfootImage bg = new GreenfootImage(getBackground());
        int h, v;
    
        v = (y<0)?getHeight():-getHeight();
        h = (x<0)?getWidth():-getWidth();
    
        getBackground().drawImage(bg, x, y);
        getBackground().drawImage(bg, x, y + v);
        getBackground().drawImage(bg, x + h, y);
        getBackground().drawImage(bg, x + h, y + v);
    }
        
    public void time()
    {
        if(timer.millisElapsed() > 1000)
        {
            timer.mark();
            timeCount++; 
        }
    }
}