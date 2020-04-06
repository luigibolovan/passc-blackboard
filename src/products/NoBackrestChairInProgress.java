package products;

public class NoBackrestChairInProgress extends ChairInProgress {
    @Override
    public boolean isAssembled() { return mHasFeet && mHasSeat && mHasStabilizer; }
}
