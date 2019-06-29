public interface StarShip {

    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
