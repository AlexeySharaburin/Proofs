import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<String, Person> dataBase = new HashMap<>();

    static String fileNameJSON = "dataBase.json";


    public static void main(String[] args) throws IOException, ParseException {

        dataBase = JsonToMap(fileNameJSON);

//        User user1 = new User("Ivan", "Petrov");
//        Person person1 = new Person(Profession.BUILDER, user1, 33, Sex.MAN);
//
//        User user2 = new User("Olga", "Belova");
//        Person person2 = new Person(Profession.TEACHER, user2, 44, Sex.WOMAN);
//
//        dataBase.put("ID1", person1);
//        dataBase.put("ID2", person2);

//        mapToJson(dataBase, fileNameJSON);
        JsonToMap(fileNameJSON);
        printMap();

    }

    public static void printMap() {
        for (Map.Entry<String, Person> entry : dataBase.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            System.out.println(entry.getValue().getAge());
        }
    }


    public static void mapToJson(Map<String, Person> map, String fileNameJSON) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(map);

        try (FileWriter file = new FileWriter(fileNameJSON)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Person> JsonToMap(String fileNameJSON) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileNameJSON))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Person> map = new ObjectMapper().readValue(sb.toString(), HashMap.class);
        return map;
    }
}

