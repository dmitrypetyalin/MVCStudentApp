import controller.ControllerClass;
import controller.interfaces.iGetModel;
import controller.interfaces.iGetView;
import model.domain.ModelClassHash;
import model.domain.Student;
import view.ViewClass;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author PetSoft
 * @date 25.03.2024 22:14
 */
public class App {
    public static void main(String[] args) {
        List<Student> studList = new ArrayList<>(Arrays.asList(new Student("Иван", 21),
                new Student("Анна", 25),
                new Student("Вася", 22),
                new Student("Настя", 27),
                new Student("Василиса", 26),
                new Student("Карина", 25),
                new Student("Андрей", 22),
                new Student("Маша", 27),
                new Student("Ирина", 28),
                new Student("Николай", 30)));

        List<Student> engStudList = new ArrayList<>(Arrays.asList(new Student("Ivan", 21),
                new Student("Anna", 25),
                new Student("Vasya", 22),
                new Student("Nastya", 27),
                new Student("Vasilisa", 26),
                new Student("Karina", 25),
                new Student("Anrey", 22),
                new Student("Masha", 27),
                new Student("Irina", 28),
                new Student("Nikolay", 30)));

//        iGetModel model = new ModelClass(studList);
        iGetView view = new ViewClass();

//        System.out.println("=========================================================");
//        ViewClassEng


//        System.out.println("=========================================================");
//        ModelClassHash

//        Map<Integer, Student> map = studList.stream()
//                .collect(Collectors.toMap(Student::getId, Function.identity()));
//        map.forEach((K, V) -> System.out.println("Id: " + K + ", Student: " + V));
//        System.out.println(map.remove(2));


        iGetModel hashModel = new ModelClassHash(studList.stream()
                .collect(Collectors.toMap(Student::getId, Function.identity())));

        ControllerClass controller2 = new ControllerClass(hashModel, view);

        controller2.run();

    }
}
