package controller;

import controller.interfaces.iGetModel;
import controller.interfaces.iGetView;
import model.domain.Student;

import java.util.*;

/**
 * @author PetSoft
 * @date 25.03.2024 22:03
 */
public class ControllerClass {
    private iGetModel model;
    private iGetView view;
    private List<Student> buffer = new ArrayList<>();

    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean testData(List<Student> students) {
        return !students.isEmpty();
    }

    public void update() {
        //MVC
        //view.printAllStudents(model.getAllStudents());

        //MVP
        buffer = model.getAllStudents();

        if (testData(buffer)) {
            view.printAllStudents(buffer);
        } else {
            System.out.println("Список студентов пуст!");
        }
    }

    public void run() {
        Command com;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    //MVC
                    view.printAllStudents(model.getAllStudents());
                    break;
                case DELETE:
                    try {
                        Student student = model.deleteStudent(Integer.parseInt(String.valueOf(view.prompt("Введите номер студента: "))));
                        System.out.println(student == null ? "Студент не найден!" : student + " was deleted");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Некорректное значение");
                    }
                    break;
            }
        }
    }
}
