package factory.assemblers;

import factory.products.ChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Stabilizer bar assembler
 * It searches for chairs in progress which have feet assembled and no stabilizer bar assembled.
 */

public class StabilizerBarAssembler extends Assembler {
    private static final int STABILIZER_ASSEMBLING_TIME = 2000;

    @Override
    public void attachPiece() {
        int chairIndex = 0;
        int numberOfAssembledChairs = 0;
        while(chairIndex < mChairRepository.getChairsInProgress().size()) {
            ChairInProgress currentChair = mChairRepository.getChairAt(chairIndex);
            if (currentChair.hasFeet() && !currentChair.hasStabilizer()) {
                try{
                    Thread.sleep(STABILIZER_ASSEMBLING_TIME);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

                currentChair.setStabilizer();
                numberOfAssembledChairs++;
            }
            chairIndex++;
            //my job here is done
            if(numberOfAssembledChairs == mChairRepository.getChairsInProgress().size()){
                break;
            }
            if (chairIndex == mChairRepository.getChairsInProgress().size()) {
                chairIndex = 0;
            }
        }
    }
}
