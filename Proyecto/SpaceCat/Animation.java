import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Esta clase se encarga de la animacion en
 * la presentacion.
 * 
 * @author (Jessica Ortiz) 
 */
public class Animation extends SpaceWorld
{
    private ArrayList<Label> labels;
    private Cat cat;
    
    private int index;
    private boolean endAnimation;
    
    /**
     * Constructor for objects of class Animation.
     * 
     */
    public Animation()
    {
        labels = new ArrayList<Label>();
        labels.add(new Label("SpaceCat",80));
        labels.add(new Label("Faculty of Engineering",40));
        labels.add(new Label("U.A.S.L.P",40));
        labels.add(new Label("Object-Oriented Programming",40));
        labels.add(new Label("Subject",40));
        labels.add(new Label("Froylán Eloy Hernández Castro",40));
        labels.add(new Label("Professor",40));
        labels.add(new Label("Jessica de Jesus Ortiz Tobias",40));
        labels.add(new Label("Developer",40));
        
        cat = new Cat();
        index = 0;
        loadSong("song.mp3");
        endAnimation = false;
        prepare();
    }
    
    public void prepare()
    {
        addObject(cat, -cat.getWidth()/2, getHeight()/4); 
    }
    
    public void act()
    {
        time();
        animation();
        scapeAnimation();
    }
    
    /**
     * Este metodo hace toda la animacion.
     */
    public void animation()
    {
        if(getTimeSeconds().getValue() < 6)
        {
            scrollUpBackground();
            
            if(getTimeSeconds().getValue() > 2)
            {
                playSong(50);
                appearTitle();
            }
        } 
        else if( index < 9)
        {
            scrollLeftBackground();
           
            if(cat.getX() < getWidth()/2)
            {
                cat.moveRight(2);
            }
            else if(getObjects(Label.class).isEmpty())
            {
                moveCat();
            }
            if(cat.isLookStraight())
            {
                if(getObjects(Label.class).isEmpty())
                {
                    appearLabels();
                }
                else 
                {
                    moveLabels(true, -3);
                    index += removeLabels();
                }
            }
        }
        else
        {
            endAnimation = true;
        }
    }
    
    /**
     * Este metodo solo se encarga de aparecer
     * el titulo del juego.
     */
    private void appearTitle()
    {
        Label label = labels.get(index);
        if(getObjects(Label.class).isEmpty())
        {
            addObject(label, getWidth()/2, getHeight()+ label.getHeight()/2);  
        }
        else if(label.getY() > getHeight()/2)
        {
            label.setLocation(label.getX(), label.getY()-2);
        }
    }
    
    /**
     * Este metodo se encarga de hacer el 
     * movimiento del gato a lo largo de 
     * la presentacion.
     */
    private void moveCat()
    {
        if(cat.isLookDown())
        {
            cat.moveTo(cat.getX(), (getHeight()*3)/4, 3);
        }
        else if (cat.isLookUp())
        {
            cat.moveTo(cat.getX(), getHeight()/4, 3);
        }    
        else if(cat.isLookStraight())
        {
            if(cat.getY() < getHeight()/2 )
            {
                cat.moveDown(3);
            }
            else
            {
                cat.moveUp(3);
            }
        }
    }
    
    /**
     * Este metodo se encarga de aparecer
     * los labels a lo largo de la presentacion.
     */
    private void appearLabels()
    {
        int y = getHeight()/2 + 50;
        int x = getWidth()+ labels.get(index).getWidth()/2;

        for(int i = index ; i < index + 2; i++)
        {
            Label label = labels.get(i);
            addObject(label, x , y);
            y -= 100;
        }
    }
    
    /**
     * Este metodo es una alternativa 
     * para iniciar rappido, brincandose
     * la presentación y llendo directo
     * al menu.
     */
    private void scapeAnimation()
    {
        if(Greenfoot.isKeyDown("enter") || endAnimation)
        {
            endAnimation = true;
            if(getObjects(Label.class).isEmpty())
                Greenfoot.setWorld(new Menu(getBgX(), getBgY(), cat.getX(), cat.getY(),getSong()));
        }
    }
}
