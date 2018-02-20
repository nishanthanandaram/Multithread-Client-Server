import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
 
public class Authentication {
 
	public static File loginFile;
	public static Properties properties;
	public static String newLine = System.lineSeparator();
	
	static
	{
		loginFile = new File("C:\\Users\\Nishanth\\Documents\\Uta Study\\SEM3\\ADV SE\\AFTER SEM\\Final\\ftpcsmt\\src\\login.txt");
		properties = new Properties();
		try
		{
			String absPathName = loginFile.getAbsolutePath();
			properties.load(
				new FileInputStream(absPathName));
		}
		catch(IOException ioe)
		{
			System.err.println("Unable to read file.");
		}
	}
	
	public static void main(String[] args) 
		throws IOException{
		String username = new String("nishanth");
		String password = new String("nishanth");
		if(!loginFile.exists())
			loginFile.createNewFile();		
		Boolean keyMatch = keyCheck(username, password);
	}

	public static Boolean keyCheck(String username, String password)
	{
		for(String key: properties.stringPropertyNames())
			if(key.equals(username) && properties.getProperty(key).equals(password))
				return true;
		return false;
	}
}