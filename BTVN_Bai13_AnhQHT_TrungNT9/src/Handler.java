import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Handler implements Runnable{
    private Socket client;
    private Server sv;

    Handler(Socket client, Server sv) {
        this.client = client;
        this.sv = sv;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(client.getInputStream());
            while(true)
            {
                if(!sc.hasNextLine())
                    return;
                String chatLine = sc.nextLine();
                System.out.println(chatLine);
                sv.sendChatMessageToAll(chatLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
