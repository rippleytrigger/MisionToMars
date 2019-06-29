public class Rocket implements StarShip {
    protected int cost = 0;
    protected float weight = 0;
    protected float maxWeight = 0;
    protected float cargoCarried = 0;
    protected double rateExplosion = 0;
    protected double rateCrash = 0;

    Rocket(){
        cost = 0;
        weight = 0;
        maxWeight = 0;
        cargoCarried = 0;
        rateExplosion = 0;
        rateCrash = 0;
    }

    Rocket(int cost, float weight, float maxWeight, float cargoCarried, double rateExplosion, double rateCrash ){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.cargoCarried = cargoCarried;
        this.rateExplosion = rateExplosion;
        this.rateCrash = rateCrash;
    }

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public final boolean canCarry(Item item){
        return  (weight + item.getWeight() + cargoCarried <= maxWeight);
    }

    public final void carry(Item item){
        cargoCarried += item.getWeight();
    }

    public final int getRocketCost(){
        return cost;
    }
}
