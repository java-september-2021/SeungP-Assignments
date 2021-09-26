public class Mammal {
    int energyLevel;

    public Mammal(){
        energyLevel = 100;
    }

    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public int displayEnergy(){
        System.out.println(energyLevel);
        return energyLevel;
    }
}
