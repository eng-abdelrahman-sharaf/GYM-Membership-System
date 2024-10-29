import java.time.LocalDate;
public class App {
    public static void main(String[] args) {
        TrainerRole trainer = new TrainerRole();
        trainer.addClass("Cnew", "cName", "Tnew", 15, 20);
        trainer.addMember("Mnew", "roooooo", "Premium", "dodo@mailodo", "0122489466", "active");
        trainer.registerMemberForClass("Mnew", "Cnew", LocalDate.now());
        for (Record c : trainer.getListOfClasses()) {
            System.out.println(c.linerepresentation());
        }
        for(Record m : trainer.getListOfMembers()){
            System.out.println(m.linerepresentation());
        }
        for(Record r : trainer.getListOfRegistrations()){
            System.out.println(r.linerepresentation());
        }
        trainer.cancelRegistration("Mnew", "Cnew");
        for(Record r : trainer.getListOfRegistrations()){
            System.out.println(r.linerepresentation());
        }
        trainer.logout();
    }
}
