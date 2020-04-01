package autonomia.chat;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
public class ChatServerT {
    static int port;
    static ServerSocket serverSocket;
    static Socket socket;

    public static void main(String[] args) {
        ReceiveRunnableServer receive = new ReceiveRunnableServer();
        SendRunnableServer send = new SendRunnableServer();

        Thread receiver = new Thread(receive);
        Thread sender = new Thread(send);

        try{
            port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started with port: " + serverSocket.getLocalPort());

            socket = serverSocket.accept();
            System.out.println("Connection Established with client: " + socket.getRemoteSocketAddress());
            System.out.println("Type 'bye' and press enter to disconnect");

            receiver.start();
            sender.start();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
class SendRunnableServer implements Runnable {
    @Override
    public void run() {
        Console console = System.console();
        String sMsg;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ChatServerT.socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
        	do {
                sMsg = console.readLine("[server]: ");
                writer.println(sMsg);
     
            } while (!sMsg.equals("bye"));
            writer.println("Server disconnected");
            ChatServerT.socket.close();
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}

/**
 * @author William.Meza
 * @version $Revision: 1.0 $
 */
class ReceiveRunnableServer implements Runnable {
    @Override
    public void run() {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(ChatServerT.socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while((line = in.readLine()) != null) {
                if(line.equals("Client disconnected")){
                    System.out.println("> Client: bye");
                    System.out.println(line);
                    break;
                }
                System.out.println("\n[client] " + line);
                System.out.print("[server]: ");
            }
        } catch (IOException e) {
            System.out.println("Disconnected");
        }
    }
}