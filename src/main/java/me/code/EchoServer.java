package me.code;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private final int port;
    private ServerSocket serverSocket;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            this.serverSocket = new ServerSocket(this.port);

            while (!this.serverSocket.isClosed()) {

                Socket clientSocket = this.serverSocket.accept();
                System.out.println("A client has connected from: " + clientSocket.getInetAddress().getHostAddress());

                new EchoClient(clientSocket).start();
            }

            this.serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
