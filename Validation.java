public class Validation {
    public boolean validateName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public boolean validateEmail(String email) {
        return email.matches("[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    }
    public boolean validatePhone(String phone) {
        return phone.matches("01+[0-9]{9}");
    }
    public boolean validateMemberID(String memberID) {
        return memberID.matches("M+[0-9]+");
    }
    public boolean validateTrainerID(String memberID) {
        return memberID.matches("T+[0-9]+");
    }
    public boolean validateClassID(String memberID) {
        return memberID.matches("C+[0-9]+");
    }
}
