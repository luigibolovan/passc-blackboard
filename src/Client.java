import factory.FurnitureFactory;
import factory.employeeManager.DefaultEmployeeManager;
import factory.ordersManager.DefaultOrderManager;
import factory.repository.ChairRepository;

/**
 * @author Luigi Bolovan
 *
 * Client class used to order chairs
 */
public class Client {

    public static void main(String[] args){
        FurnitureFactory myFactory = new FurnitureFactory(new ChairRepository(), new DefaultEmployeeManager(), new DefaultOrderManager());
        myFactory.order();
    }
}
