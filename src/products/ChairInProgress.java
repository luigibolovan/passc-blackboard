package products;

abstract public class ChairInProgress {
    protected boolean mHasSeat;
    protected boolean mHasFeet;
    protected boolean mHasStabilizer;


    public synchronized void setSeat(){
        System.out.println("Seat cutter: Cutting seat");
        mHasSeat = true;
    }

    public synchronized void setFeet(){
        System.out.println("Feet assembler: Adding feet");
        mHasFeet = true;
    }

    public synchronized void setStabilizer(){
        System.out.println("Stabilizer assembler: Adding stabilizer");
        mHasStabilizer = true;
    }

    public synchronized boolean hasSeat(){ return mHasSeat; }

    public synchronized boolean hasFeet(){
        return mHasFeet;
    }

    public synchronized boolean hasStabilizer(){
        return mHasStabilizer;
    }

    public abstract boolean isAssembled();
}
