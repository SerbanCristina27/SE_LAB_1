package ro.mta.se.lab1;

/**
 * Created by User on 11/18/2016.
 */
public class Animal extends Food implements IAnimal {
    public enum TypeAnimal {
        Carnivore, Herbivore, Omnivorous
    }

    private String name;
    private int coop;
    Food food;
    long time;
    TypeAnimal type;

    public TypeAnimal getType() {
        return type;
    }

    public Animal(String name, TypeAnimal type, int coop, double quantity, long time) {
        super(quantity);
        this.name = name;
        this.type = type;
        this.coop = coop;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoop() {
        return coop;
    }

    public void setCoop(int coop) {
        this.coop = coop;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setType(TypeAnimal type) {
        this.type = type;
    }

    public void eat() {
        long doneEat = System.currentTimeMillis();


    }


}
