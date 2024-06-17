package taskmanager.io;

import taskmanager.model.Task;
import taskmanager.model.Aufgaben;
import taskmanager.model.MeetingTask;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "tasks.txt"; // Konstante für den Dateinamen

    // Methode zum Speichern der Aufgaben in eine Datei
    public static void saveTasks(ArrayList<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println(task.getTitle());
                writer.println(task.getDescription());
                writer.println(task.getDueDate());
                writer.println(task.getPriority());
                writer.println(task instanceof Aufgaben ? "Aufgaben" : "Meeting");
            }
            System.out.println("Aufgaben erfolgreich gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der Aufgaben in die Datei: " + e.getMessage());
        }
    }

    // Methode zum Laden der Aufgaben aus einer Datei
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String title = line;
                String description = reader.readLine();
                String dueDate = reader.readLine();
                int priority = Integer.parseInt(reader.readLine());
                String taskType = reader.readLine();
                if (taskType.equals("Aufgaben")) {
                    loadedTasks.add(new Aufgaben(title, description, dueDate, priority));
                } else {
                    loadedTasks.add(new MeetingTask(title, description, dueDate, priority));
                }
            }
            System.out.println("Aufgaben erfolgreich geladen.");
        } catch (IOException e) {
            System.out.println("Fehler beim Laden der Aufgaben aus der Datei: " + e.getMessage());
        }
        return loadedTasks;
    }
}
