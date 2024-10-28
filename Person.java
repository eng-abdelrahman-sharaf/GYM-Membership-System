abstract class Person {
    String name;
    String ID;
    String email;
    String phone;

    public Person(String name, String ID, String email, String phone) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }


    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(String ID) {
        this.ID = ID;
    }


    public abstract String linerepresentation();

    public  String getsearchkey(){
        return this.ID;
    }



}
