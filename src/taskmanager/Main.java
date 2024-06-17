package taskmanager;

import taskmanager.model.Task;
import taskmanager.model.Aufgaben;
import taskmanager.model.MeetingTask;
import taskmanager.io.FileManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private ArrayList<Task> tasks; // ArrayList mit Aufgaben

    public Main() {
        tasks = FileManager.loadTasks(); // Aufgaben aus Datei laden
    }

    // Aufgabe hinzufügen
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Aufgaben anzeigen
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Keine Aufgaben verfügbar.");
            return;
        }

        // Sortiere Aufgaben nach Fälligkeitsdatum und Priorität
        /* Die Aufgaben werden nach ihrem Fälligkeitsdatum sortiert. Wenn zwei Aufgaben dasselbe Fälligkeitsdatum haben, werden sie nach ihrer Priorität sortiert.
        Comparator.comparing(Task::getDueDate) erstellt einen Vergleichsoperator für das Fälligkeitsdatum.
        thenComparing(Task::getPriority) fügt eine sekundäre Sortierung nach Priorität hinzu.*/
        Collections.sort(tasks, Comparator.comparing(Task::getDueDate).thenComparing(Task::getPriority));

        /*Das Programm durchläuft die tasks-Liste und gibt jede Aufgabe aus.
Jede Aufgabe wird mit ihrer Position in der Liste (beginnend bei 1) und ihrer stringbasierten Darstellung ausgegeben.
tasks.get(i) gibt die Aufgabe an der Position i in der Liste zurück.
Die Methode toString() wird für jede Aufgabe aufgerufen, um ihre Details anzuzeigen */

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
            System.out.println("-----------------------");
        }
    }

    // Aufgabe löschen
    public void deleteTask(int index) {
        if (index < 1 || index > tasks.size()) { // Überprüft, ob der angegebene Index gültig ist.
            System.out.println("Ungültiger Index. Bitte versuchen Sie es erneut.");
            return;
        }
        /*
        Die Aufgabe wird aus der tasks-Liste entfernt.
Der Index wird um 1 verringert, um die 0-basierte Indexierung der Liste zu berücksichtigen.
Eine Bestätigungsmeldung wird ausgegeben, dass die Aufgabe erfolgreich gelöscht wurde.
         */
        tasks.remove(index - 1); // Entfernt die Aufgabe aus der Liste (1-basiert auf 0-basiert).
        System.out.println("Aufgabe erfolgreich gelöscht.");
    }

    public static void main(String[] args) {
        Main taskManager = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAufgabenmanager-Menü:");
            System.out.println("1. Aufgaben hinzufügen");
            System.out.println("2. Meetings hinzufügen");
            System.out.println("3. Aufgaben anzeigen");
            System.out.println("4. Aufgaben speichern");
            System.out.println("5. Aufgabe löschen");
            System.out.println("6. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch konsumieren

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie den Titel der Aufgabe ein: ");
                    String homeworkTitle = scanner.nextLine();
                    System.out.print("Geben Sie die Beschreibung der Aufgabe ein: ");
                    String homeworkDescription = scanner.nextLine();
                    System.out.print("Geben Sie das Fälligkeitsdatum ein: ");
                    String homeworkDueDate = scanner.nextLine();
                    System.out.print("Geben Sie die Priorität ein (1-5): ");
                    int homeworkPriority = scanner.nextInt();
                    scanner.nextLine();
                    Task homeworkTask = new Aufgaben(homeworkTitle, homeworkDescription, homeworkDueDate, homeworkPriority);
                    taskManager.addTask(homeworkTask);
                    System.out.println("Aufgabe erfolgreich hinzugefügt.");
                    break;
                case 2:
                    System.out.print("Geben Sie den Titel der Besprechung ein: ");
                    String meetingTitle = scanner.nextLine();
                    System.out.print("Geben Sie die Beschreibung der Besprechung ein: ");
                    String meetingDescription = scanner.nextLine();
                    System.out.print("Geben Sie das Fälligkeitsdatum ein: ");
                    String meetingDueDate = scanner.nextLine();
                    System.out.print("Geben Sie die Priorität ein (1-5): ");
                    int meetingPriority = scanner.nextInt();
                    scanner.nextLine();
                    Task meetingTask = new MeetingTask(meetingTitle, meetingDescription, meetingDueDate, meetingPriority);
                    taskManager.addTask(meetingTask);
                    System.out.println("Besprechung erfolgreich hinzugefügt.");
                    break;
                case 3:
                    System.out.println("\n--- Aufgabenliste ---");
                    taskManager.displayTasks();
                    break;
                case 4:
                    FileManager.saveTasks(taskManager.tasks);
                    break;
                case 5:
                    System.out.print("Geben Sie die Nummer der zu löschenden Aufgabe ein: ");
                    int index = scanner.nextInt();
                    taskManager.deleteTask(index);
                    break;
                case 6:
                    System.out.println("Aufgabenmanager wird beendet. Auf Wiedersehen!");
                    System.exit(0);
                default:
                    System.out.println("Ungültige Wahl. Bitte versuchen Sie es erneut.");
            }
        }
    }
}
