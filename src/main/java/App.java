import controller.ControllerClass;
import controller.Language;
import controller.interfaces.iGetView;
import model.Storage;
import view.ViewClass;
import view.ViewClassEng;

/**
 * @author PetSoft
 * @date 25.03.2024 22:14
 */
public class App {
    public static void main(String[] args) {
        iGetView view = new ViewClass();

        Language language = Language.valueOf(view.prompt("Выберите язык (RUS/ENG): ").toUpperCase());

        switch(language) {
            case RUS:
                new ControllerClass(Storage.getInstance().getRusStudents(), view).run();
                break;

            case ENG:
                iGetView viewEng = new ViewClassEng();
                new ControllerClass(Storage.getInstance().getEngStudents(), viewEng).run();
                break;

            default:
                System.out.println("There is no such language in the list!");
                break;
        }
//                Map<Integer, Student> map = studList.stream()
//                .collect(Collectors.toMap(Student::getId, Function.identity()));
//        map.forEach((K, V) -> System.out.println("Id: " + K + ", Student: " + V));
    }
}
