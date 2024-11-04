package backend;

public class Member implements Record  {
    private String name , ID , email , phone , Type , status;

    public Member(String ID, String name, String type, String email, String phone, String status) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.Type = type;
    }

    @Override
    public String getsearchkey() {
        return ID;
    }

    @Override
    public String linerepresentation() {
        String data = this.ID + "," + this.name + "," + this.Type + "," + this.email+ "," + this.phone+","+ this.status;
        return data;
    }

}

