package packers;


import blackboards.Blackboard;
import products.ChairInProgress;

/**
 * to be added: -   after the blackboard is empty tell factory to wait for another order
 *                  from the client if there is any
 *
 *              -   create new Chair based on ChairInProgress
 *
 */
public class Packer {
    protected Blackboard mBlackboard;

    public void setBlackBoard(Blackboard blackBoard){
        this.mBlackboard = blackBoard;
    }

    public void pack() {
        int packIndex = 0;
        int packedChairs = 0;
        while(packIndex < mBlackboard.getChairsInProgress().size()){
            ChairInProgress currentChair = mBlackboard.getChairsInProgress().get(packIndex);
            if(currentChair.isAssembled()){
                packedChairs++;
                for(int i = 0; i < 1000000; i++);
                System.out.println("Chair assembled");
            }
            packIndex++;
            if(packedChairs == mBlackboard.getChairsInProgress().size()){
                break;
            }
            if(packIndex == mBlackboard.getChairsInProgress().size() && packedChairs < mBlackboard.getChairsInProgress().size()){
                packIndex = 0;
            }
        }
        mBlackboard.stop();
    }
}
