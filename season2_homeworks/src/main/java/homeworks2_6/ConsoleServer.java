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
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String messageToClient = reader.readLine();
                    consoleServer.out.writeUTF("Message from server: " + messageToClient);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true) {
                try {
                    System.out.println(consoleServer.in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public ConsoleServer() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String messageToServer) throws IOException{
        try {
            out.writeUTF(messageToServer);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Problem with outgoing message");
        }
    }

    public void receiveMessage(){
        try {
            String messageFromClient = in.readUTF();
            if (messageFromClient.equals("/end")){
                closeConnection();
            }
            System.out.println(messageFromClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
