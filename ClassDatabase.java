public class ClassDatabase extends Database{
    public ClassDatabase(String name) {
        super(name);
    }

    // C101, Yoga,T001,60,30
    public Record createRecordFrom(String line){
        String[] tokens = line.replaceAll(" ","").split(",");
        Class cl = new Class(tokens[0],tokens[1],tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
        return cl;
    }
    
}