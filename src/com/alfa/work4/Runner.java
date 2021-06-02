package com.alfa.work4;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Runner {
    public void run(){

        class PersonFilter implements Predicate<Person> {

            @Override
            public boolean test(Person person) {
                return person.getGender().equals("male") && person.getAge()>18;
            }
        }

        class ToIntMaper implements ToIntFunction<Person>{

            @Override
            public int applyAsInt(Person value) {
                return value.getAge();
            }
        }


        List <Person> list = new LinkedList<>();
        list.add(new Person("Andrey", 19, "male"));
        list.add(new Person("Irina", 45, "female"));
        list.add(new Person("Anton", 55, "male"));
        list.add(new Person("Nikolay", 15, "male"));
        list.add(new Person("Olga", 25, "female"));
        list.add(new Person("Feder", 35, "male"));

        List <Person> newList = list.stream()
                .filter(s -> s.getGender().equals("male") && s.getAge()>18 && s.getAge()<27)
                //.filter(new PersonFilter())
                .collect(Collectors.toList());
               //.forEach(System.out::println);

        System.out.println(newList);

        Double averageAgeFemale = list.stream()
                .filter(s -> s.getGender().equals("female"))
                .mapToInt(Person::getAge)
                //.mapToInt(new ToIntMaper())
                .average()
                .getAsDouble();

       System.out.println(averageAgeFemale);


    }
}
