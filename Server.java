package com.classe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;



public class Server {

    private static final int PORT = 9001;

    private static Vector<ArrayList<String>> users = new Vector<ArrayList<String>>();

    public static void main(String[] args) throws Exception {
        System.out.println("The server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        private ArrayList<String> user = new ArrayList<String>();

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {

                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (users) {
                    	user.add(name);
                    	user.add(socket.getLocalSocketAddress().toString());
                        if (!users.contains(user)) {
                            users.add(user);
                            for (ArrayList<String> user : users) {
                            	out.println("CONNECTED"+user.get(0)+" "+user.get(1));
                            }
                            out.println("CLOSE");
                            break;
                        }
                    }
                }

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    if (input.startsWith("REFRESH")) {
                    	for (ArrayList<String> user : users) {
                        	out.println("CONNECTED"+user.get(0)+" "+user.get(1));
                        }
                        out.println("CLOSE");
                    }
                    if (input.startsWith("THREAD")) {
                    	out.println("ANSWERVous etes connecté en tant que "+user.get(1));
                    	out.println("CLOSE");
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
                if (user != null) {
                    users.remove(user);
                }
                
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}