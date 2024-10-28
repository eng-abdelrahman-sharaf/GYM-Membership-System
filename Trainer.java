public class Trainer extends Person {
    String Speciality;
    public Trainer(String ID, String name, String email, String speciality,String phone) {
        super(name, ID, email, phone);
        this.Speciality = speciality;
    }
    public String linerepresentation() {
        String data = this.ID + "," + this.name + "," + this.email + "," + this.Speciality + "," + this.phone;
        return data;
    }

}
