package assemblers;

import products.ChairInProgress;

public class FeetAssembler extends Assembler {

    @Override
    public void attachPiece() {
//        for(ChairInProgress chair : mBlackboard.getChairsInProgress()){
//            if(chair.hasFeet() == false){
//                System.out.println("Feet assembler: Adding feet");
//                chair.setFeet();
//            }
//        }
        int chairIndex = 0;

        while(chairIndex < mBlackboard.getChairsInProgress().size()){
//            mMutexLock.lock();
            ChairInProgress currentChair = mBlackboard.getChairsInProgress().get(chairIndex);
//            mMutexLock.unlock();
            if(currentChair.hasSeat() && !currentChair.hasFeet()) {
                for(int i = 0; i < 2000000; i++);
                currentChair.setFeet();

            }
            chairIndex++;
            if(chairIndex == mBlackboard.getChairsInProgress().size()){
                chairIndex = 0;
            }
        }

    }
}
