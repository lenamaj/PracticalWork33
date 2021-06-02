package com.alfa.work3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public void run(){
        List<Integer> list = Stream.iterate(10, n -> n+10)
                .limit(10)
                .map(n -> n/2)
                .collect(Collectors.toList());
        System.out.println(list);

        Stream.of("asdf","bkkk","ufhfb","buio","lkjh","ertt","poiu","Boiu")
                 .filter(s -> s.toLowerCase().startsWith("b"))
                 .sorted()
                .forEach(System.out::println);
    }
}
