import java.io.*;
/**
 * Write a description of class FileUtils here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileUtils
{
    // instance variables - replace the example below with your own
    public static void WriteStringToFile(File file, String data, Boolean append) throws IOException{
        FileWriter fWriter = new FileWriter (file, append);
        PrintWriter pWriter = new PrintWriter(fWriter);
        pWriter.println(data);
        pWriter.close();
    
    }
}
