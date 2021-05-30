import dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final int CREATE = 1;
    private static final int GET_BY_NAME = 2;
    private static final int GET_ALL = 3;
    private static final int DELETE_BY_NAME = 4;
    private static final int SAVE = 5;
    private static final int EXIT = 6;
    private static final List<Integer> ALL_COMMANDS = Arrays.asList(CREATE, GET_BY_NAME, GET_ALL, DELETE_BY_NAME, SAVE, EXIT);

    private static int currentId = 0;
    private static List<EmployeeDTO> employees = new ArrayList<>();
    private static Object EmployeeDTO;

    public static void main(String[] args) {
        printGreeting();
        Scanner scanner = new Scanner(System.in);

        MAIN_LOOP: while (true) {
            printCommands();
            int command = Integer.parseInt(scanner.nextLine());

            if (isCorrectCommand(command)) {
                switch (command) {
                    case CREATE:
                        create(scanner);
                        break;
                    case GET_BY_NAME:
                        getByName(scanner);
                        break;
                    case GET_ALL:
                        getAll();
                        break;
                    case DELETE_BY_NAME:
                        deleteByName(scanner);
                        break;
                    case SAVE:
                        save();
                        break;
                    case EXIT:
                        break MAIN_LOOP;
                }
            } else {
                System.out.println("Вы ввели неправильную команду: " + command);
            }
        }

        scanner.close();
    }

    private static void create(Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите департамент: ");
        String department = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());

        EmployeeDTO employeeDTO = new EmployeeDTO(++currentId, name, department, age);
        employees.add(employeeDTO);
        System.out.println("Сотрудник с именем " + employeeDTO.getName() + " создан");
    }

    private static void getByName(Scanner scanner) {
        System.out.print("Введите имя сотрудника: ");
        String name = scanner.nextLine();
        EmployeeDTO result = null;
        for (EmployeeDTO employeeDTO : employees) {
            if (employeeDTO.getName().equalsIgnoreCase(name)) {
                result = employeeDTO;
                break;
            }
        }

        if (result != null) {
            System.out.println("Нашел: " + result.getName() + " [" + result.getDepartment() + "]");
        } else {
            System.out.println("Не найдено");
        }
    }

    private static void getAll() {
        if (employees.isEmpty())
            System.out.println("Пусто");
        else
            System.out.println(employees);
    }

    private static void deleteByName(Scanner scanner) {
        System.out.print("Введите имя : ");
        String name = scanner.nextLine();
        EmployeeDTO result = null;
        for (EmployeeDTO employeeDTO : employees) {
            if (employeeDTO.getName().equalsIgnoreCase(name)) {
                result = employeeDTO;
                break;
            }
        }

        if (result != null) {
            employees.remove(result);
            System.out.println("Удалил: " + result.getName());

        } else {
            System.out.println("Не найдено");
        }


    }

    private static void save() {

    }

    private static boolean isCorrectCommand(int command) {
        return ALL_COMMANDS.contains(command);
    }

    private static void printCommands() {
        System.out.println("Введите команду чтобы начать работать: ");
        System.out.println("\t1 - чтобы создать сотрудника");
        System.out.println("\t2 - чтобы вывести сотрудника по имени");
        System.out.println("\t3 - чтобы вывести список всех сотрудников");
        System.out.println("\t4 - чтобы удалить сотрудника по имени");
        System.out.println("\t5 - сохранить");
        System.out.println("\t6 - завершить программу");
        System.out.print("Ввод: ");
    }

    private static void printGreeting() {
        System.out.println("Добро пожаловать в систему EMS");
    }
}