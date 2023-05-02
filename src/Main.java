import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        startMenu();
    }

    public static class MobilePhone {
        private String model;
        private ArrayList<Component> components = new ArrayList<>();

        public void addComponent(String name, String purpose, String properties) {
            Component newComponent = new Component(name, purpose, properties);
            components.add(newComponent);
        }

        public void addModel(String model) {
            this.model = model;
        }

        public void printComponents() {
            String model = this.model != null ? this.model : "not defined";
            System.out.println("Компоненти телефону " + model + ":");
            for (Component component : components) {
                System.out.println(component.toString());
            }
        }

        public void searchComponent(String componentName) {
            for (Component component : components) {
                if (component.getName().equalsIgnoreCase(componentName)) {
                    System.out.println("Component found:");
                    System.out.println(component.toString());
                    return;
                }

                System.out.println("Component not found.");
            }
        }

        public static class Component {
            private String name;
            private String purpose;
            private String properties;

            public Component(String name, String purpose, String properties) {
                this.name = name;
                this.purpose = purpose;
                this.properties = properties;
            }

            public String getName() {
                return name;
            }

            public String toString() {
                return "Component name: " + name + "\n" +
                        "Component purpose: " + purpose + "\n" +
                        "Component properties: " + properties + "\n" ;
            }
        }
    }

    static void startMenu() {
        Scanner scanner = new Scanner(System.in);
        MobilePhone mobilePhone = new MobilePhone();
        int choice = 0;
        do {
            System.out.println("Меню:");
            System.out.println("1. Додати телефон");
            System.out.println("2. Додати компонент");
            System.out.println("3. Пошук за назвою");
            System.out.println("4. Показати інформацію про телефон");
            System.out.println("5. Вихід");
            System.out.print("Ваш вибір: ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Неправильний формат вводу, спробуйте ще раз.");
                scanner.next();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Введіть модель телефону:");
                    String model = scanner.next();
                    mobilePhone.addModel(model);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Введіть назву компонента:");
                    String name = scanner.nextLine();
                    System.out.println("Введіть призначення компонента:");
                    String purpose = scanner.nextLine();
                    System.out.println("Введіть властивості компонента:");
                    String properties = scanner.nextLine();

                    mobilePhone.addComponent(name, purpose, properties);
                    System.out.println("Додано");
                    break;
                case 3:
                    System.out.println("Введіть назву компонента:");
                    String searchName = scanner.next();
                    mobilePhone.searchComponent(searchName);
                    break;
                case 4:
                    mobilePhone.printComponents();
                    break;
                case 5:
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Неправильний вибір, спробуйте ще раз.");
            }
        } while (choice != 5);
    }
}