import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String title) {
        tasks.add(new Task(title));
        System.out.println("Task added successfully.");
    }

    public void markTaskAsCompleted(int taskId) {
        if (taskId > 0 && taskId <= tasks.size()) {
            tasks.get(taskId - 1).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task ID.");
        }
    }

    public void listTasks(boolean showCompleted) {
        System.out.println(showCompleted ? "Completed Tasks:" : "Pending Tasks:");
        int count = 0;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.isCompleted() == showCompleted) {
                System.out.println((i + 1) + ". " + task);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No tasks found.");
        }
    }
}
