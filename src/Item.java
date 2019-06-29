public class Item {
    private String name;
    private float weight /* In TONNES */;

    Item(){
        name = "";
        weight = 0;
    }

    Item(String name, float weight){
        this.name = name;
        this.weight = weight;
    }

    public float getWeight(){
        return weight;
    }
}
