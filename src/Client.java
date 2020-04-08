import factory.FurnitureFactory;
import factory.repository.ChairRepository;

/**
 * @author Luigi Bolovan
 *
 * Client class used to order chairs
 */
public class Client {

    public static void main(String[] args){
        FurnitureFactory myFactory = new FurnitureFactory(new ChairRepository());
        myFactory.order();
    }
}
