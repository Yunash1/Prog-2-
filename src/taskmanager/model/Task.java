package taskmanager.model;

// Abstrakte Klasse Task, die die gemeinsamen Eigenschaften von Aufgaben definiert
public abstract class Task {
    private  String title;
    private String description;
    private String dueDate;
    private int priority;

    // Konstruktor
    public Task(String title, String description, String dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Getter und Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // toString-Methode für die Übersicht der Attributwerte
    /* Diese Methode gibt eine stringbasierte Darstellung der Aufgabe zurück, die Titel, Beschreibung, Fälligkeitsdatum und Priorität enthält. */
    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nDue Date: " + dueDate + "\nPriority: " + priority;
    }

    // Abstrakte Methode zur Anzeige der Aufgabe
    public abstract void display();
}
