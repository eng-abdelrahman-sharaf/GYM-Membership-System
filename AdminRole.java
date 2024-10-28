import java.util.ArrayList;
public class AdminRole {
    private TrainerDatabase database;
    
    public AdminRole() {
        database = new TrainerDatabase("Trainer.txt");
        database.readFromFile();
    }

    public void addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        database.insertRecord(trainer);
    }

    public ArrayList<Record> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public void removeTrainer(String key) {
        database.deleteRecord(key);
    }

    public void logout() {
        database.saveToFile();
    }

}