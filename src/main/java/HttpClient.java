import com.google.gson.Gson;
import request.HttpRequest;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {

    public static void main(String []args) throws IOException {
        String serverName = "localhost";
        Gson gson = new Gson();
        int port = 8011;
        Scanner scanner = new Scanner(System.in);
        String method;
        String path;
        while(true) {
            method = scanner.next();
            path = scanner.next();
            HttpRequest httpRequest = new HttpRequest(method, "localhost", "", port, path);
            String requestString = gson.toJson(httpRequest);
            try {
                System.out.println("Connecting to " + serverName + " on port " + port);
                Socket client = new Socket(serverName, port);

                System.out.println("Just connected to " + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);

                out.writeUTF(requestString);
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);

                System.out.println("Server says " + in.readUTF());
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
