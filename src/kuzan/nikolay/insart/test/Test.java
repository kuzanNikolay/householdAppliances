package kuzan.nikolay.insart.test;

import kuzan.nikolay.insart.container.Container;
import kuzan.nikolay.insart.model.Fridge;
import kuzan.nikolay.insart.model.HouseholdAppliances;
import kuzan.nikolay.insart.model.WashingMachine;

/**
 * Created by Nikolay on 15.07.14.
 */
public class Test {
    public static void main(String[] args) {

        /**
         * Can contain all the inheritors of the class HouseholdAppliances
         */
        Container<HouseholdAppliances> container = new Container<HouseholdAppliances>();

        /**
         * Creating new Fridge using a standard constructor         *
         */
        Fridge fridge = new Fridge();
        fridge.setPrice(2500.0);
        fridge.setFreezerPresence(true);
        fridge.setProductName("NORD-125");
        fridge.setPrice(2399.9);

        /**
         * Adding new Fridge and WashingMachine objects to container.
         * Objects are created using a constructor with parameters.
         */
        container.add(fridge);
        container.add(new Fridge("H18ks", 1300.0, false));
        container.add(new Fridge("H20ks", 1100.0, false));
        container.add(new Fridge("N43dd", 2750.0, true));
        container.add(new WashingMachine("W32-ff", 2300.5, 600));
        container.add(new WashingMachine("W55-1f", 4050.0, 800));

        /**
         * Adding new WashingMachine object to container.
         * Object is created using a standard constructor.
         */
        container.add(new WashingMachine());

        /**
         * Printing the contents of the unsorted container
         */
        System.out.println("---------------------------------------Unsorted---------------------------------------");
        container.print();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        /**
         * Sorting the contents of the container by price
         */
        container.sort();

        /**
         * Printing the contents of the container sorted by price
         */
        System.out.println("------------------------------------Sorted by price-----------------------------------");
        container.print();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        try {
            /**
             * Printing average price of all created Washing Machines and average price of all created Fridges
             */
            System.out.println("Washing machine average price = " + WashingMachine.getAveragePrice());
            System.out.println("Fridge average price = " + Fridge.getAveragePrice());
            System.out.println();

            /**
             * Printing count of all elements in the container
             */
            System.out.println("Count of elements in container = " + container.count());

            /**
             * Getting and printing element with index '2' from the container
             */
            System.out.println(container.get(2));

        } catch (Exception e){
            System.out.println("ERROR! " + e.getMessage());
        }
    }
}