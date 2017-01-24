package ro.mta.se.proiect.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import ro.mta.se.proiect.models.FriendModel;

import javax.swing.*;

/**
 * Created by Cristina on 1/16/2017.
 */
public class ClientController implements Runnable {

    FriendModel friendModel;

    public ClientController(){
    }

    public ClientController(String serverAddress, Integer portNumber){
        friendModel = new FriendModel(serverAddress,portNumber);
    }

    public  ClientController(String friendName, String serverAddress, Integer portNumber) throws IOException {
        friendModel = new FriendModel(friendName,serverAddress,portNumber);
    }


    @Override
    public void run(){

        String serverAddress = friendModel.getFriendIp();
        Integer serverPort = friendModel.getPortNumber();

        try {
            FriendModel.clientSocket = new Socket(serverAddress,serverPort);
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(FriendModel.clientSocket.getInputStream()));
            String answer = input.readLine();
            JOptionPane.showMessageDialog(null, answer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
