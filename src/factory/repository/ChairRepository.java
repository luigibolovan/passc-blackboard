package factory.repository;

import java.util.ArrayList;
import factory.products.ChairInProgress;
import factory.products.DefaultChairInProgress;
import factory.products.NoBackrestChairInProgress;

/**
 * @author Luigi Bolovan
 *
 * Repository class
 * Passive data store for knowledge sources(assemblers and packer).
 */
public class ChairRepository {
    private int defaultChairInProgressCounter;
    private int noBackrestChairInProgressCounter;

    private ArrayList<ChairInProgress> chairsInProgress = new ArrayList<>();

    public int getNoOfDefaultChairsInProgress(){
        return defaultChairInProgressCounter;
    }
    public int getNumberOfNoBackrestChairsInProgress(){
       return noBackrestChairInProgressCounter;
    }
    public ArrayList<ChairInProgress> getChairsInProgress(){
        return chairsInProgress;
    }

    public void deleteChair(ChairInProgress chair){
        chairsInProgress.remove(chair);
        chairsInProgress.trimToSize();
    }

    public void addChair(ChairInProgress chair){
        chairsInProgress.add(chair);
        if(chair instanceof DefaultChairInProgress){
            this.defaultChairInProgressCounter++;
        }
        if(chair instanceof NoBackrestChairInProgress){
            this.noBackrestChairInProgressCounter++;
        }
    }

    public synchronized ChairInProgress getChairAt(int index){ return this.chairsInProgress.get(index); }
}
