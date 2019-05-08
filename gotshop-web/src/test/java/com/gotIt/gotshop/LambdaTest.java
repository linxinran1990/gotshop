package com.gotIt.gotshop;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/1</pre>
 */
@Slf4j
public class LambdaTest extends BaseTest {

    @Test
    public void test1(){
        List features = Arrays.asList("Lambda","Default Methon",
                "Stream","Date and Time API");

        features.forEach(n -> log.info(n.toString()));

    }


    @Test
    public void test2(){
        List<String> features = Arrays.asList("Lambda","Default Methon",
                "Stream","Date and Time API");

        features.stream().filter((n) -> n.startsWith("L")).forEach(n->log.info(n));
    }

    @Test
    public void test3() {
        List<Integer> features = Arrays.asList(100, 200, 300, 400, 500);

        features.stream().map((cost) -> cost*10).forEach((n) ->log.info(n.toString()));
    }

    @Test
    public void test4() {
        List<Integer> features = Arrays.asList(100, 200, 300, 400, 500);

        double  bill = features.stream().map((cost) -> cost*10)
                .reduce((sum,cost) -> sum + cost)
                .get();
        System.out.println(bill);
    }


    @Test
    public void test5(){
        List<String> features = Arrays.asList("Lambda","Default Methon",
                "Stream","Date and Time API");

        List<String> arrs = features.stream().filter(x -> x.length() > 6).collect(Collectors.toList());
        arrs.forEach(n ->log.info(n));
    }


    @Test
    public void test6(){
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
       log.info(G7Countries);
    }


    @Test
    public void test7(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct()
                .collect(Collectors.toList());
        distinct.forEach(n->log.info(n.toString()));
    }

    @Test
    public void test8(){
        List<String> names = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
    }
}



