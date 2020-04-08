package factory.repository;

import factory.assemblers.*;
import factory.packers.Packer;
import java.util.ArrayList;
import factory.products.ChairInProgress;
import factory.products.DefaultChairInProgress;
import factory.products.NoBackrestChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Repository class
 * Initalizes and starts the threads for every entity that helps with the chair delivery and holds the chairs in progress
 */
public class ChairRepository {
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
    private int             defaultChairInProgressCounter;
    private int             noBackrestChairInProgressCounter;

    private ArrayList<ChairInProgress> chairsInProgress = new ArrayList<>();

    public int getNoOfDefaultChairsInProgress(){
        return defaultChairInProgressCounter;
    }
    public int getNumberOfNoBackrestChairsInProgress(){
       return noBackrestChairInProgressCounter;
    }
    public ArrayList<ChairInProgress> getChairsInProgress(){
        return chairsInProgress;
    }

    public void deleteChair(ChairInProgress chair){
        chairsInProgress.remove(chair);
    }

    public void addChair(ChairInProgress chair){
        chairsInProgress.add(chair);
        if(chair instanceof DefaultChairInProgress){
            this.defaultChairInProgressCounter++;
        }
        if(chair instanceof NoBackrestChairInProgress){
            this.noBackrestChairInProgressCounter++;
        }
    }

    public synchronized ChairInProgress getChairAt(int index){ return this.chairsInProgress.get(index); }

    public ChairRepository(){
        mSeatCutter             = new SeatCutter();
        mFeetAssembler          = new FeetAssembler();
        mPacker                 = new Packer();
        mBackrestAssembler      = new BackrestAssembler();
        mStabilizerBarAssembler = new StabilizerBarAssembler();
    }

    private void assignRepository(){
        mPacker.setRepository(this);
        mSeatCutter.setRepository(this);
        mFeetAssembler.setRepository(this);
        mBackrestAssembler.setRepository(this);
        mStabilizerBarAssembler.setRepository(this);
    }

    /**
     * create a thread for every "employee" and start it
     */
    public void init(){
        assignRepository();

        System.out.println(".............And employees are cheering as they receive a new task...................");
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


    public void stop(){
        try{
            mSeatJob.join(3000);
            mPackerJob.join(3000);
            mBackrestJob.join(3000);
            mStabilizerJob.join(3000);
            mFeetAssemblerJob.join(3000);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("------------Employees stopped--------------");
    }
}
