import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Iterator;
/**
 * Esta clase agrega los records.
 * 
 * @author (Jessica Ortiz) 
 */
public class Record extends Actor
{
    private File2Text text;
    private GreenfootImage image;
 
    /**
     * class constructor...
     */
    public Record()
    {
        text = new File2Text("Records.txt");
        image = new GreenfootImage(800,600);
        setImage(image);
    }
    
    /**
     * Este metodo checa si existe ya un archivo
     * y si no lo crea, al crearlo lo lee y lo escribe.
     */
    public void showImage()
    {
        text.readFile();

        if(!text.isFileExist())
        {
            text.add("                 Records");
            text.add("   No       Time:           Scores:");
            for(int i = 0; i < 7; i++)
            {
                text.add("   "+ (i + 1) + "        00000            00000");
            }
            text.writeFile();
        }
       
        Iterator it = text.iterator();
        int space = 0;
        image.clear();
        while(it.hasNext())
        {
           String label = (String)it.next();
           GreenfootImage imageLabel = CustomFont.drawString2(label, "PressStart2P", 20);
           image.drawImage(imageLabel, 0, space += 50);
        }
    }
    
    /**
     * Este metodo guarda lo que se escribio en el archivo.
     */
    public void save(int time, int points)
    {
        int size = text.size();
        
        for(int i = 2; i < size; i++)
        {
            String Label = text.get(i);
            
            if(Integer.parseInt(Label.substring(29)) <= points)
            {
                text.add(i,"   " + (i-1) + "        " + String.format("%05d", time) + "            " + String.format("%05d", points));
                text.remove(size);
                points = 0;
                time = 0;
            }
            else
            {
                text.set(i,"   " + (i-1) + Label.substring(4));
            }
        }
        
        text.writeFile();
    }
    
    /**
     * Este metodo regresa el tamaño de la
     * imagen de los Record.
     * @return getImage().getWidth()
     * representa el tamaño a lo ancho.
     */
    public int getWidth()
    {
        return getImage().getWidth();
    }
    
    /**
     * Este metodo verifica si la imagen esta fuera de 
     * la pantalla.
     * Regresa un boolean
     * @param boolean false o true.
     */
    public boolean isOutOnLeft()
    {
        if(getX() + getWidth()/2 < 0)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Este metodo remueve el objeto Record
     * del world.
     */
    public void remove()
    {
        getWorld().removeObject(this);
    }
    
    /**
     * Act - do whatever the Records wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
    }    
}
