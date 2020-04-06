package assemblers;


import products.ChairInProgress;
import products.DefaultChairInProgress;

public class BackrestAssembler extends Assembler {

    @Override
    public void attachPiece() {
//        for(ChairInProgress chair : mBlackboard.getChairsInProgress()){
//            if(chair instanceof DefaultChairInProgress){
//                if(((DefaultChairInProgress) chair).hasBackrest() == false) {
//                    System.out.println("Backrest assembler: Adding backrest");
//                    ((DefaultChairInProgress)chair).setBackrest();
//                }
//            }
//        }
        int chairIndex = 0;

        while(chairIndex < mBlackboard.getChairsInProgress().size()){
//            mMutexLock.lock();
            ChairInProgress currentChair = mBlackboard.getChairsInProgress().get(chairIndex);
//            mMutexLock.unlock();
            if(currentChair instanceof DefaultChairInProgress) {
                if (currentChair.hasSeat() && !((DefaultChairInProgress) currentChair).hasBackrest()) {
                    for(int i = 0; i < 1000000; i++);
                    ((DefaultChairInProgress) currentChair).setBackrest();

                }
            }
            chairIndex++;

            if(chairIndex == mBlackboard.getChairsInProgress().size()){
                chairIndex = 0;
            }
        }

    }

}
