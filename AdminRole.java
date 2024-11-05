import java.util.ArrayList;
public class AdminRole {
    private TrainerDatabase database;
    
    public AdminRole() {
        database = new TrainerDatabase(FileNames.TRAINER_FILENAME);
        database.readFromFile();
    }

    public boolean addTrainer(String trainerId, String name, String email, String specialty, String phoneNumber) {
        Trainer trainer = new Trainer(trainerId, name, email, specialty, phoneNumber);
        if(database.insertRecord(trainer))
            return true;
        return false;
    }

    public ArrayList<Record> getListOfTrainers() {
        return database.returnAllRecords();
    }

    public boolean removeTrainer(String key) {

        if(database.deleteRecord(key))
            return true;
        return false;
    }

    public void logout() {
        database.saveToFile();
    }

}