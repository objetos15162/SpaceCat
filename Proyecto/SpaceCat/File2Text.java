import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.FileWriter;

/**
 * Write a description of class File here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class File2Text
{
    private ArrayList<String> text;
    private String fileName;
    private boolean fileInOpen;
    private boolean fileOutOpen;
    
    /**
     * class constructor...
     */
    public File2Text(String fileName)
    {
        text = new ArrayList();
        this.fileName = "docs/" + fileName;
        fileInOpen = false;
        fileOutOpen = false;
    }  
    
    /**
     * Este metodo se encarga de leer el archivo
     * de los records.
     */
    public void readFile()
    {
        text.clear();
        File file = new File(fileName);
        Scanner in = null;
        
        try
        {
            in = new Scanner(file);
            fileInOpen = true;
        }
        catch(Exception e)
        {
            fileInOpen = false;
        }
        
        while(fileInOpen && in.hasNextLine())
        {
            text.add(in.nextLine());
        }

    }
    
    /**
     * Este metodo se encarga de escribir en el
     * archivo de los records.
     */
    public void writeFile()
    {
        File file = new File(fileName);
        FileWriter out = null;
        
        try
        {
            out = new FileWriter(file);
            fileOutOpen = true;
            
            Iterator i = iterator();
            while(i.hasNext())
            {
                String string = (String)i.next();
                out.write(string);
                out.write(System.lineSeparator());
            }
            out.flush();
        }
        catch(Exception e)
        {
            fileOutOpen = false;
        }
    }
    
    public Iterator<String> iterator()
    {
        return text.iterator();
    }
    
    /**
     * Este metodo regresa el tamaño de
     * el texto que esta en el archivo.
     * @param text.size() representa el tamaño.
     */
    public int size()
    {
        return text.size();
    }
    
    /**
     * Este metodo regresa el texto.
     * @param text.get(index) representa el texto.
     */
    public String get(int index)
    {
        return text.get(index);
    }
    
    /**
     * Este metodo adiere el texto y el index.
     * @param string representa caracteres.
     * @param index
     */
    public void add(int index, String string)
    {
        text.add(index, string);
    }
    
    /**
     * Este metodo adiere los caracteres.
     * @param string representa los caracteres.
     */
    public void add(String string)
    {
        text.add(string);
    }
  
    /**
     * Este metodo mete el valor que tiene el index y string.
     * @param index
     * @param string representa caracteres.
     */
    public void set(int index, String string)
    {
        text.set(index, string);
    }
    
    /**
     * Este metodo remueve el index.
     * @param index.
     */
    public void remove(int index)
    {
        text.remove(index);
    }
    
    /**
     * Este metodo regresa si el archivo esta
     * abierto.
     * @param boolean false o true.
     */
    public boolean isFileExist()
    {
        return fileInOpen;
    }
}
