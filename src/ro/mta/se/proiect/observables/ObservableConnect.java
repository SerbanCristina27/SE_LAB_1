package ro.mta.se.proiect.observables;

import java.util.Observable;

/**
 * Created by Cristina on 1/21/2017.
 */
public class ObservableConnect extends Observable {

    String friendIp;

    public void setValue(String friendIp) {

        this.friendIp = friendIp;

        setChanged();
        notifyObservers();
    }

    public String getFriendIp() {
        return friendIp;
    }

    public void setFriendIp(String friendIp) {
        this.friendIp = friendIp;
    }
}
