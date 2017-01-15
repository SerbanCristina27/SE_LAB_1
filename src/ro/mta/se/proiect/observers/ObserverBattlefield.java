package ro.mta.se.proiect.observers;

import ro.mta.se.proiect.observables.ObservableBattlefield;
import ro.mta.se.proiect.views.MainView;
import ro.mta.se.proiect.controllers.UserController;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by Cristina on 1/15/2017.
 */
public class ObserverBattlefield implements Observer{

    private ObservableBattlefield observableBattlefield;

    public ObserverBattlefield(ObservableBattlefield obs){
        this.observableBattlefield = obs;
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o == observableBattlefield){
            System.out.println("Observer ok!");
            if(UserController.updateBattlefieldMatrix(observableBattlefield.getRowIndex(),observableBattlefield.getColumnIndex()))
            {
                MainView.planeOK = true;
            }
            else {
                MainView.planeOK = false;
            }
        }
    }
}
