import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String choice = "";
        do
        {
            displayMenu();
            choice = SafeInput.getRegExString(scanner, "Enter your choice: ", "[AaDdPpQq]");
            switch (choice.toUpperCase())
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quitProgram();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!choice.equalsIgnoreCase("Q"));
    }

    private static void displayMenu()
    {
        System.out.println("List Menu");
        System.out.println("===================");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print(Display) the list");
        System.out.println("Q - Quit the program");
        System.out.println();
        System.out.println("Current List:");
        printList();
        System.out.println();
    }

    private static void addItem()
    {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter item to add: ");
        list.add(item);
        System.out.println(item + " has been added to the list.");
    }

    private static void deleteItem()
    {
        if (list.isEmpty())
        {
            System.out.println("The list is empty!");
            return;
        }
        int index = SafeInput.getRangedInt(scanner, "Enter item number to delete: ", 1, list.size());
        String item = list.remove(index - 1);
        System.out.println(item + " has been removed from the list.");
    }

    private static void printList()
    {
        if (list.isEmpty())
        {
            System.out.println("The list is empty!");
            return;
        }
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }

    private static void quitProgram()
    {
        if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit? (Y/N): ")) {
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }
}
