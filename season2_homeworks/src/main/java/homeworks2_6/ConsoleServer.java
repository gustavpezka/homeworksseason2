package homeworks2_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ConsoleServer {
    private DataInputStream in = null;
    private DataOutputStream out = null;
    Socket socket = null;

    public static void main(String[] args) {
        ConsoleServer consoleServer = new ConsoleServer();
        new Thread(() -> {
            while (true) {
                consoleServer.sendMessage();
            }
        }).start();

        new Thread(()->{
            while (true) {
                consoleServer.receiveMessage();
            }
        }).start();
    }

    public ConsoleServer() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is running, awaiting client...");
            socket = serverSocket.accept();
            System.out.println("Client connected");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String messageToClient = reader.readLine();
            if (messageToClient.equalsIgnoreCase("/end")){
                closeConnection();
                System.exit(0);
            }
            this.out.writeUTF("Server: " + messageToClient);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Problem with outgoing message");
        }
    }

    public void receiveMessage(){
        try {
            String messageFromClient = this.in.readUTF();
            if (messageFromClient.equalsIgnoreCase("/end")){
                closeConnection();
                System.exit(0);
            }
            System.out.println(messageFromClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try{
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
