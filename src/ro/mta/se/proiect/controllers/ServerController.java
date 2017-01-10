package ro.mta.se.proiect.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static java.io.FileDescriptor.out;


/**
 * Created by Cristina on 1/9/2017.
 */


public class ServerController implements Runnable {

    Selector selector;
    ServerSocketChannel channel;
    int[] ports = {4000,4001,4002};

    public void run() {



        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int port : ports){

                    try {
                        channel = ServerSocketChannel.open();
                        channel.configureBlocking(false);
                        channel.socket().bind(new InetSocketAddress(port));
                        channel.register(selector, SelectionKey.OP_ACCEPT);
                    }
                 catch (IOException e) {
                    e.printStackTrace();
                }
            }

            while(selector.isOpen()) try {
                selector.select();
                Set key = selector.selectedKeys();
                Iterator iter = key.iterator();

                while(iter.hasNext()){
                    SelectionKey selKey = (SelectionKey) iter.next();

                    if(selKey.isAcceptable()){

                        ServerSocketChannel friend = (ServerSocketChannel)selKey.channel();
                        SocketChannel client = friend.accept();

                        Socket socket = client.socket();

                        try {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println("###HELLO_CHAT_PACKET###");
                        } finally {
                            client.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }



}
