package factory.ordersManager;

import factory.repository.ChairRepository;
import factory.employeeManager.EmployeeManager;

/**
 * @author Luigi Bolovan
 *
 * Interface for receiving orders from client
 */
public interface OrdersManager {
    void    checkForOtherOrders();
    void    getOrder(ChairRepository repository, EmployeeManager employeeManager);
}
