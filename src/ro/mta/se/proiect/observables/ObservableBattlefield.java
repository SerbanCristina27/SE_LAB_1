package ro.mta.se.proiect.observables;



import ro.mta.se.proiect.utils.Constants;

import java.util.Observable;

/**
 * Created by Cristina on 1/15/2017.
 */
public class ObservableBattlefield extends Observable {

    Integer rowIndex;
    Integer columnIndex;


    public void setValue(Integer rowIndex, Integer columnIndex) {

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;

        setChanged();
        notifyObservers();
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public Integer getColumnIndex() {
        return columnIndex;
    }

}
