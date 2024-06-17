package taskmanager.model;

// Klasse Aufgaben, die Task erweitert und die display-Methode implementiert
public class Aufgaben extends Task {
    public Aufgaben(String title, String description, String dueDate, int priority) {
        super(title, description, dueDate, priority);
    }


    @Override
    public void display() {
        System.out.println("Aufgabe:");
        System.out.println(super.toString());
    }
}
