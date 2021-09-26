public class Bat extends Mammal{
    public Bat(){
        energyLevel = 300;
    }

    public void fly(){
        energyLevel -= 50;
        System.out.println("You hear the sound of a bat taking off. The bat's energy level is now: " + energyLevel);
    }

    public void eatHumans(){
        energyLevel += 25;
        System.out.println("You hear the screams of helpless individuals as they are consumed alive. The bat's energy level is now: " + energyLevel);
    }

    public void attackTown(){
        energyLevel -= 100;
        System.out.println("You hear the crumble of brick and steel as a town slowly burns down. The bat's energy level is now: " + energyLevel);
    }
}
