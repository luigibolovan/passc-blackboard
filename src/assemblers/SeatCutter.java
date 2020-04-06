package assemblers;

import products.ChairInProgress;

public class SeatCutter extends Assembler {

    @Override
    public void attachPiece() {
        for(ChairInProgress chair : mBlackboard.getChairsInProgress()){
            if(!chair.hasSeat()){

                for(int i = 0; i < 1500000; i++);
                chair.setSeat();
            }
        }
    }
}
