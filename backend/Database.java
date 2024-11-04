package backend;

import java.util.*;
import java.io.*;

abstract class Database {
   private String filename;
   private ArrayList<Record> List = new ArrayList<>();

    Database(String filename) {
        this.filename = filename;
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


    public abstract Record createRecordFrom (String line);


    public ArrayList<Record> returnAllRecords (){
        return List;
    };


    public boolean contains (String key){
        for (Record p : List){
            if (p.getsearchkey().equals(key)){
                return true;
            }
        }
        return false;
    }

    public Record getRecord(String key){
        for (Record p : List){
            if (p.getsearchkey().equals(key)){
                return p;
            }
        }
        System.out.println("ID incorrect");
        return null;
    }

    public boolean insertRecord(Record record){
        if(!List.contains(record)){
            List.add(record);
            return true;
        }
        return false;
    }

    public boolean deleteRecord(String key) {
        Record record = null;
        for (Record p : List) {
            if (p.getsearchkey().equals(key)) {
                record = p;
                break;
            }
        }
        if (record != null) {
            List.remove(record);
            return true;
        } else {
            System.out.println("ID incorrect");
            return false;
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for(Record record : List){
                writer.println(record.linerepresentation());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
