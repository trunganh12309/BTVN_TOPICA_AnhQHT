import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Server {
    private ServerSocket sv;
    private ArrayList<Socket> clientList;

    Server() {
        try {
            this.sv = new ServerSocket(1234);
            clientList = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void start(){
        System.out.println("Waiting for client...");
        while (true){
            try {
                Socket client = sv.accept();
                clientList.add(client);
                System.out.println("New client joined in!");
                Handler handler = new Handler(client,this);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }

    void sendChatMessageToAll(String msg) throws IOException {
        for (Socket client : clientList) {
            if (!client.isClosed()) {
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.println(msg);
                pw.flush();
            }
        }
    }
}
