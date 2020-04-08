package factory.products;

/**
 * @author Luigi Bolovan
 *
 * Base class for the in progress chairs.
 *
 * */
abstract public class ChairInProgress {
    protected boolean mHasSeat;
    protected boolean mHasFeet;
    protected boolean mIsPacked;
    protected boolean mHasStabilizer;

    public synchronized void setSeat(){
        System.out.println("Seat cutter: Cutting seat");
        mHasSeat = true;
    }

    public synchronized void makePacked(){
        System.out.println("Chair packed");
        mIsPacked = true;
    }

    public synchronized void setFeet(){
        System.out.println("Feet assembler: Adding feet");
        mHasFeet = true;
    }

    public synchronized void setStabilizer(){
        System.out.println("Stabilizer assembler: Adding stabilizer");
        mHasStabilizer = true;
    }

    public synchronized boolean hasSeat(){
        return mHasSeat;
    }

    public synchronized boolean hasFeet(){
        return mHasFeet;
    }

    public synchronized boolean isPacked(){
        return mIsPacked;
    }

    public synchronized boolean hasStabilizer(){
        return mHasStabilizer;
    }

    public abstract boolean isAssembled();
}
