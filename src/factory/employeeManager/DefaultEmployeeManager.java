package factory.employeeManager;

import factory.assemblers.*;
import factory.packers.Packer;
import factory.repository.ChairRepository;
import factory.ordersManager.OrdersManager;


/**
 * @author Luigi Bolovan
 *
 * Employee manager class.
 * Starts and stops the threads on which every employee is working.
 */
public class DefaultEmployeeManager implements EmployeeManager {
    private Assembler       mStabilizerBarAssembler;
    private Assembler       mBackrestAssembler;
    private Assembler       mFeetAssembler;
    private Assembler       mSeatCutter;
    private Packer          mPacker;
    private Thread          mSeatJob;
    private Thread          mPackerJob;
    private Thread          mBackrestJob;
    private Thread          mStabilizerJob;
    private Thread          mFeetAssemblerJob;

    private OrdersManager   mOrderManager;

    public DefaultEmployeeManager(){
        mPacker                 = new Packer(this);
        mSeatCutter             = new SeatCutter();
        mFeetAssembler          = new FeetAssembler();
        mBackrestAssembler      = new BackrestAssembler();
        mStabilizerBarAssembler = new StabilizerBarAssembler();
    }

    @Override
    public void setOrdersManager(OrdersManager ordersManager) {
        this.mOrderManager = ordersManager;
    }

    /**
     * Creates a thread for every employee to ensure parallelism
     * @param repository - the repository from where the employees shall get the chairs
     */
    @Override
    public void init(ChairRepository repository) {
        mPacker.setRepository(repository);
        mSeatCutter.setRepository(repository);
        mFeetAssembler.setRepository(repository);
        mBackrestAssembler.setRepository(repository);
        mStabilizerBarAssembler.setRepository(repository);

        System.out.println("\n.............And employees are cheering as they receive a new task...................");
        mPackerJob          = new Thread(() -> mPacker.pack());
        mSeatJob            = new Thread(() -> mSeatCutter.attachPiece());
        mFeetAssemblerJob   = new Thread(() -> mFeetAssembler.attachPiece());
        mBackrestJob        = new Thread(() -> mBackrestAssembler.attachPiece());
        mStabilizerJob      = new Thread(() -> mStabilizerBarAssembler.attachPiece());

        mSeatJob.start();
        mBackrestJob.start();
        mStabilizerJob.start();
        mFeetAssemblerJob.start();
        mPackerJob.start();
    }


    /**
     * Stops the threads and then asks the OrdersManager to check if there are other orders
     */
    @Override
    public void stop() {
        try {
            mSeatJob.join(3000);
            mPackerJob.join(3000);
            mBackrestJob.join(3000);
            mStabilizerJob.join(3000);
            mFeetAssemblerJob.join(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------Employees stopped--------------");

        mOrderManager.checkForOtherOrders();
    }
}
