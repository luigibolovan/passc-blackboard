package blackboards;

import assemblers.*;

import java.util.ArrayList;
import packers.Packer;
import products.ChairInProgress;

public class Blackboard{
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

    private ArrayList<ChairInProgress> chairsInProgress = new ArrayList<>();

    public synchronized ArrayList<ChairInProgress> getChairsInProgress(){
        return chairsInProgress;
    }

    public synchronized void deleteChair(ChairInProgress chair){
        chairsInProgress.remove(chair);
    }

    public synchronized boolean isBlackboardEmpty(){
        return chairsInProgress.isEmpty();
    }

    public void addChair(ChairInProgress chair){
        chairsInProgress.add(chair);
    }


    public Blackboard(){
        mSeatCutter             = new SeatCutter();
        mFeetAssembler          = new FeetAssembler();
        mPacker                 = new Packer();
        mBackrestAssembler      = new BackrestAssembler();
        mStabilizerBarAssembler = new StabilizerBarAssembler();
    }

    private void assignThisBlackboardToWorkers(){
        mPacker.setBlackBoard(this);
        mSeatCutter.setBlackboard(this);
        mFeetAssembler.setBlackboard(this);
        mBackrestAssembler.setBlackboard(this);
        mStabilizerBarAssembler.setBlackboard(this);
    }

    public void init(){
        assignThisBlackboardToWorkers();

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
            mSeatJob.join();
            mPackerJob.join();
            mBackrestJob.join();
            mStabilizerJob.join();
            mFeetAssemblerJob.join();
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Employees stopped");
    }
}
