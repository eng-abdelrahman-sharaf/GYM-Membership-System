public class Class implements Record {
    private String classID, className, trainerID;
    private int duration, availableSeats;

    public Class(String classID, String className, String trainerID, int duration, int availableSeats) {
        this.classID = classID;
        this.className = className;        
        this.trainerID = trainerID;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String getsearchkey() {
        return classID;
    }

    // C101, Yoga,T001,60,30
    @Override
    public String linerepresentation() {
        return classID + "," + className + "," + trainerID + "," + duration + "," + availableSeats;
    }
}
