package factory.assemblers;

import factory.repository.ChairRepository;

/**
 * @author Luigi Bolovan
 *
 * Assemblers' base class
 */

abstract public class Assembler {
    protected ChairRepository mChairRepository;

    public void setRepository(ChairRepository chairRepository){
        this.mChairRepository = chairRepository;
    }
    public abstract void attachPiece();
}
