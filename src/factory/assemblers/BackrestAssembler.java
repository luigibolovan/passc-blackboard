package factory.assemblers;


import factory.products.ChairInProgress;
import factory.products.DefaultChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Backrest assembler class
 * It searches in the repository for chairs in progress on which it can assemble the backrest
 */
public class BackrestAssembler extends Assembler {
    private final static int BACKREST_ASSEMBLING_TIME = 1500;
    @Override
    public void attachPiece() {

        if(mChairRepository.getNoOfDefaultChairsInProgress() == 0){
            //not my business
        }else {
            // gotta work
            int chairIndex = 0;
            int numberOfAssembledChairs = 0;

            while (chairIndex < mChairRepository.getChairsInProgress().size()) {
                ChairInProgress currentChair = mChairRepository.getChairAt(chairIndex);
                if (currentChair instanceof DefaultChairInProgress) {
                    if (currentChair.hasSeat() && !((DefaultChairInProgress) currentChair).hasBackrest()) {
                        try {
                            Thread.sleep(BACKREST_ASSEMBLING_TIME);
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }

                        numberOfAssembledChairs++;
                        ((DefaultChairInProgress) currentChair).setBackrest();

                    }
                }
                chairIndex++;
                //my job here is done
                if (numberOfAssembledChairs == mChairRepository.getNoOfDefaultChairsInProgress()) {
                    break;
                }
                if (chairIndex == mChairRepository.getChairsInProgress().size()) {
                    chairIndex = 0;
                }
            }
        }
    }
}
