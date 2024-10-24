package src.fillable.bus.fill;


import src.fillable.FillStrategy;

public interface BusFillStrategy extends FillStrategy {

    static BusFillStrategy getBusFillStrategy(CollectionFillStrategy collectionFillStrategy) {
        switch (collectionFillStrategy) {
            case FILE -> {
                return new BusFileFillStrategy();
            }
            case CONSOLE -> {
                return new BusConsoleFillStrategy();
            }
            case RANDOM -> {
                return new BusRandomFillStrategy();
            }
        }
        return new BusRandomFillStrategy();
    }
}
