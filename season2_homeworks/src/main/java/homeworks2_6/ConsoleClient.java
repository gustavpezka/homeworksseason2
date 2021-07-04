package homeworks2_6;

import java.io.*;
import java.net.Socket;

public class ConsoleClient{
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ConsoleClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException{
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(()->{
            try{
                while (true) {
                    String messageFromServer = in.readUTF();
                    if(messageFromServer.equalsIgnoreCase("/end")){
                        break;
                    }
                    System.out.println(messageFromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String messageToServer = reader.readLine();
                    out.writeUTF("Client: " + messageToServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void closeConnection() throws IOException{
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

    public void sendMessage(String messageToServer) throws IOException{
       try {
           out.writeUTF("Message from client: " + messageToServer);
       }catch (IOException e){
           e.printStackTrace();
           System.out.println("Problem with outgoing message");
       }
    }

    public static void main(String[] args) {
        ConsoleClient consoleClient = new ConsoleClient();
    }
}


