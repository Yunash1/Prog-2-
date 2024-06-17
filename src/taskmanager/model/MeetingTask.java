package taskmanager.model;

public class MeetingTask extends Task {
    public MeetingTask(String title, String description, String dueDate, int priority) {
        super(title, description, dueDate, priority);
    }

    @Override
    public void display() {
        System.out.println("Meetings:");
        System.out.println(super.toString());
    }
}
