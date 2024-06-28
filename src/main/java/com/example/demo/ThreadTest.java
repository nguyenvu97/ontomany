package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.InfoPerson;
import com.example.demo.model.Person;

import java.io.*;
import java.util.concurrent.Callable;

public class ThreadTest implements Callable<Person> {
    public static  final  String FILE_PATH = "/Volumes/Extreme SSD/demo/src/main/resources/Static/";




    @Override
    public Person call() throws Exception {
        Address address = new Address("1001", "hanoi", "xuanphuong", "10000");
        InfoPerson infoPerson = new InfoPerson("nguyenkhacvu@1997", "123456", "123456789");
        Person person = Person
                .builder()
                .address(address)
                .infoPerson(infoPerson)
                .age(10)
                .firstName("nguyenvu")
                .lastName("thaidui")
                .folderName("person")
                .folderPath(FILE_PATH)
                .build();


        try {
            // Serialize object
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH +"person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            System.out.printf(deserializedPerson.toString());
            in.close();
            fileIn.close();
            System.out.println("Deserialized Person: " + deserializedPerson);
            return deserializedPerson;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
