package factory;

import factory.assemblers.*;
import factory.employeeManager.EmployeeManager;
import factory.ordersManager.OrdersManager;
import factory.packers.Packer;
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
 * Receives orders from client and passes them to its managers
 */
public class FurnitureFactory {
    private ChairRepository mChairRepository;
    private EmployeeManager mEmployeeManager;
    private OrdersManager   mOrderManager;

    public FurnitureFactory(ChairRepository currentChairRepository, EmployeeManager employeeManager, OrdersManager orderManager){
        this.mChairRepository   = currentChairRepository;
        this.mEmployeeManager   = employeeManager;
        this.mOrderManager      = orderManager;
    }

    public void setFactoryBlackboard(ChairRepository chairRepository){
        this.mChairRepository = chairRepository;
    }

    public void order() {
        mOrderManager.getOrder(mChairRepository, mEmployeeManager);
    }



}
