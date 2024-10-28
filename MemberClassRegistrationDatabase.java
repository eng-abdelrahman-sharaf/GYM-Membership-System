import java.time.LocalDate;

public class MemberClassRegistrationDatabase extends Database {
    public MemberClassRegistrationDatabase(String filename) {
        super(filename);
    }
    @Override
    public Record createRecordFrom(String line) {
        String[] tokens = line.replaceAll(" ", "").split(",");
        // M1001, C101,2024-10-02, active
        MemberClassRegistration mcr = new MemberClassRegistration(tokens[0] , tokens[1], tokens[3], LocalDate.parse(tokens[2]));
        return mcr;
    }

}
