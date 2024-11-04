package backend;

public class Trainer implements Record {

    private String Speciality, name , ID , email , phone;

    public Trainer(String ID, String name, String email, String speciality, String phone) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phone = phone;
        this.Speciality = speciality;
    }

    @Override
    public String getsearchkey() {
        return ID;
    }
    
    public String linerepresentation() {
        String data = this.ID + "," + this.name + "," + this.email + "," + this.Speciality + "," + this.phone;
        return data;
    }

}
