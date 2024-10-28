import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TrainerDatabase extends Database{
    public TrainerDatabase(String name){
        super(name);
    }

    public Person createRecordFrom(String line){
        String[] tokens = line.replaceAll(" ","").split(",");
        Trainer tn = new Trainer(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
        return tn;
    }


    public void saveTofile() {
        String filename = this.getFilename();
        ArrayList<Person> pr = returnAllRecords();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : pr) {
                Trainer tr = (Trainer) person;
                writer.write(tr.linerepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
