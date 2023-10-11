package model;

import java.util.ArrayList;
import java.util.List;

public class WorkerDatabase {
    private List<Worker> workers;
    private List<SalaryHistory> salaryHistory;

    public WorkerDatabase() {
        this.workers = new ArrayList<>();
        this.salaryHistory = new ArrayList<>();
    }

    public boolean addWorker(Worker worker) {
        if (!isWorkerIdDuplicate(worker.getId()) && isAgeValid(worker.getAge()) && isSalaryValid(worker.getSalary())) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    public boolean changeSalary(String workerId, double amount) {
        Worker worker = getWorkerById(workerId);
        if (worker != null) {
            double previousSalary = worker.getSalary();
            double newSalary = previousSalary + amount;
            if (isSalaryValid(newSalary)) {
                worker.setSalary(newSalary);
                salaryHistory.add(new SalaryHistory(workerId, previousSalary, newSalary));
                return true;
            }
        }
        return false;
    }

    public List<SalaryHistory> getInformationSalary() {
        return salaryHistory;
    }

    public Worker getWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return worker;
            }
        }
        return null;
    }

    private boolean isWorkerIdDuplicate(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAgeValid(int age) {
        return age >= 18 && age <= 50;
    }

    private boolean isSalaryValid(double salary) {
        return salary > 0;
    }
}