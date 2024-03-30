package view;

import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * @author PetSoft
 * @date 28.03.2024 21:25
 */
public class ViewClassEng implements iGetView {
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------------- List of students ---------------------------");
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
