import java.util.Scanner;

public class Turma {

    static Scanner scanner = new Scanner(System.in);

    static String[] prisonersFirstNames = new String[100];
    static String[] prisonersLastNames = new String[100];
    static int[] daysUntilRelease = new int[100];
    static int prisonersCount = 0;

    // Статический метод
    public static void main(String[] args) {
        Turma turma = new Turma(); // Создание объекта класса для вызова нестатических методов
        turma.printWelcomeMessage(); // Вызов нестатического метода
    }

    // Нестатический метод
    public void printWelcomeMessage() {
        System.out.println("Добро пожаловать в тюрьму The END!");
        System.out.println("Хотите просмотреть описание тюрьмы? (да/нет)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("да")) {
            printPrisonDescription();
        } else if (choice.equals("нет")) {
            askMainMenuOrExit();
        } else {
            System.out.println("Неверный ввод. Попробуйте еще раз.");
            printWelcomeMessage();
        }
    }

    // Нестатический метод
    public void askMainMenuOrExit() {
        System.out.println("Хотите вернуться в главное меню или выйти из программы? (главное/выход)");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("главное")) {
            mainMenu();
        } else if (choice.equals("выход")) {
            printGoodbyeMessage(); // Вызов статического метода
        } else {
            System.out.println("Неверный ввод. Попробуйте еще раз.");
            askMainMenuOrExit();
        }
    }

    // Нестатический метод
    public void mainMenu() {
        System.out.println("Выберите за кого будет совершен вход:");
        System.out.println("1. Надзиратель");
        System.out.println("2. Заключенный");
        System.out.println("3. Выход из программы");
        int choice = scanner.nextInt();
        switch (choice) {
            case 2:
                viewDaysUntilRelease();
                break;
            case 1:
                managePrisoners();
                break;
            case 3:
                printGoodbyeMessage(); // Вызов статического метода
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте еще раз.");
                mainMenu();
        }
    }

    // Нестатический метод
    public void managePrisoners() {
        System.out.println("Введите фамилию заключенного:");
        String lastName = scanner.next();
        System.out.println("Введите имя заключенного:");
        String firstName = scanner.next();
        System.out.println("Введите количество дней до выхода заключенного:");
        int days = scanner.nextInt();
        prisonersFirstNames[prisonersCount] = firstName;
        prisonersLastNames[prisonersCount] = lastName;
        daysUntilRelease[prisonersCount] = days;
        prisonersCount++;
        System.out.println("Информация о заключенном успешно добавлена.");
        mainMenu();
    }

    // Нестатический метод
    public void viewDaysUntilRelease() {
        System.out.println("Введите вашу фамилию:");
        String lastName = scanner.next();
        System.out.println("Введите ваше имя:");
        String firstName = scanner.next();
        boolean found = findPrisoner(firstName, lastName);
        if (!found) {
            System.out.println("Заключенный не найден. Попробуйте еще раз.");
            viewDaysUntilRelease();
        } else {
            mainMenu();
        }
    }

    // Нестатический метод
    public boolean findPrisoner(String firstName, String lastName) {
        boolean found = false;
        for (int i = 0; i < prisonersCount; i++) {
            if (prisonersFirstNames[i].equalsIgnoreCase(firstName) && prisonersLastNames[i].equalsIgnoreCase(lastName)) {
                found = true;
                System.out.println("До выхода заключенного " + firstName + " " + lastName + " осталось " + daysUntilRelease[i] + " дней.");
                break;
            }
        }
        return found;
    }

    // Нестатический метод
    public void printPrisonDescription() {
        System.out.println("Описание тюрьмы:");
        System.out.println("Тюрьма \"The END\" — современное учреждение с высокими стенами и охраной, где каждый заключенный имеет свою индивидуальную камеру. \n Внутри тюрьмы есть офисы для надзирателей и комнаты для совещаний.  \n Системы безопасности включают видеонаблюдение и биометрическую идентификацию. \n Администрация учреждения стремится к безопасной среде как для заключенных, так и для сотрудников.");
        askMainMenuOrExit();
    }

    // Статический метод
    public static void printGoodbyeMessage() {
        System.out.println("До свидания!");
        System.exit(0);
    }

    // Статический метод
    public static void printInvalidInputMessage() {
        System.out.println("Неверный ввод. Попробуйте еще раз.");
    }
}
