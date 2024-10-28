import java.time.LocalDate;

public class MemberClassRegistration implements Record {

    private String memberID, classID, status;
    private LocalDate registrationDate;

    public MemberClassRegistration(String memberID, String classID, String status, LocalDate registrationDate) {
        this.memberID = memberID;
        this.classID = classID;
        this.registrationDate = registrationDate;
        this.status = status;

    }
    
    public String getMemberID() {
        return memberID;
    }

    public String getClassID() {
        return classID;
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String linerepresentation() {
        return memberID + ", " + classID + ", " + registrationDate + ", " + status;
    }

    @Override
    public String getsearchkey() {
        // TODO Auto-generated method stub
        return null;
    }
    
}