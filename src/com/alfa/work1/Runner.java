package com.alfa.work1;

import com.alfa.work2.MyConverter;

import java.util.*;
import java.util.function.Predicate;

public class Runner {

    public void run() {
        Integer[] arrInt = createArrayInt();
        System.out.println(Arrays.toString(arrInt));
        //Arrays.sort(arrInt, (a, b) -> b.compareTo(a));
        Arrays.sort(arrInt, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arrInt));
        //System.out.println();
        System.out.println(sum(arrInt, x->x%2==0));
        System.out.println(sum(arrInt, x->x%2==1));
        System.out.println(sum(arrInt, x->x>0));

        List<String> list = createList();
        System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
//        System.out.println(list);
//        printStr(list, x -> x.charAt(0) > 'd');
//        System.out.println();
//        printStr(list, x -> x.charAt(0) < 'd');
//        System.out.println();
        updateList(list, str -> MyConverter.isnull(str) ? str : str.toUpperCase());
        System.out.println(list);
        updateList(list, str -> MyConverter.isnull(str) ? str : str.concat(str));
        System.out.println(list);



    }

    private Integer[] createArrayInt() {
        Random random = new Random();
        Integer[] array = new Integer[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) - 50;
        }
        return array;
    }


    private List<String> createList() {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        String temp = "jdhgfsgfjhgdjhsgfjhgkkjhbhgg";
        for (int i = 0; i < 12; i++) {
            // list.add(String.valueOf((char) random.nextInt(26)+65));
            int pos = random.nextInt(temp.length());
            list.add(temp.substring(pos, pos + 1));
        }

        return list;
    }


    public Integer sum(Integer[] arrInt, Predicate<Integer> predicate) {

        int sumInt = 0;
        for (Integer elem : arrInt) {
          if(predicate.test(elem)){
              sumInt+=elem;
        }
    }
        return sumInt;
}

    public void printStr(List<String> list, Predicate<String> predicate){
        for (String elem:list) {
            if(predicate.test(elem)){
                System.out.print(elem + "\t");
            }
        }



    }


    public void updateList(List<String> list, MyConverter converter){
        for (int i = 0; i < list.size(); i++) {
            list.set(i,converter.convertStr(list.get(i)));
        }
    }

}
