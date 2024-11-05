import java.util.ArrayList;
import java.time.LocalDate;
public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;

    public TrainerRole() {
        registrationDatabase = new MemberClassRegistrationDatabase(FileNames.REGISTRATION_FILENAME);
        memberDatabase = new MemberDatabase(FileNames.MEMBER_FILENAME);
        classDatabase = new ClassDatabase(FileNames.CLASS_FILENAME);
        registrationDatabase.readFromFile();
        memberDatabase.readFromFile();
        classDatabase.readFromFile();
    }

    public boolean addMember(String memberID, String name, String membershipType, String email, String phoneNumber,
            String status) {
        Member member = new Member(memberID, name, membershipType, email, phoneNumber, status);
        if(memberDatabase.insertRecord(member))
            return true;
        return false;

    }

    public ArrayList<Record> getListOfMembers() {
        return memberDatabase.returnAllRecords();
    }

    public void addClass(String classID, String className, String trainerID, int duration, int maxParticipants) {
        Class newClass = new Class(classID, className, trainerID, duration, maxParticipants);
        classDatabase.insertRecord(newClass);
    }

    public ArrayList<Record> getListOfClasses() {
        return classDatabase.returnAllRecords();
    }

    public boolean registerMemberForClass(String memberID, String classID, LocalDate registrationDate) {
        if(classDatabase.contains(classID) == false || memberDatabase.contains(memberID) == false){
            return false;
        }
        Class class_ = (Class) classDatabase.getRecord(classID);
        if (class_.getAvailableSeats() > 0) {
            MemberClassRegistration registration = new MemberClassRegistration(memberID, classID, "active",
                    registrationDate);
            class_.setAvailableSeats(class_.getAvailableSeats() - 1);
            registrationDatabase.insertRecord(registration);
            return true;
        }
        return false;
    }

    public boolean cancelRegistration(String memberID, String classID) {
        if (registrationDatabase.contains(memberID + classID) == false) {
            return false;
        }
        MemberClassRegistration registration = (MemberClassRegistration) registrationDatabase
                .getRecord(memberID + classID);
        if (registration.getRegistrationDate().plusDays(3).isBefore(LocalDate.now())) {
            return false;
        }
        registrationDatabase.deleteRecord(memberID + classID);
        MemberClassRegistration newRegistration = new MemberClassRegistration(memberID, classID, "cancelled",
                registration.getRegistrationDate());
        registrationDatabase.insertRecord(newRegistration);
        Class class_ = (Class) classDatabase.getRecord(classID);
        class_.setAvailableSeats(class_.getAvailableSeats() + 1);
        return true;
    }

    public ArrayList<Record> getListOfRegistrations() {
        return registrationDatabase.returnAllRecords();
    }

    public ClassDatabase getClassDatabase() {
        return classDatabase;
    }

    public MemberClassRegistrationDatabase getRegistrationDatabase() {
        return registrationDatabase;
    }

    public MemberDatabase getMemberDatabase() {
        return memberDatabase;
    }

    public void logout() {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }

}
