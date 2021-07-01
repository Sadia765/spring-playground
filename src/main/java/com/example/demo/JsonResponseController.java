package com.example.demo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/json")
public class JsonResponseController {

    @GetMapping("/person")
    public Person getPerson() {
        Person person = new Person();
        person.firstName = "Dwayne";
        person.lastName = "Johnson";
        return person;
    }

    public static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public static class Object {
        private String q;
        private String from;

        public String getQ() {
            return q;
        }

        public void setQ(String q) {
            this.q = q;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    @GetMapping("/people")
    public List<Person> getPeople() {
        Person person1 = new Person();
        person1.firstName = "Dwayne";
        person1.lastName = "Johnson";

        Person person2 = new Person();
        person2.firstName = "John";
        person2.lastName = "Cena";

        return Arrays.asList(person1, person2);
    }

    @PostMapping("/object-example")
    public String objectParams(@RequestBody Object object) {

        object.q = "something";
        object.from = "2008";
        return "Search: q=" + object.q + " from=" + object.from;
    }

    @PostMapping("/objmapper")
    public void hashToJson() {

    }

    @PostMapping("/fileObject")
    public String readFile() throws FileNotFoundException {
        File myObj = new File("src/main/resources/data.json");
        Scanner myReader = new Scanner(myObj);
        String data = null;
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            System.out.println(data);
        }
        return data;
    }
}
