package ro.mta.se.proiect.models;

/**
 * Created by Cristina on 1/10/2017.
 */
public class FriendModel {

    String friendName;
    String friendIp;

    public FriendModel(){
        this.friendName = "";
        this.friendIp = "";
    }

    public FriendModel(String name, String ip){
        this.friendName = name;
        this.friendIp = ip;
    }

    String getFriendName(){return  friendName;}

    String getFriendIp(){return friendIp;}

    void setFriendName(String friendName) {this.friendName = friendName;}

    void setFriendIp(String friendIp) {this.friendIp = friendIp;}


}
