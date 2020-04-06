
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import blackboards.Blackboard;
import products.DefaultChairInProgress;
import products.NoBackrestChairInProgress;

public class FurnitureFactory {
    private Blackboard mBlackboard;

    public FurnitureFactory(Blackboard currentBlackboard){
        this.mBlackboard = currentBlackboard;
    }

    public void setFactoryBlackboard(Blackboard blackboard){
        this.mBlackboard = blackboard;
    }

    public void order(){
        boolean ready = false;
        int noOfChairs = 0;
        while(false == ready) {
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
                        mBlackboard.addChair(new DefaultChairInProgress());
                    }
                    System.out.println("\nAdded " + noOfChairs + " regular chairs\n");
                    break;
                case 'b':
                    System.out.print("Enter the number of chairs:");
                    noOfChairs = getNumberOfChairs();
                    for (int i = 0; i < noOfChairs; i++) {
                        mBlackboard.addChair(new NoBackrestChairInProgress());
                    }
                    System.out.println("\nAdded " + noOfChairs + " no backrest chairs\n");
                    break;
                case 'r':
                    mBlackboard.init();
                    ready = true;
                    break;
                default:
                    System.out.println("-\n-\n!!! Wrong type !!!\n-\n-\n");
            }
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
