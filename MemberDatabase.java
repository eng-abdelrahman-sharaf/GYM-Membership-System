public class MemberDatabase extends Database {
    public MemberDatabase(String filename) {
        super(filename);
    }

    @Override
    public Record createRecordFrom(String line){
        String[] tokens = line.replaceAll(" ","").split(",");
        Member mm = new Member(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
        return mm;
    }

}



