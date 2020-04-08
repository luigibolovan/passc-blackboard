package factory.assemblers;

import factory.products.ChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Feet assembler
 * Searches for chairs in progress within the repository on which it can attach the feet
 */

public class FeetAssembler extends Assembler {
    private final static int FEET_ASSEMBLING_TIME = 4000;

    @Override
    public void attachPiece() {

        int chairIndex = 0;
        int numberOfAssembledChairs = 0;

        while(chairIndex < mChairRepository.getChairsInProgress().size()){
            ChairInProgress currentChair = mChairRepository.getChairAt(chairIndex);
            if(currentChair.hasSeat() && !currentChair.hasFeet()) {
                try{
                    Thread.sleep(FEET_ASSEMBLING_TIME);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

                currentChair.setFeet();
                numberOfAssembledChairs++;
            }

            chairIndex++;
            //my job here is done
            if(numberOfAssembledChairs == mChairRepository.getChairsInProgress().size()){
                break;
            }
            if(chairIndex == mChairRepository.getChairsInProgress().size()){
                chairIndex = 0;
            }
        }

    }
}
