package task_prgm;

import task_prgm.controller.KennelAccounting;
import task_prgm.storage.KennelStorage;
import task_prgm.view.ConsoleView;
import task_prgm.view.View;

public class App {
    /**
     * Основной цикл приложения, где происходит обработка основных команд
     * (добавть животное, показать команды животного, выписать из питомника)
     */
    public static void run() {
        KennelAccounting kennelAccounting = new KennelAccounting(new KennelStorage());
        View view = new ConsoleView(kennelAccounting);

        while (true) {
            view.showKennelRegistry();
            View.MainMenuCommand code = view.showMainMenuWithResult();
            switch (code) {
                case ADD_ANIMAL -> {
                    boolean result = view.showAddAnimalDialog();
                    String resMessage = result ? "Животное добавлено" : "Не удалось добавить животное";
                    System.out.println(resMessage);
                }
                case SHOW_SKILLS -> {
                    view.showDetailInfoAnimalDialog();
                }
                case REMOVE_ANIMAL -> {
                    int removeId = view.showRemoveAnimalDialog();
                    String resMessage = removeId > -1  ? "Выписано животное" + removeId : "Не удалось  выписать животное";
                    System.out.println(resMessage);
                }
                case EXIT -> {
                    System.out.println("See you... )");
                    return;
                }
            }
        }
    }
}
