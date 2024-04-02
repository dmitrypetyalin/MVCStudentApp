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
    //    private iGetModel model;
    private final iGetView view;
    private List<iGetModel> models;
    private List<Student> buffer = new ArrayList<>();

    public ControllerClass(iGetView view, iGetModel model) {
        this.models = new ArrayList<>();
        this.models.add(model);
        this.view = view;
    }

    public ControllerClass(List<iGetModel> models, iGetView view) {
        this.view = view;
        this.models = models;
    }

    private boolean testData(List<Student> students) {
        return !students.isEmpty();
    }

    public void update() {
        //MVC
        //view.printAllStudents(model.getAllStudents());

        //MVP
        buffer = models.get(0).getAllStudents();

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
                    for (iGetModel model : models) {
                        view.printAllStudents(model.getAllStudents());
                    }
                    break;

                case FIND:
                    try {
                        int id = Integer.parseInt(String.valueOf(view.prompt("Введите номер студента: ")));
                        Student student = null;
                        for (iGetModel model : models) {
                            student = model.find(id);
                            if (student != null)
                                break;
                        }
                        System.out.println(student == null ? "Студент не найден!" : student + " was found");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Некорректное значение");
                    }
                    break;

                case DELETE:
                    try {
                        int id = Integer.parseInt(String.valueOf(view.prompt("Введите номер студента: ")));
                        Student student = null;
                        for (iGetModel model : models) {
                            student = model.delete(id);
                            if (student != null)
                                break;
                        }
                        System.out.println(student == null ? "Студент не найден!" : student + " was deleted");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Некорректное значение");
                    }
                    break;
            }
        }
    }
}
