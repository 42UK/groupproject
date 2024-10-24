package src.fillable.student;

public class Student implements Comparable<Student> {
    private final String groupId;
    private final double avgGrade;
    private final int cardId;

    public static class Builder {

        private String groupId;
        private double avgGrade;
        private int cardId;

        public Builder setCardId(int cardId) {
            this.cardId = cardId;
            return this;
        }

        public Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder setGroupId(double avgGrade) {
            this.avgGrade = avgGrade;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    private Student(Builder builder) {
        this.groupId = builder.groupId;
        this.avgGrade = builder.avgGrade;
        this.cardId = builder.cardId;
    }

    @Override
    public int compareTo(Student other) {
        if (this.avgGrade > other.avgGrade) {
            return 1;
        } else if (this.avgGrade < other.avgGrade) {
            return -1;
        } else {
            return 0;
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public int getCardId() {
        return cardId;
    }
}

