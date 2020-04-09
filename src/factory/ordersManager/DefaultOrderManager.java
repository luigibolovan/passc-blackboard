package factory.ordersManager;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import factory.repository.ChairRepository;
import factory.employeeManager.EmployeeManager;
import factory.products.DefaultChairInProgress;
import factory.products.NoBackrestChairInProgress;

/**
 * @author Luigi Bolovan
 *
 *
 * Implementation of the OrdersManager interface.
 */
public class DefaultOrderManager implements OrdersManager {
    private ChairRepository mChairRepository;
    private EmployeeManager mEmployeeManager;

    /**
     * Gets the client's first order. Called by the factory
     * @param repository : the repository where the "pieces" of the chairs will be located
     * @param employeeManager : tells the employees to start working when the order has been submitted
     */
    @Override
    public void getOrder(ChairRepository repository, EmployeeManager employeeManager) {
        int noOfChairs = 0;

        employeeManager.setOrdersManager(this);
        rememberEntitiesForOtherOrders(repository, employeeManager);

        System.out.print("Hello, thank you for ordering:\n" +
                        "Steps:\n" +
                        "1. Enter the desired type of chair. Options:\n" +
                        "n - normal\n" +
                        "b - with no backrest\n" +
                        "2. Enter the quantity for each type of chair ordered\n" +
                        "3. Press r submit order\n");

        boolean ready = false;
        while(!ready) {
            System.out.print("\nEnter type of chair or submit(r):");
            char type = getOptions();
            switch (type) {
                case 'n':
                    System.out.print("Enter the number of chairs:");
                    noOfChairs = getNumberOfChairs();
                    for (int i = 0; i < noOfChairs; i++) {
                        repository.addChair(new DefaultChairInProgress());
                    }
                    System.out.println("Ordered " + noOfChairs + " regular chairs");
                    break;
                case 'b':
                    System.out.print("Enter the number of chairs:");
                    noOfChairs = getNumberOfChairs();
                    for (int i = 0; i < noOfChairs; i++) {
                        repository.addChair(new NoBackrestChairInProgress());
                    }
                    System.out.println("Ordered " + noOfChairs + " no backrest chairs");

                    break;
                case 'r':
                    ready = true;
                    if (noOfChairs == 0) break;
                    employeeManager.init(repository);
                    break;
                default:
                    System.out.println("\n#\n Wrong type \n#\n");
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

    private char getOptions(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char enteredLetter = 0;
        try{
            enteredLetter = (char)reader.read();
        }catch(IOException ioe){
            System.out.println("Exception occurred when providing the option");
            ioe.printStackTrace();
        }

        return enteredLetter;
    }

    /**
     * Stores the repository and the employee manager when receiving the first order from the client
     * in case any other orders appear.
     * @param repository - same repository with the one from @getOrder
     * @param employeeManager - same manager with the one from @getOrder
     */
    private void rememberEntitiesForOtherOrders(ChairRepository repository, EmployeeManager employeeManager){
        this.mChairRepository   = repository;
        this.mEmployeeManager    = employeeManager;
    }

    @Override
    public void checkForOtherOrders() {
        System.out.print("\nAny other orders?[y/n]:");
        switch(getOptions()){
            case 'y':
                getOrder(mChairRepository, mEmployeeManager);
                break;
            case 'n':
                System.out.println("\nGoodbye\n");
                break;
            default:
                System.out.println("\n\nWrong input\n\n");
        }
    }
}
