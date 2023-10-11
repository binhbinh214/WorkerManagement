package controller;

import java.util.List;

import model.SalaryHistory;
import model.Worker;
import model.WorkerDatabase;

public class WorkerController {
    private WorkerDatabase database;

    public WorkerController() {
        this.database = new WorkerDatabase();
    }

    public boolean addWorker(String id, String name, int age, double salary, String workLocation) {
        Worker worker = new Worker(id, name, age, salary, workLocation);
        return database.addWorker(worker);
    }

    public boolean increaseSalary(String workerId, double amount) {
        return database.changeSalary(workerId, +amount);
    }

    public boolean decreaseSalary(String workerId, double amount) {
        return database.changeSalary(workerId, -amount);
    }

    public List<SalaryHistory> showAdjustedSalaryHistory() {
        return database.getInformationSalary();
    }
}
