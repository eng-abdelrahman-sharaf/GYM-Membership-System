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

    
    public abstract String linerepresentation();

    public  String getsearchkey(){
        return this.ID;
    }



}
