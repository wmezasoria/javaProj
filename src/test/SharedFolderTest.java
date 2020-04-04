package test;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

public class SharedFolderTest {

	static final String USER_NAME = "wmeza";
    static final String PASSWORD = "2344149Saskia!";
    //e.g. Assuming your network folder is: \my.myserver.netsharedpublicphotos
    static final String NETWORK_FOLDER = "smb://10.10.43.54/compartida/";
 
    public static void main(String args[]) {
        String fileContent = "This is a test file";
        new SharedFolderTest().copyFiles(fileContent, "testFile.txt");
    }
 
    public boolean copyFiles(String fileContent, String fileName) {
        boolean successful = false;
         try{
                String user = USER_NAME + ":" + PASSWORD;
                System.out.println("User: " + user);
 
                NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
                String path = NETWORK_FOLDER +"/"+ fileName;
                System.out.println("Path: " +path);
 
                SmbFile sFile = new SmbFile(path, auth);
                System.out.println("sFile.exists "+sFile.exists());
                if(!sFile.exists())
                	sFile.mkdir();//crear carpetas
                SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
                sfos.write(fileContent.getBytes());

                SmbFile sFile = new SmbFile(path, auth);
                SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
                sfos.write(fileContent.getBytes());
 
                successful = true;
                System.out.println("Successful " + successful);
            } catch (Exception e) {
                successful = false;
                e.printStackTrace();
            }
        return successful;
    }
}
