public class Trainer extends Person {

   private String Speciality;
    public Trainer(String ID, String name, String email, String speciality,String phone) {
        super(name, ID, email, phone);
        this.Speciality = speciality;
    }

    public String linerepresentation() {
        String data = this.getID() + "," + this.getName() + "," + this.getEmail() + "," + this.Speciality + "," + this.getPhone();
        return data;
    }

}
