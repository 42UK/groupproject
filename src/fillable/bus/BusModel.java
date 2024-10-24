package src.fillable.bus;

public enum BusModel {
    TOYOTA("Toyota"),
    MAN("Man"),
    VOLKSWAGEN("Volkswagen");

    private String modelName;

    BusModel(String modelName) {
        this.modelName = modelName;
    }
}
