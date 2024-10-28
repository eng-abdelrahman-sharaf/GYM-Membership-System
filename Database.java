 import java.io.*;
 import java.util.*;
abstract class Database {
   private String filename;
   private ArrayList<Person> List = new ArrayList<>();

Database(String filename) {
    this.filename = filename;
}

String getFilename() {
    return filename;
}

    public void readFromFile (){
        String line;

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                 line = scanner.nextLine();
                this.List.add(createRecordFrom(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            e.printStackTrace();
        }

    }


    public abstract Person createRecordFrom (String line);


    public ArrayList<Person> returnAllRecords (){
        return List;
    };


    public boolean contains (String key){
        for (Person p : List){
            if (p.getsearchkey().equals(key)){
                return true;
            }
        }
        return false;
    }

    public Person getrecord(String key){
        for (Person p : List){
            if (p.getsearchkey().equals(key)){
                return p;
            }
        }
        System.out.println("ID incorrect");
        return null;
    }

    public void insertRecord(Person record){
        if(!List.contains(record)){
            List.add(record);
        }
    }

    public void deleteRecord(String key){
        for (Person p : List){
            if (p.getsearchkey().equals(key)){
                List.remove(p);
            }
            saveTofile();
        }
        System.out.println("ID incorrect");
    }

    public abstract void  saveTofile();



}
