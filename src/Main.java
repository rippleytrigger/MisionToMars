import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        System.out.println("----- Commencing Simulation -----");
        Simulation simulation = new Simulation();

        System.out.println("----- Preparing Simulation Phases -----");
        File phase1 = new File("phase-1.txt");
        File phase2 = new File("phase-2.txt");

        System.out.println("----- Loading Items -----");
        ArrayList<Item> itemsPhase1 = simulation.loadItems(phase1);
        ArrayList<Item> itemsPhase2 = simulation.loadItems(phase2);

        System.out.println("----- Preparing Rockets U1 -----");
        ArrayList<Rocket> rocketsU1Phase1 = simulation.loadU1(itemsPhase1);
        ArrayList<Rocket> rocketsU1Phase2 = simulation.loadU1(itemsPhase2);

        System.out.println("--- Extracting Budget From Rockets U1 ---");
        System.out.println("The Total Budget for Rockets U1 are $" +
                (simulation.runSimulation(rocketsU1Phase1) + simulation.runSimulation(rocketsU1Phase2)) + " Millions");

        System.out.println("----- Preparing Rockets U2 -----");
        ArrayList<Rocket> rocketsU2Phase1 = simulation.loadU2(itemsPhase1);
        ArrayList<Rocket> rocketsU2Phase2 = simulation.loadU2(itemsPhase2);

        System.out.println("--- Extracting Budget From Rockets U2 ---");
        System.out.println("The Total Budget for Rockets U2 are $" +
                (simulation.runSimulation(rocketsU2Phase1) + simulation.runSimulation(rocketsU2Phase2)) + " Millions");
    }
}
