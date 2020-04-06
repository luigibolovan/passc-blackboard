package products;

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
//        return mHasSeat && mHasStabilizer && mHasBackrest && mHasFeet;
        if(hasSeat() && hasBackrest() && hasFeet() && hasStabilizer()){
            return true;
        }else{
            return false;
        }
    }
}
