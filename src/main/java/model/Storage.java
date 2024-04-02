package model;

import controller.interfaces.iGetModel;
import model.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author PetSoft
 * @date 31.03.2024 12:18
 */
public class Storage {
    private static Storage instance;
    private static List<iGetModel> rusStudents;
    private static List<iGetModel> engStudents;

    private Storage() {
        rusStudents = new ArrayList<>();
        engStudents = new ArrayList<>();

        rusStudents.add(new ModelClass(new ArrayList<>(Arrays.asList(new Student("Иван", 21),
                new Student("Анна", 25),
                new Student("Вася", 22),
                new Student("Настя", 27),
                new Student("Василиса", 26),
                new Student("Карина", 25),
                new Student("Андрей", 22),
                new Student("Маша", 27),
                new Student("Ирина", 28),
                new Student("Николай", 30)))));

        rusStudents.add(new ModelClass(new ArrayList<>(Arrays.asList(new Student("Сергей", 22),
                new Student("Алёна", 23),
                new Student("Пётр", 24),
                new Student("Оксана", 28),
                new Student("Валентина", 25),
                new Student("Екатерина", 23),
                new Student("Алексей", 23),
                new Student("Мария", 26),
                new Student("Анжела", 27),
                new Student("Павел", 32)))));

        engStudents.add(new ModelClassHash(new ArrayList<>(Arrays.asList(new Student("Ivan", 21),
                new Student("Anna", 25),
                new Student("Vasya", 22),
                new Student("Nastya", 27),
                new Student("Vasilisa", 26),
                new Student("Karina", 25),
                new Student("Anrey", 22),
                new Student("Masha", 27),
                new Student("Irina", 28),
                new Student("Nikolay", 30))).stream()
                .collect(Collectors.toMap(Student::getId, Function.identity()))));

        engStudents.add(new ModelClassHash(new ArrayList<>(Arrays.asList(new Student("Sergey", 22),
                new Student("Alena", 23),
                new Student("Petr", 24),
                new Student("Oksana", 28),
                new Student("Valentina", 25),
                new Student("Ekaterina", 23),
                new Student("Alexey", 23),
                new Student("Maria", 26),
                new Student("Angela", 27),
                new Student("Pavel", 32))).stream()
                .collect(Collectors.toMap(Student::getId, Function.identity()))));
    }

    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<iGetModel> getRusStudents() {
        return rusStudents;
    }

    public List<iGetModel> getEngStudents() {
        return engStudents;
    }
}
