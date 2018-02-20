import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientToServerConnection implements Runnable {

	private static Socket sock;
	private  String fileName;
	private  BufferedReader stdin;
	private  PrintStream os;
	static String ip = "127.0.0.1";

	private boolean USERSET = false;
	private String USERNAME ="";
	private BufferedReader ins;
	
	private String[] splited;
	private String command;
    private volatile boolean running = true;
	
	public ClientToServerConnection(String [] args){
		splited = args;
		command=splited[0];
	}
	
	public void terminate() {
        running = false;
    }
	
	@Override
	public void run() {
	try{
		Thread.sleep(0);
		if(running)
		synchronized (this) {
		try {
		    sock = new Socket(ip, 4446);
		    stdin = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
		    System.err.println("Cannot connect to the server, try again later.");
		    System.exit(1);
		}
		
		try {
			os = new PrintStream(sock.getOutputStream());
			ins = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	try{
		switch (command) {
	    
		case "MODE":
			String operation=splited[1];
			os.println(command);
			os.println(operation);
    	    System.out.println("Currently in "+ins.readLine()+" mode");
				            
			break;
   
		case "TYPE":
			String operation2=splited[1];
			os.println(command);
			os.println(operation2);
			System.out.println("Type changed to "+ins.readLine());
			break;

		case "PUT":
			String operation3=splited[1];
	        store(operation3);
	        break;
	    
	    case "GET":
	    	/*String operation4=splited[1];
	        os.println(command);
	        os.println(operation4);
	        retrieve(operation4);*/
	        
	    	String operation4=splited[1];
	    	os.println(command);
	    	String serverAck = ins.readLine();
	    	if(serverAck.equalsIgnoreCase("Server ACK: Get Command Received. Send File Name")){
		    	os.println(operation4);
	    	}
	        retrieve(operation4);
	    	System.out.println(ins.readLine());
	        break;
	    
	    case "LS":
	    	os.println(command);
	    	int count = Integer.parseInt(ins.readLine());
	    	System.out.println("List of Files :");
	    	for(int i = 0; i < count; i++){
	    		System.out.println(ins.readLine());
	    	}
	    	
	    	break;
	    	
	   
	    case "USER":
	    	String operation6=splited[1];
        	os.println(command);
        	os.println(operation6);
        	USERSET = true;
        	if(ins.readLine().equals("false")){
        		System.out.println("Invalid user");
        	}
        		
        	else{
        		USERSET = true;
        		USERNAME = operation6;
        	}        		
            break;
	    	
		case "QUIT":
		   	 sock.close();
		     break;
		}
	}catch (Exception e) {
	     System.err.println(e);
	 }
	}
		return;
	}catch (InterruptedException e) {
        running = false;
        return;
    	}
	}
	
    public synchronized void store(String fileName) {
try {
   os.println(command);
   File myFile = new File(fileName);
   byte[] mybytearray = new byte[(int) myFile.length()];
   FileInputStream fileInputStream = new FileInputStream(myFile);
   BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
   System.out.println("2");
   DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
   dataInputStream.readFully(mybytearray, 0, mybytearray.length);
   OutputStream outputStream = sock.getOutputStream();
   System.out.println("3");
   DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
   dataOutputStream.writeUTF(myFile.getName());
   dataOutputStream.writeLong(mybytearray.length);
   dataOutputStream.write(mybytearray, 0, mybytearray.length);
   System.out.println("4");
   System.out.println("5");
   System.out.println("File "+fileName+" sent to Server.");
    } catch (Exception e) {
       System.err.println("File does not exist!"+e);
}
}

     public synchronized void retrieve(String fileName) {
  try {
   int bytesRead;
   InputStream in = sock.getInputStream();
   DataInputStream clientData = new DataInputStream(in);
   fileName = clientData.readUTF();
   OutputStream output = new FileOutputStream(("From_Server_" + fileName));
   long size = clientData.readLong();
   byte[] buffer = new byte[1024];
   while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) 
                   Math.min(buffer.length, size))) != -1) {
       output.write(buffer, 0, bytesRead);
       size -= bytesRead;
   }
   System.out.println("File "+fileName+" received from Server.");
} catch (IOException ex) {
   Logger.getLogger(ServerToClientConnection.class.getName()).log(Level.SEVERE, null, ex);
}
 }
}
