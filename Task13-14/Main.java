package hw_final2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();

        try (Counter counter = new Counter()) {
            System.out.println("Enter animal data (name commands color):");
            String[] animalData = scanner.nextLine().split(" ");

            if (animalData.length != 3) {
                System.out.println("Invalid input format.");
                return;
            }

            Animal animal = new Animal();
            animal.setName(animalData[0]);
            animal.setCommands(animalData[1]);
            animal.setColor(animalData[2]);
            
            dbManager.addAnimal(animal);
            counter.add();
            
            System.out.println("Animal added. Current count: " + counter.getCount());
        }
    }
}
