package factory.packers;

import factory.employeeManager.EmployeeManager;
import factory.repository.ChairRepository;
import factory.products.ChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Packs the assembled chairs from the repository
 */

public class Packer {
    protected ChairRepository mChairRepository;
    private   EmployeeManager mEmployeeManager;
    private final static int PACK_TIME = 1000;


    public Packer(EmployeeManager employeeManager){
        this.mEmployeeManager = employeeManager;
    }

    public void setRepository(ChairRepository blackBoard){
        this.mChairRepository = blackBoard;
    }

    public void pack() {
        int packIndex = 0;
        int noOfPackedChairs = 0;
        while (packIndex < mChairRepository.getChairsInProgress().size()) {
            ChairInProgress currentChair = mChairRepository.getChairAt(packIndex);
            if (currentChair.isAssembled() && !currentChair.isPacked()) {
                noOfPackedChairs++;

                try{
                    Thread.sleep(PACK_TIME);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }

                currentChair.makePacked();
            }
            packIndex++;
            //my job here is done
            if (noOfPackedChairs == mChairRepository.getChairsInProgress().size()) {
                break;
            }
            if (packIndex == mChairRepository.getChairsInProgress().size() && noOfPackedChairs < mChairRepository.getChairsInProgress().size()) {
                packIndex = 0;
            }
        }

        while(noOfPackedChairs > 0) {
            mChairRepository.deleteChair(mChairRepository.getChairAt(noOfPackedChairs - 1));
            noOfPackedChairs--;
        }

        mEmployeeManager.stop();
    }
}
