import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add at the beginning");
            System.out.println("2. Add at the end");
            System.out.println("3. Add at a specific index");
            System.out.println("4. Remove from the beginning");
            System.out.println("5. Remove from a specific index");
            System.out.println("6. Remove from the end");
            System.out.println("7. Display elements");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the beginning: ");
                    container.AddAtBeginning(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter element to add at the end: ");
                    container.AddAtEnd(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter element to add: ");
                    String element = scanner.nextLine();
                    System.out.print("Enter index to add at: ");
                    int index = scanner.nextInt();
                    container.AddAtIndex(element, index);
                    break;
                case 4:
                    System.out.println("Removed from the beginning: " + container.RemoveAtBeginning());
                    break;
                case 5:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = scanner.nextInt();
                    System.out.println("Removed from index " + removeIndex + ": " + container.RemoveAtIndex(removeIndex));
                    break;
                case 6:
                    System.out.println("Removed from the end: " + container.RemoveAtEnd());
                    break;
                case 7:
                    System.out.println("Elements in the container:");
                    for (int i = 0; i < container.GetSize(); i++) {
                        System.out.println(container.Get(i));
                    }
                    break;
                case 8:
                    System.out.println("Program completed");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }

            System.out.println("Size of the container: " + container.GetSize());
            System.out.println();
        }
    }
}