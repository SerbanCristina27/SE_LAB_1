package CatalogVirtual;

/**
 * Created by User on 11/17/2016.
 */

enum Type {
    course, lab, seminar
}

public class Subject {


    private String nameSubject;
    private int nrMarks;
    private float average;
    private int credits;
    private Type type;
    private Teacher[] teachers;
    private Mark[] marks;

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getNrMarks() {
        return nrMarks;
    }

    public void setNrMarks(int nrMarks) {
        this.nrMarks = nrMarks;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Mark[] getMarks() {
        return marks;
    }

    public void setMarks(Mark[] marks) {
        this.marks = marks;
    }

    public void calculateAverage() {

    }

    public void checkArrears() {

    }

    public void changeNumberCredits() {

    }
}
