import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private Scanner inputStream;

    private Client() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your nick?");
        String nick = keyboard.nextLine();

        Socket client = null;
        try {
            client = new Socket("127.0.0.1", 1234);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("not found");
        }
        if (client != null) {
            inputStream = new Scanner(client.getInputStream());
        }
        PrintWriter outputStream = null;
        if (client != null) {
            outputStream = new PrintWriter(client.getOutputStream());
        }
        Thread t = new Thread(this);
        t.start();
        while (keyboard.hasNextLine()) {
            String msg = keyboard.nextLine();
            if (outputStream != null) {
                outputStream.println(nick + " says: " + msg);
                outputStream.flush();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        new Client();
    }

    @Override
    public void run() {
        while (true) {
            if (inputStream.hasNextLine())
                System.out.println(inputStream.nextLine());
        }
    }
}