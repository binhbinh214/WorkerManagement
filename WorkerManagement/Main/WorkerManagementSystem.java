package Main;
import controller.WorkerController;
import view.WorkerView;

public class WorkerManagementSystem {
    public static void main(String[] args) {
        WorkerController controller = new WorkerController();
        WorkerView view = new WorkerView(controller);
        view.start();
    }
}