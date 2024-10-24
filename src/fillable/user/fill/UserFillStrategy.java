package src.fillable.user.fill;


import src.fillable.FillStrategy;

public interface UserFillStrategy extends FillStrategy {
    static  UserFillStrategy getUserFillStrategy(CollectionFillStrategy collectionFillStrategy) {
        switch (collectionFillStrategy) {
            case FILE -> {
                return new UserFileFillStrategy();
            }
            case CONSOLE -> {
                return new UserConsoleFillStrategy();
            }
            case RANDOM -> {
                return new UserRandomFillStrategy();
            }
        }
        return new UserRandomFillStrategy();
    }
}