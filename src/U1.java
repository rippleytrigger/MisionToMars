public class U1 extends Rocket {

    U1(int cost, float weight, float maxWeight, float cargoCarried, double rateExplosion, double rateCrash ){
        super(cost, weight, maxWeight, cargoCarried, rateExplosion, rateCrash);
    }

    private double calculateChanceLaunchExplosion(){
        return rateExplosion * (cargoCarried / maxWeight);
    }

    private double calculateChanceLandingCrash(){
        return rateCrash * (cargoCarried / maxWeight);
    }

    public boolean launch(){
        if(Math.random() > calculateChanceLaunchExplosion()){
            return true;
        }

        return false;
    }

    public boolean land(){
        if(Math.random() > calculateChanceLandingCrash()){
            return true;
        }

        return false;
    }
}
