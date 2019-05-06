package com.gotIt.gotshop;

import com.gotIt.gotshop.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/5/1</pre>
 */
public class StreamTest extends BaseTest {
    public class Student {
        private String name;
        private Integer score;

        public void setName(String name) {
            this.name = name;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public Student(String user, int i) {
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }
    }


    // 创建流
    @Test
    public void test1(){
        //1.通过Arrays.stream
        //1.1基本类型
        int[] arr = new int[]{1,2,34,5};
        IntStream intStream = Arrays.stream(arr);
        //2.通过Stream.of
        Stream<Integer> stream1 = Stream.of(1,2,34,5,65);
        //注意生成的是int[]的流
        Stream<int[]> stream2 = Stream.of(arr,arr);
        stream2.forEach(System.out::println);
    }

    // 创建流
    @Test
    public void test2(){
        List<String> strs = Arrays.asList("11212","dfd","2323","dfhgf");
        //创建普通流
        Stream<String> stream  = strs.stream();
        //创建并行流
        Stream<String> stream1 = strs.parallelStream();
    }

    // 创建流
    @Test
    public void test3(){
        //创建无限流，通过limit提取指定大小
        Stream.generate(()->"number"+new Random().nextInt()).limit(100).forEach(System.out::println);
        //Stream.generate(()->new User("name",10)).limit(20).forEach(System.out::println);
    }

    // 流操作 Map map把一种类型的流转换为另外一种类型的流
    @Test
    public void test4(){
        String[] arr = new String[]{"yes", "YES", "no", "NO"};
        Arrays.stream(arr).map(x -> x.toLowerCase()).forEach(System.out::println);
    }

    // 流操作  filter：过滤流，过滤流中的元素
    @Test
    public void test5(){
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).filter(x->x>3&&x<8).forEach(System.out::println);
    }

    // 流操作  flapMap：拆解流，将流中每一个元素拆解成一个流
    @Test
    public void test6(){
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        //Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        //Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::println);
    }

    String[] arr1 = {"abc","a","bc","abcd"};

    // 流操作   sorted：对流进行排序
    @Test
    public void test7(){
        Arrays.stream(arr1).sorted((x,y)->{
            if (x.length()>y.length())
                return 1;
            else if (x.length()<y.length())
                return -1;
            else
                return 0;
        }).forEach(System.out::println);
       // Arrays.stream(arr1).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        Arrays.stream(arr1).sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //Arrays.stream(arr1).sorted(Comparator.comparing(this::com1).thenComparing(String::length)).forEach(System.out::println);
    }

    String[] arr2 = new String[]{"d","e","f","g"};
    // 流操作  提取流和组合流
    @Test
    public void test8(){
       // limit，限制从流中获得前n个数据
        Stream.iterate(1,x->x+2).limit(10).forEach(System.out::println);
        //skip，跳过前n个数据
        Stream.iterate(1,x->x+2).skip(1).limit(5).forEach(System.out::println);

        //可以把两个stream合并成一个stream（合并的stream类型必须相同）
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        Stream.concat(stream1,stream2).distinct().forEach(System.out::println);

    }

    String[]  arr = new String[]{"b","ab","abc","abcd","abcde"};
    /**
     * max、min
     * 最大最小值
     */
    @Test
    public void testMaxAndMin(){
        Stream.of(arr).max(Comparator.comparing(String::length)).ifPresent(System.out::println);
        Stream.of(arr).min(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }

    /**
     * count
     * 计算数量
     */
    @Test
    public void testCount(){
        long count = Stream.of(arr).count();
        System.out.println(count);
    }

    /**
     * findFirst
     * 查找第一个
     */
    @Test
    public void testFindFirst(){
        String str =  Stream.of(arr).parallel().filter(x->x.length()>3).findFirst().orElse("noghing");
        System.out.println(str);
    }


    /**
     * findAny
     * 找到所有匹配的元素
     * 对并行流十分有效
     * 只要在任何片段发现了第一个匹配元素就会结束整个运算
     */
    @Test
    public void testFindAny(){
        Optional<String> optional = Stream.of(arr).parallel().filter(x->x.length()>3).findAny();
        optional.ifPresent(System.out::println);
    }

    /**
     * anyMatch
     * 是否含有匹配元素
     */
    @Test
    public void testAnyMatch(){
        Boolean aBoolean = Stream.of(arr).anyMatch(x->x.startsWith("a"));
        System.out.println(aBoolean);
    }


    @Test
    public void testStream1() {
        Optional<Integer> optional = Stream.of(1,2,3).filter(x->x>1).reduce((x,y)->x+y);
        System.out.println(optional.get());
    }

    //
    @Test
    public void testOptional2() {
        Integer[] arr = new Integer[]{4,5,6,7,8,9};
        Integer result = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(result);
        Integer result1 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseGet(()->-1);
        System.out.println(result1);
      //  Integer result2 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
       // System.out.println(result2);
    }

    Student[] students;
    @Before
    public void init(){
       students = new Student[100];
        for (int i=0;i<30;i++){
            Student student = new Student("user",i);
            students[i] = student;
        }
        for (int i=30;i<60;i++){
            Student student = new Student("user"+i,i);
            students[i] = student;
        }
        for (int i=60;i<100;i++){
            Student student = new Student("user"+i,i);
            students[i] = student;
        }

    }

    @Test
    public void testCollect1(){
        /**
         * 生成List
         */
        List<Student> list = Arrays.stream(students).collect(toList());
        list.forEach((x)-> System.out.println(x));
        /**
         * 生成Set
         */
        Set<Student> set = Arrays.stream(students).collect(toSet());
        set.forEach((x)-> System.out.println(x));
        /**
         * 如果包含相同的key，则需要提供第三个参数，否则报错
         */
//        Map<String,Integer> map = Arrays.stream(students).collect(toMap(Student::getName,Student::getScore,(s,a)->s+a));
//        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * 生成数组
     */
    @Test
    public void testCollect2(){
        Student[] s = Arrays.stream(students).toArray(Student[]::new);
        for (int i=0;i<s.length;i++)
            System.out.println(s[i]);
    }

    /**
     * 指定生成的类型
     */
    @Test
    public void testCollect3(){
        HashSet<Student> s = Arrays.stream(students).collect(toCollection(HashSet::new));
        s.forEach(System.out::println);
    }

    /**
     * 统计
     */
    @Test
    public void testCollect4(){
        /*IntSummaryStatistics summaryStatistics = Arrays.stream(students).collect(Collectors.summarizingInt(Student::getScore));
        System.out.println("getAverage->"+summaryStatistics.getAverage());
        System.out.println("getMax->"+summaryStatistics.getMax());
        System.out.println("getMin->"+summaryStatistics.getMin());
        System.out.println("getCount->"+summaryStatistics.getCount());
        System.out.println("getSum->"+summaryStatistics.getSum());*/
    }
}



