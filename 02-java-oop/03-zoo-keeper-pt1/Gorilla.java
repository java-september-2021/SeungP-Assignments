public class Gorilla extends Mammal{
    public void throwSomething(){
        energyLevel -= 5;
        System.out.println("The gorilla has thrown something! Its energy level is now: " + energyLevel);
    }

    public void eatBananas(){
        energyLevel += 10;
        System.out.println("The gorilla has eatened some bananas! Its energy level is now: " + energyLevel);
    }

    public void climb(){
        energyLevel -= 10;
        System.out.println("The gorilla climbed a tree! Its energy level is now: " + energyLevel);
    }
}
