package CatalogVirtual;

/**
 * Created by User on 11/17/2016.
 */
public class Student extends Person {
    private String rank;
    private float totalAverage;
    private float fee;
    private Subject[] subjects;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public float getTotalAverage() {
        return totalAverage;
    }

    public void setTotalAverage(float totalAverage) {
        this.totalAverage = totalAverage;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public void calculateTotalAverage() {

    }
    public void addMark(){

    }
    public void cancelMark(){

    }

}
