package factory.assemblers;

import factory.products.ChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Seat cutter
 * Takes every chair in progress from the repository and cuts a seat for every single one.
 */

public class SeatCutter extends Assembler {
    private final static int SEAT_CUT_TIME = 1000;
    @Override
    public void attachPiece() {
        for(ChairInProgress chair : mChairRepository.getChairsInProgress()){
            if(!chair.hasSeat()){
                try{
                    Thread.sleep(SEAT_CUT_TIME);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

                chair.setSeat();
            }
        }
    }
}
