package src.fillable.student.fill;


import src.fillable.FillStrategy;

public interface StudentFillStrategy extends FillStrategy {

    static StudentFillStrategy getStudentFillStrategy(CollectionFillStrategy collectionFillStrategy) {
        switch (collectionFillStrategy) {
            case FILE -> {
                return new StudentFileFillStrategy();
            }
            case CONSOLE -> {
                return new StudentConsoleFillStrategy();
            }
            case RANDOM -> {
                return new StudentRandomFillStrategy();
            }
        }
        return new StudentRandomFillStrategy();
    }
}
