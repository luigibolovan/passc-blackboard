package factory;

import factory.products.DefaultChairInProgress;
import factory.products.NoBackrestChairInProgress;
import factory.repository.ChairRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Luigi Bolovan
 *
 * Furniture factory class
 * Receives the orders from the clients and afterwards puts the "pieces" in the repository
 * to be assembled and packed
 */
public class FurnitureFactory {
    private ChairRepository mChairRepository;

    public FurnitureFactory(ChairRepository currentChairRepository){
        this.mChairRepository = currentChairRepository;
    }

    public void setFactoryBlackboard(ChairRepository chairRepository){
        this.mChairRepository = chairRepository;
    }

    public void order() {
        int noOfChairs = 0;

        System.out.print("Enter the chair type you want:\n" +
                "n - normal\n" +
                "b - with no backrest\n" +
                "enter:");

        char type = getChairType();

        switch (type) {
            case 'n':
                System.out.print("Enter the number of chairs:");
                noOfChairs = getNumberOfChairs();
                for (int i = 0; i < noOfChairs; i++) {
                    mChairRepository.addChair(new DefaultChairInProgress());
                }
                System.out.println("\nOrdered " + noOfChairs + " regular chairs\n");
                mChairRepository.init();
                break;
            case 'b':
                System.out.print("Enter the number of chairs:");
                noOfChairs = getNumberOfChairs();
                for (int i = 0; i < noOfChairs; i++) {
                    mChairRepository.addChair(new NoBackrestChairInProgress());
                }
                System.out.println("\nOrdered " + noOfChairs + " no backrest chairs\n");
                mChairRepository.init();
                break;
            default:
                System.out.println("-\n-\n!!! Wrong type !!!\n-\n-\n");
        }
    }

    private int getNumberOfChairs(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfChairs = 0;
        try{
            noOfChairs = Integer.parseInt(reader.readLine());
        }catch(IOException ioe){
            System.out.println("Exception occurred when entering the desired number of chairs");
        }

        return noOfChairs;
    }

    private char getChairType(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char enteredLetter = 0;
        try{
            enteredLetter = (char)reader.read();
        }catch(IOException ioe){
            System.out.println("Exception occurred when entering the desired type of chair");
            ioe.printStackTrace();
        }

        return enteredLetter;
    }

}
