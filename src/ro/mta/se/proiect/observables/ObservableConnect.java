package ro.mta.se.proiect.observables;

import java.util.Observable;

/**
 * Created by Cristina on 1/21/2017.
 */
public class ObservableConnect extends Observable {

    String friendIp;
    Integer port;

    public void setValue(String friendIp,Integer port) {

        this.friendIp = friendIp;
        this.port = port;

        setChanged();
        notifyObservers();
    }

    public String getFriendIp() {
        return friendIp;
    }

    public void setFriendIp(String friendIp) {
        this.friendIp = friendIp;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return port;
    }
}
