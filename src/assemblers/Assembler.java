package assemblers;

import blackboards.Blackboard;

import java.util.concurrent.locks.ReentrantLock;

abstract public class Assembler {
    protected Blackboard    mBlackboard;
    protected ReentrantLock mMutexLock;

    public void setBlackboard(Blackboard blackboard){
        this.mBlackboard = blackboard;
    }
    public abstract void attachPiece();
}
