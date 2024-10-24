package src.fillable.user.fill;


import src.fillable.user.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserConsoleFillStrategy implements UserFillStrategy {

    @Override
    public List<User> fill(int cap) {
        List<User> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < cap; i++) {
                User.Builder userBuilder = new User.Builder();
                System.out.println("Введите построчно имя, пароль и email:");
                userBuilder.setName(br.readLine()).setPassword(br.readLine()).setEmail(br.readLine());
                System.out.printf("Вы создадите:\nname = %s\npassword = %s\nemail = %s\nСогласны? y/n\n"
                        , userBuilder.peekName()
                        , userBuilder.peekPassword()
                        , userBuilder.peekEmail());
                if (br.readLine().equals("y")) {
                    User user = userBuilder.build();
                    list.add(user);
                    System.out.println("Успешно добавлен пользователь: " + user);
                } else {
                    i--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
