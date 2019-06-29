import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private final float tonnesRate = 1000;

    public ArrayList<Item> loadItems(File file) throws RuntimeException{
        Scanner fileReader = null;
        ArrayList<Item> items = new ArrayList<>();

        try{
            fileReader = new Scanner(file);
        }catch (FileNotFoundException e){
            System.out.print("File not Found");
        }

        while (fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            String itemName = "";
            float itemWeight = 0;

            if(line.indexOf('=') != -1){
                String[] parts = line.split("=");

                //Item Name
                itemName = parts[0];

                //Transform KG to Tonnes
                itemWeight = Float.parseFloat(parts[1]) / tonnesRate;
            }else{
                throw new RuntimeException("The file couldn´t be read completely.");
            }

            Item item = new Item(itemName, itemWeight);

            items.add(item);
        }

        return items;
    }

    public ArrayList loadU1(ArrayList<Item> items){
        ArrayList<Rocket> U1Rockets = new ArrayList<>();
        int itemCounter = 0;

        while (itemCounter < items.size()){

            Rocket u1 = new U1(100, 10, 18, 0, 0.05, 0.01);

            for(int i = itemCounter; i < items.size(); i++, itemCounter++){
                if(u1.canCarry(items.get(i))){
                   u1.carry(items.get(i));
                }else{
                    break;
                }
            }

            U1Rockets.add(u1);
        }

        return U1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> U2Rockets = new ArrayList<>();
        int itemCounter = 0;

        while (itemCounter < items.size()){

            Rocket u2 = new U2(120, 18, 29, 0, 0.04, 0.08);

            for(int i = itemCounter; i < items.size(); i++, itemCounter++){
                if(u2.canCarry(items.get(i))){
                    u2.carry(items.get(i));
                }else{
                    break;
                }
            }

            U2Rockets.add(u2);
        }

        return U2Rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int totalBudget = 0;

        for(Rocket rocket : rockets){
            while (true){
                totalBudget += rocket.getRocketCost();

                if(rocket.land() && rocket.launch()){
                    break;
                }
            }
        }

        return totalBudget;
    }
}
