package src;

import src.entity.Bus;
import src.entity.Student;
import src.entity.User;
import src.util.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String RED = "\u001B[31m";
    static final String BLUE = "\u001B[34m";
    static final String RESET = "\u001B[0m"; // Сброс цвета
    static boolean running = true;
    static boolean loop = true;
    static int choise;
    static int method;
    static int size;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            while (true) {
                System.out.println(BLUE + "сколько будет объектов" + RESET);
                String input = scanner.nextLine();
                try {
                    size = Integer.parseInt(input);
                    if (size < 1) {
                        System.out.println(RED + "введите число > 0. Попробуйте снова." + RESET);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Некорректный ввод. Пожалуйста, введите целое число." + RESET);
                }

            }

            while (true) {
                System.out.println(BLUE + "какие будут объекты" + RESET);
                System.out.println("1 - Автобусы");
                System.out.println("2 - Пользователи");
                System.out.println("3 - Студенты");
                System.out.println(BLUE + "0" + RESET + " - чтобы завершить работу программы нажмите");
                String input = scanner.nextLine();

                try {
                    choise = Integer.parseInt(input);
                    if (choise == 0) {
                        System.out.println(BLUE + "Вы нажали выход!!!" + RESET);
                        running = false;
                        break;
                    } else if (choise < 0 || choise > 3) {
                        System.out.println(RED + "Ошибка ввода. Попробуйте снова." + RESET);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED + "Ошибка ввода. введите целое число." + RESET);
                }
            }

            while (loop && running) {
                System.out.println(BLUE + "как будем заполнять массив?" + RESET);
                System.out.println("1 - читать из файла");
                System.out.println("2 - создавать вручную");
                System.out.println("3 - создавать рандомно");
                System.out.println(BLUE + "0" + RESET + " - выберите чтобы завершить работу программы");
                String input = scanner.nextLine();

                try {
                    method = Integer.parseInt(input);
                    if (method == 0) {
                        System.out.println(BLUE + "Вы нажали выход!!!" + RESET);
                        running = false;
                        break;
                    } else if (method < 0 || method > 4) {
                        System.out.println(RED + "введите число от 0 до 4" + RESET);
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(RED + "ошибка ввода. введите целое число." + RESET);
                }

            } //loop&&running

            switch (method) {
                case 1:
                    System.out.println(choise); // хранит в себе какими объектами оперируем
                    System.out.println(method); //хранит выбор - как мы будем заполнять
                    System.out.println(size); // переменная количества
                    /* ЧИТАТЬ ИЗ ФАЙЛА

                    какая то логика чтения из файла
                    // ЧИТАТЬ ИЗ ФАЙЛА
                    //создаем массив размера сайз
                    //генерируем объекты выбранного класса
                    //если файла нет - создаем его
                    //и закачиваем в файл если он пустой
                    //затем читаем из файла

                    */
                case 2:
                    if (choise == 1) { //Bus
                    String path = "src/data";
                    String busFileName = "busFile.txt";

                    ReadWrite.makeFile(path, busFileName);
                    List<Bus> busList = new ArrayList<>();

                    while (size > 0) {
                        //Bus
                        System.out.println(BLUE + "введите номер автобуса" + RESET);
                        String num = scanner.nextLine();
                        System.out.println(BLUE + "введите модель автобуса" + RESET);
                        String model = scanner.nextLine();
                        while (true) {
                            System.out.println(BLUE + "введите пробег автобуса" + RESET);
                            String input = scanner.nextLine();
                            try {
                                int mil = Integer.parseInt(input);
                                if (mil < 0) {
                                    System.out.println(RED + "Ошибка ввода. Попробуйте снова." + RESET);
                                } else {
                                    busList.add(new Bus.Builder()
                                            .setNumber(num).setModel(model).setMileage(mil).build());
                                    size--;
                                    System.out.println("осталось ввести элементов - " + size);
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println(RED + "Некорректный ввод. используйте целые числа." + RESET);
                            }
                        }
                    }
                    System.out.println(busList);
                    running = false;
                    break;
                } else if (choise == 2) {
                    //User создаем юзеров руками
                    String path = "src/data";
                    String userFileName = "userFile.txt";

                    ReadWrite.makeFile(path, userFileName);
                    List<User> userList = new ArrayList<>();

                    while (size > 0) {
                        //добавить сюда проверку на числа в имени --- маску
                        System.out.println("введите имя пользователя");
                        String name = scanner.nextLine();

                        System.out.println("введите пароль");
                        String pass = scanner.nextLine();

                        //добавить сюда проверку на маску почты
                        System.out.println("введите email");
                        String mail = scanner.nextLine();
                        userList.add(new User.Builder()
                                .setName(name).setPassword(pass).setEmail(mail).build());
                        size--;
                        System.out.println("осталось ввести элементов - " + size);
                    }
                    System.out.println(userList);
                    running = false;
                    break;
                } else if (choise == 3) {
                    //Students создаем студентов руками
                    String path = "src/data";
                    String userFileName = "studentFile.txt";
                    ReadWrite.makeFile(path, userFileName);
                    List<Student> studentList = new ArrayList<>();

                    System.out.println("введите группу студента");
                    String stGroup = scanner.nextLine();
                    System.out.println("введите номер зачетки студента");
                    String recBookNum = scanner.nextLine();

                    while (true) {
                        System.out.println("введите средний балл студента");
                        String input = scanner.nextLine();
                        try{
                            double averScore = Double.parseDouble(input);
                            if (averScore < 0.0) {
                                System.out.println(RED + "Ошибка ввода. Попробуйте снова." + RESET);
                            } else {
                                studentList.add(new Student.Builder()
                                        .setGroupNumber(stGroup).setRecordBookNumber(recBookNum).setAverageScore(averScore).build());
                                size--;
                                System.out.println("осталось ввести элементов - " + size);
                                break;
                            }
                        }catch (NumberFormatException e) {
                            System.out.println(RED + "Некорректный ввод. используйте целые числа." + RESET);
                        }
                    }
                    System.out.println(studentList);
                }
                running = false;
                    break;
                case 3:
                    /*
                    *
                    *            ЛОГИКА по созданию  рандомно
                    *
                    *
                     */
                default:
                    System.out.println(RED + "Ошибка ввода. Попробуйте еще" + RESET);
            }//свич
        }
    }
}
