public class Member extends Person  {
    private String status;
    private String Type;


    public Member(String ID, String name, String type, String email, String phone, String status) {
        super(name, ID, email, phone);
        this.status = status;
        this.Type = type;
    }

    public String linerepresentation() {
        String data = this.getID() + "," + this.getName() + "," + this.Type + "," + this.getEmail()+ "," + this.getPhone()+","+ this.status;
        return data;
    }



}
