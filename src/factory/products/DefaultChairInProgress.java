package factory.products;

/**
 * @author Luigi Bolovan
 *
 * Default chair in progress
 * Default = chair with backrest
 * It is considered assembled after seat, feet, backrest and stabilizer bar are assembled
 */

public class DefaultChairInProgress extends ChairInProgress {
    private boolean mHasBackrest;

    public synchronized boolean hasBackrest(){
        return mHasBackrest;
    }

    public synchronized void setBackrest(){
        System.out.println("Backrest assembler: Adding backrest");
        mHasBackrest = true;
    }

    @Override
    public synchronized boolean isAssembled(){
        return mHasSeat && mHasStabilizer && mHasBackrest && mHasFeet;
    }
}
