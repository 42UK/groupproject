package src.fillable;


import src.fillable.bus.Bus;
import src.fillable.bus.fill.BusFillStrategy;
import src.fillable.student.Student;
import src.fillable.student.fill.StudentFillStrategy;
import src.fillable.user.User;
import src.fillable.user.fill.UserFillStrategy;

import java.util.List;

public interface FillStrategy {
    List fill(int cap);

    static FillStrategy getFillStrategy(Class typeParameterClass, CollectionFillStrategy collectionFillStrategy) {
        if (typeParameterClass.equals(Bus.class)) {
            return BusFillStrategy.getBusFillStrategy(collectionFillStrategy);
        } else if (typeParameterClass.equals(Student.class)) {
            return StudentFillStrategy.getStudentFillStrategy(collectionFillStrategy);
        } else if (typeParameterClass.equals(User.class)) {
            return UserFillStrategy.getUserFillStrategy(collectionFillStrategy);
        }
        throw new UnfillableClassException("");
    }

    enum CollectionFillStrategy {
        CONSOLE, FILE, RANDOM;
    }
}
