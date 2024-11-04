import backend.ClassDatabase;
import backend.MemberDatabase;
import backend.TrainerDatabase;

import javax.swing.*;

public class Validation {
    public void displayInvalidity(JPanel panel , String field){
            Utils.displayErrorMessage(panel , field+ " is not valid");
    }

    public void displayNotFound(JPanel panel , String field){
        Utils.displayErrorMessage(panel , field+ " was not found");
    }

    public static boolean validateName(String name) {
        return name.matches("[a-zA-Z]+");
    }
    public static boolean validateEmail(String email) {
        return email.matches("[a-zA-Z0-9_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
    }
    public static boolean validatePhone(String phone) {
        return phone.matches("01+[0-9]{9}");
    }
    public static ERROR_TYPE validateMemberID(String memberID , MemberDatabase db) {
        if(memberID.matches("M+[0-9]+")){
            if(db.contains(memberID))
                return ERROR_TYPE.NO_ERROR;
            else {

                return ERROR_TYPE.NOT_EXISTING;
            }
        }
        else return ERROR_TYPE.INVALID;
    }

    public static ERROR_TYPE validateTrainerID(String trainerID , TrainerDatabase db ) {
        if(trainerID.matches("T+[0-9]+")){
            if(db.contains(trainerID)){
                return ERROR_TYPE.NO_ERROR;
            }
            else return ERROR_TYPE.NOT_EXISTING;
        }
        return ERROR_TYPE.INVALID;
    }
    public static ERROR_TYPE validateClassID(String classID , ClassDatabase db) {
        if(classID.matches("T+[0-9]+")){
            if(db.contains(classID)){
                return ERROR_TYPE.NO_ERROR;
            }
            else return ERROR_TYPE.NOT_EXISTING;
        }
        return ERROR_TYPE.INVALID;
    }
}
