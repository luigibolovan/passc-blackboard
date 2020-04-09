package factory.employeeManager;

import factory.repository.ChairRepository;
import factory.ordersManager.OrdersManager;

/**
 * @author Luigi Bolovan
 *
 * Employee Manager interface.
 */
public interface EmployeeManager {
    void stop();
    void init(ChairRepository repository);
    void setOrdersManager(OrdersManager ordersManager);
}
