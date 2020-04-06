package assemblers;

import products.ChairInProgress;

public class StabilizerBarAssembler extends Assembler {
    @Override
    public void attachPiece() {
//        for(ChairInProgress chair : mBlackboard.getChairsInProgress()){
//            if(chair.hasStabilizer() == false){
//                System.out.println("Stabilizer assembler: Adding stabilizer");
//                chair.setStabilizer();
//            }
//        }
        int chairIndex = 0;

        while(chairIndex < mBlackboard.getChairsInProgress().size()) {
//            mMutexLock.lock();
            ChairInProgress currentChair = mBlackboard.getChairsInProgress().get(chairIndex);
//            mMutexLock.unlock();
            if (currentChair.hasFeet() && !currentChair.hasStabilizer()) {
                for(int i = 0; i < 500000; i++);
                currentChair.setStabilizer();
            }
            chairIndex++;
            if (chairIndex == mBlackboard.getChairsInProgress().size()) {
                chairIndex = 0;
            }
        }
    }
}
