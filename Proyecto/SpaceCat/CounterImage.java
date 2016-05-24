import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Esta clase se encarga de contar la vida 
 * del jugador. 
 * La vida esta representada por una imagen.
 * @author (Jessica Ortiz) 
 */
public class CounterImage extends Counter
{
    private int valueImage;
    private int valueMax;
    private int numberOfImages;
    private GreenfootImage image;
   
   /**
    * Class constructor...
    */ 
    public CounterImage()
    {
        this(20,100);
    }
    
    public CounterImage(int valueImage, int valueMax)
    {
        this.valueImage = valueImage;
        this.valueMax = valueMax;
        this.numberOfImages =valueMax/valueImage;
        image = new GreenfootImage("NyanCatFace.png");
        image.scale(25, 25);
    }
    
    /**
     * Este metodo hace que aparsca la imagen 
     * q representara las vidas y le asigna su valor.
     */
    protected void upDateImage()
    {
        GreenfootImage images = new GreenfootImage((image.getWidth()+5)*numberOfImages, image.getHeight());
        
        for(int i = 0; i < getValue(); i+=20)
        {    
            if(getValue() > valueMax)
            {
                setValue(valueMax);
            }
            images.drawImage(image, (i/20)*(image.getWidth() + 5), 0);
        }
        setImage(images);
    }
}
