package factory.products;

/**
 * @author Luigi Bolovan
 *
 * No backrest chair class
 * It is considered assembled after feet, seat and stabilizer bar are assembled.
 */

public class NoBackrestChairInProgress extends ChairInProgress {
    @Override
    public synchronized boolean isAssembled() { return mHasFeet && mHasSeat && mHasStabilizer; }
}
