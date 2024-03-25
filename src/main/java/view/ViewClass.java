package view;

import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * @author PetSoft
 * @date 25.03.2024 22:13
 */
public class ViewClass implements iGetView {
    public void printAllStudents(List<Student> students) {
        System.out.println("------------------- Список студентов ---------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------------------------");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }
}
