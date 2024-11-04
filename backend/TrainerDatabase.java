package backend;

public class TrainerDatabase extends Database{
    public TrainerDatabase(String name){
        super(name);
    }

    public Record createRecordFrom(String line){
        String[] tokens = line.replaceAll(" ","").split(",");
        Trainer tn = new Trainer(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4]);
        return tn;
    }

}
