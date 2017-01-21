package ro.mta.se.proiect.observers;

import ro.mta.se.proiect.controllers.UserController;
import ro.mta.se.proiect.observables.ObservableBattlefield;
import ro.mta.se.proiect.observables.ObservableConnect;
import ro.mta.se.proiect.views.MainView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Cristina on 1/21/2017.
 */
public class ObserverConnect implements Observer {

    private ObservableConnect observableConnect;

    public ObserverConnect(ObservableConnect obs){
        this.observableConnect = obs;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o == observableConnect){
            System.out.println("Observer ok!");
        }
    }
}