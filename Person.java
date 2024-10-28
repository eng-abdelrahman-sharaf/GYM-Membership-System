public abstract class Person implements Record {
    private String name;
    private String ID;
    private String email;
    private String phone;

    public Person(String name, String ID, String email, String phone) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phone = phone;
    }


    public  String getsearchkey(){
        return this.ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getID() {
        return ID;
    }

    public String getPhone() {
        return phone;
    }


    public abstract String linerepresentation();

}
