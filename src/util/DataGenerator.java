package src.util;

import net.datafaker.Faker;
import net.datafaker.providers.base.Text;
import src.entity.Bus;
import src.entity.Student;
import src.entity.User;

import java.util.Random;

import static net.datafaker.providers.base.Text.DIGITS;
import static net.datafaker.providers.base.Text.EN_UPPERCASE;

public class DataGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    private static final String[] busModels = {"Model A", "Model B", "Model C"};
    private static final String[] groupNumbers = {"Group 1", "Group 2", "Group 3"};

    public static Bus createRandomBus() {
        String number = "Bus" + faker.number();
        String model = busModels[random.nextInt(busModels.length)];
        int mileage = random.nextInt(100000);
        return new Bus.Builder()
                .setNumber(number)
                .setModel(model)
                .setMileage(mileage)
                .build();
    }

    public static User createRandomUser() {
        String name = faker.name().firstName();
        String email = faker.funnyName().name() + "@example.com";
        Text.TextSymbolsBuilder passwordBuilder = Text.TextSymbolsBuilder.builder()
                .len(8)
                .with(EN_UPPERCASE, random.nextInt(1,4))
                .with(DIGITS, random.nextInt(1,4));
        String password = faker.text().text(passwordBuilder.build());
        return new User.Builder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .build();
    }

    public static Student createRandomStudent() {
        String groupNumber = groupNumbers[random.nextInt(groupNumbers.length)];
        double averageScore = Math.floor(random.nextDouble(2,5) * 100) / 100;
        return new Student.Builder()
                .setGroupNumber(groupNumber)
                .setAverageScore(averageScore)
                .build();
    }
}
