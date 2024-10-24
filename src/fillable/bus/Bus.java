package src.fillable.bus;

public class Bus implements Comparable<Bus> {
    private final String licensePlate;
    private final BusModel model;
    private final int mileage;

    public static class Builder {
        private String licensePlate;
        private BusModel model;
        private int mileage;

        public Builder(String licensePlate, BusModel model) {
            this.licensePlate = licensePlate;
            this.model = model;
        }

        public Builder withMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(this);
        }
    }

    private Bus(Builder builder) {
        this.licensePlate = builder.licensePlate;
        this.model = builder.model;
        this.mileage = builder.mileage;
    }

    @Override
    public int compareTo(Bus other) {
        return Integer.compare(mileage, other.mileage);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public BusModel getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }
}

