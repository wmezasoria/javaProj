package autonomia.chat;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class ChatClientT {
    static Socket socket;
    static int port;
    static String name;

    public static void main(String[] args) {
        ReceiveRunnableClient receive = new ReceiveRunnableClient();
        SendRunnableClient send = new SendRunnableClient();

        Thread tReceiver = new Thread(receive);
        Thread tSender = new Thread(send);

        try{
            port = Integer.parseInt(args[2]);
            socket = new Socket(args[1], port);
            name = args[0];
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());
            System.out.println("Welcome " + name + "!");
            System.out.println("Type 'bye' and press enter to disconnect");

            tReceiver.start();
            tSender.start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
class SendRunnableClient implements Runnable {
    @Override
    public void run() {
        PrintWriter writer = null;
        Console console = System.console();
        String sMsg;
        
        try {
        	writer = new PrintWriter(ChatClientT.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        	do {
                sMsg = console.readLine("[client]: ");
                writer.println(sMsg);
     
            } while (!sMsg.equals("bye"));
        	writer.println("Client disconnected");
            ChatClientT.socket.close();
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}



/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
class ReceiveRunnableClient implements Runnable {
    @Override
    public void run() {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(ChatClientT.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while((line = in.readLine()) != null) {
                if(line.equals("Server disconnected")){
                    System.out.println("> Server: bye");
                    System.out.println(line);
                    break;
                }
                System.out.println("\n[server] " + line);
                System.out.print("[client]: ");
            }
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}