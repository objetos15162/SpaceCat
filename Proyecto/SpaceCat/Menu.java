import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class menu here.
 * this class contains the methods responsile for creating 
 * the main animation 
 * @author (Ortiz Tobías Jessica de Jesús) 
 * @version (a version number or a date)
 */
public class Menu extends SpaceWorld
{
    private ArrayList<Label> labels;
    private Cat cat;
    private int index;
    private int isKeyUp;
    
    
    /**
     * Constructor for objects of class menu.
     * 
     */
    public Menu()
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
        labels.add(new Label("Play",30));//9
        labels.add(new Label("Scores",30));//10
        labels.add(new Label("Help",30));//11
        labels.add(new Label("Exit",30));//12
        
        loadSong("song.mp3");
        cat = new Cat();
        
        index = 0;
        isKeyUp = 0;
    }
    
        public void act()
    {
        time();
        animation();
    }
    
    private void animation()
    {
        if(timeCount < 8)
        {
            scrollUpBackground();
            if(timeCount > 3)
            {
                if(timeCount > 4)
                playSong();
                appearTitle();
            }
        }
        else 
        {   
            scrollLeftBackground();
            if(index < 9)
            {
                if(getObjects(Cat.class).isEmpty())
                {
                    appearCat(getHeight()/4);
                }
                else if(cat.getX() < getWidth()/2)
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
                        moveLabels(true);
                        removeLabels();
                    }
                }
            }
            else
            {
                appearMenu();
            }
        }
    }
    
    private void moveLabels(boolean faster)
    {
        Iterator it = getObjects(Label.class).iterator();
        
        while(it.hasNext())
        {
            Label label = (Label)it.next();
            if(faster && (label.getX() + label.getWidth()/2 < (getWidth()*3)/4 || label.getX() - label.getWidth()/2 > getWidth()/4))
            {
                label.setLocation(label.getX()-4, label.getY());  
            }
            else
            {
                label.setLocation(label.getX()-3, label.getY()); 
            }
        }
    }
    
    private void removeLabels()
    {
        Iterator it = getObjects(Label.class).iterator();
        
        while(it.hasNext())
        {
            Label label = (Label)it.next();
            if (label.isOffScreen() && label.getX()<getWidth())
            {
                removeObject(label);
                index++;
            } 
        }
    }
    
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
    
    private void appearCat(int y)
    {
        int x = -cat.getWidth()/2;
        addObject(cat, x, y); 
    }
    
    private void appearMenu()
    {
        Label label = labels.get(0);
        
        if(getObjects(Label.class).isEmpty())
        {
            addObject(label, getWidth()+ label.getWidth()/2, getHeight()/4);                
            for(int i=0;i<4;i++ )               
            {
                Label button = labels.get(index+i);
                addObject(button, getWidth()+ label.getWidth()/2, getHeight()/2+(50*i)); 
            }
        }
        else if(label.getX() > getWidth()/2)
        {
            cat.moveTo(getWidth()/2 - labels.get(index).getWidth()/2 -50, getHeight()/2 , 3); 
            cat.rotationInit();
            moveLabels(false);
        }
        else menu();
    }
    
    private void menu()
    {
        if( index > 9 && isKeyOncePress("up"))
        {
            index--;
        }
        else if( index < 12 &&isKeyOncePress("down"))
        {
            index++;
        }
        else if(Greenfoot.isKeyDown("enter"))
        {
            switch (index)
            {
                case 9: Greenfoot.setWorld(new CatWorld(bgX, bgY));
                        stopSong();
                        break;
                case 10: 
                        break;
                case 11: 
                        break;
                case 12: 
                        break;  
            }
        }
        cat.moveTo(getWidth()/2 - labels.get(index).getWidth()/2 -50, getHeight()/2 + 50*(index-9), 1);
        
            
    }
    

    
}
