package ro.mta.se.proiect.factory;

/**
 * Created by Cristina on 1/15/2017.
 */


import ro.mta.se.proiect.observables.ObservableBattlefield;
import ro.mta.se.proiect.observables.ObservableConnect;
import ro.mta.se.proiect.observers.ObserverBattlefield;

import java.util.Observer;

public class ObserverFactory {

    public Observer getObserver(String observerType, Object observable)
    {
        if(observerType == null){
            return null;
        }

        if(observerType.equalsIgnoreCase("BATTLEFIELD")){
            return new ObserverBattlefield((ObservableBattlefield)observable);
        }
        else if(observerType.equalsIgnoreCase("CONNECT")){
            return  new ObserverConnect((ObservableConnect)observable);
        }
        else
        {
            return null;
        }
    }
}
