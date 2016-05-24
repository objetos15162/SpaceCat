import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Write a description of class menu here.
 * this class contains the methods responsile for creating 
 * the main animation 
 * @author (Ortiz Tobías Jessica de Jesús) 
 */
public class Menu extends SpaceWorld
{
    private ArrayList<Label> labels;
    private Cat cat;
    private Help help;
    private Record record;
    private int index;
    private int select;
    private boolean oncePressed;
    private boolean twicePressed;
    
    /**
     * Constructor for objects of class menu.
     * 
     */
    public Menu()
    {
        this(0,0,-30,300);
        loadSong("song.mp3");
        playSong(50);
    }
    
    public Menu(int bgX, int bgY, int catX, int catY, GreenfootSound song)
    {    
        this(bgX, bgY, catX, catY);
        setSong(song); 
        if(!song.isPlaying())
        {
            playSong(50);
        }
    }
    
    private Menu(int bgX, int bgY, int catX, int catY)
    {
        labels = new ArrayList();
        labels.add(new Label("SpaceCat",80));
        labels.add(new Label("Play",30));
        labels.add(new Label("Scores",30));
        labels.add(new Label("Help",30));
        labels.add(new Label("Exit",30));
        labels.add(new Label("[Menu]",20));
        
        cat = new Cat();
        help = new Help();
        record = new Record();
        
        index = 1;
        select = 1;
        oncePressed = false;
        twicePressed = false;
        
        setBg(bgX, bgY);
        addObject(cat, catX, catY);
    }
    
    
    public void act()
    {
        time();
        scrollLeftBackground();
        
        if(!oncePressed)
        {
            appearMenu();
        }
        else 
        {
            if(cat.isLabelInFront(labels.get(5).getWidth()/2,labels.get(5)))
            {
                enterPress();
            }
            switch (select)
            {
                case 1: play();
                        break;
                case 2: record();
                        break;
                case 3: help();
                        break;
                case 4: exit();
                        break;
            }
        }
 
    }
    
    /**
     * Este metodo se encarga de hacer el 
     * llamado al juego.
     */
    private void play()
    {
        disappearMenu();
        cat.moveTo(75, getHeight()/2, 1);
        if(getObjects(Label.class).isEmpty())
        {
            stopSong();
            Greenfoot.setWorld(new CatWorld(getBgX(), getBgY()));
        }
    }
    
    /**
     * Este metodo es para salir del juego.
     */
    private void exit()
    {
        disappearMenu();
        cat.moveTo(getWidth()/2, getHeight()/2, 1);
        if(getObjects(Label.class).isEmpty())
        {
            stopSong();
            Greenfoot.stop();
        }
    }
    
    /**
     * Est metodo es donde se manda
     * llamar a los records para que
     * aparesca al seleccionarlos en 
     * el menu.
     */
    private void record()
    {
        if(!twicePressed)
        {       
            appearRecord();
            disappearMenu();
        }
        else
        {
            disappearRecord();
            appearMenu();
        }
    }
    
    /**
     * Este metodo se encarga de aderir la 
     * imegen de los records.
     * Aparece los records.
     * Posiciona al gato en el boton
     * para volver al menu.
     */
    private void appearRecord()
    {
        if(getObjects(Record.class).isEmpty())   
        {  
            record.showImage();
            addObject(record,getWidth() + record.getWidth()/2,300);
            addObject(labels.get(5), getWidth() + record.getWidth()/2,550);
        }
        else if(record.getX() > 400)
        {
             record.move(-3);
             moveLabels(false,-1);
        }
        cat.moveTo(getWidth()/2 - labels.get(5).getWidth()/2,550, 1);
    }
    
    /**
     * Este metodo desaparece los records.
     */
    private void disappearRecord()
    {
        record.move(-3);
        if(record.isOutOnLeft())
        {
            record.remove();
            removeLabels();
            resetPress();
        }
    }
    
    /**
     * Con este metodo se manda a 
     * llamar a la ayuda.
     */
    private void help()
    {
        if(!twicePressed)
        {       
            appearHelp();
            disappearMenu();
        }
        else
        {
            disappearHelp();
            appearMenu();
        }
    }
    
    /**
     * Este metodo se encarga de aparecer a la ayuda.
     * Posiciona al gato en el boton para volver al menu.
     */
    private void appearHelp()
    {
        if(getObjects(Help.class).isEmpty())   
        {  
            addObject(help,getWidth() + help.getWidth()/2,300);
            addObject(labels.get(5), getWidth()+ (getWidth()*3)/4, 50);
        }
        else if(help.getX()> 400)
        {
             help.move(-3);
             moveLabels(false,-1);
        }
        cat.moveTo((getWidth()*3)/4 - labels.get(5).getWidth()/2,50, 1);
    }
    
    /**
     * Este metodo es el encargado de
     * desaparecer a la ayuda.
     */
    private void disappearHelp()
    {
        help.move(-3);
        if(help.isOutOnLeft())
        {
            help.remove();
            removeLabels();
            resetPress();
        }
    }
    
    /**
     * Este metodo se encarga de mover
     * al gato por las opciones del menu.
     * Checa que teclas se precionan.
     */
    private void menu()
    {
        if( index > 1 && isKeyOncePress("up"))
        {
            index--;
        }
        else if( index < 4 &&isKeyOncePress("down"))
        {
            index++;
        }
        
        enterPress();
        cat.moveTo(getWidth()/2 - labels.get(index).getWidth()/2 -50, getHeight()/2 + 50*(index-1), 1);
    }
  
    /**
     * Este metodo es el encargado de aparecer
     * al menu. 
     * Posiciona al gato de manera que pueda 
     * moverse por las opciones de dicho menu.
     */
    private void appearMenu()
    {
        Label label = labels.get(0);
        
        if(!getObjects(Label.class).contains(label))
        {
            addObject(label, getWidth()+ label.getWidth()/2, getHeight()/4);                
            for(int i = 0; i < 4; i++ )               
            {
                Label button = labels.get(i+1);
                addObject(button, getWidth() + label.getWidth()/2, getHeight()/2 + (50 * i)); 
            }
        }
        else if(label.getX() > getWidth()/2)
        {
            cat.moveTo(getWidth()/2 - labels.get(1).getWidth()/2 -50, getHeight()/2 , 1); 
            cat.rotationInit();
            moveLabels(false,-3);
        }
        else 
        {
            menu();
        }
    }
    
    /**
     * Este metodo se encarga de desaparecer al menu.
     */
    private void disappearMenu()
    {
        if(getObjects(Label.class).contains(labels.get(0)))
        {
            moveLabels(false,-2);
            removeLabels();
        }
    }
    
    /**
     * reinicia las variables que nos ayudan 
     * a saber si la tecla se preciono una o dos veces.
     */
    private void resetPress()
    {
        twicePressed = false;
        oncePressed = false;
    }
    
    /**
     * Este metoco checa si la tecla Enter
     * fue precionada.
     */
    private void enterPress()
    {
        if(isKeyOncePress("enter"))
        {
            if(oncePressed)
            {
                twicePressed = true;
            }
            else
            {
                oncePressed = true;
                select = index;
                index = 1;
            }
            getTimeSeconds().setValue(0);
        }
    }
}
