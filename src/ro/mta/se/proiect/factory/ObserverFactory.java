package ro.mta.se.proiect.factory;

/**
 * Created by Cristina on 1/15/2017.
 */


import ro.mta.se.proiect.observables.ObservableBattlefield;
import ro.mta.se.proiect.observers.ObserverBattlefield;
import ro.mta.se.proiect.views.MainView;

import java.util.Observer;

public class ObserverFactory {

    public Observer getObserver(String observerType, ObservableBattlefield observableBattlefield)
    {
        if(observerType == null){
            return null;
        }

        if(observerType.equalsIgnoreCase("BATTLEFIELD")){
            return new ObserverBattlefield(observableBattlefield);
        }
        else
        {
            return null;
        }
    }
}
