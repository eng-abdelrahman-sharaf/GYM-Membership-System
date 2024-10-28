import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MemberDatabase extends Database {
    public MemberDatabase(String filename) {
        super(filename);
    }

    public Member createRecordFrom(String line){
        String[] tokens = line.replaceAll(" ","").split(",");
        Member mm = new Member(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
        return mm;
    }

    public void saveTofile() {
        String filename = this.getFilename();
        ArrayList<Person> pr = returnAllRecords();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Person person : pr) {
                Member mem = (Member) person;
                writer.write(mem.linerepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}



