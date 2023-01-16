import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;
import scala.Tuple3;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkWordsCount");
        JavaSparkContext context = new JavaSparkContext(conf);

        //init

        File catalog = new File("alt.atheism");
        File[] files = null;
        //JavaPairRDD<String, Integer> resPairRDD = JavaPairRDD.fromJavaRDD(context.emptyRDD());

        if (catalog.isDirectory()) files = catalog.listFiles();

        if (files == null) throw new RuntimeException();

        Map<String, Integer> mapWordCount = new HashMap<>();
        Map<String, List<File>> mapWordFiles = new HashMap<>();
        for (File file : files) {
            JavaPairRDD<String, Integer> pairRDD = wordCount((context.textFile(file.getPath())));

            Map<String, Integer> mapFromRDD = pairRDD.collectAsMap();

            for (Map.Entry<String, Integer> entry : mapFromRDD.entrySet()) {
                mapWordCount.merge(entry.getKey(), entry.getValue(), Integer::sum);
                if(!mapWordFiles.containsKey(entry.getKey()))
                    mapWordFiles.put(entry.getKey(), Collections.singletonList(file));
                else mapWordFiles.computeIfPresent(entry.getKey(), (w, list) -> {
                    List<File> newList = new ArrayList<>(list);
                    newList.add(file);
                    return newList;
                });
            }
        }

        for (Map.Entry<String, Integer> entry : mapWordCount.entrySet()) {
            System.out.print("Word: " + entry.getKey() + ", count: " + entry.getValue() + ", files: ");
            mapWordFiles.get(entry.getKey()).forEach(s -> System.out.print(s.getName() + " "));
            System.out.println();
        }
    }

/*
private static List<Tuple3<String, Integer, List<File>>>
    mergeTuples3(List<Tuple3<String, Integer, List<File>>> toMerge,
                 List<Tuple2<String, Integer>> fromMerge, File file) {

        List<Tuple3<String, Integer, List<File>>> res = new ArrayList<>(toMerge);

        boolean flag = true;
        if (toMerge.isEmpty()) {
            for (Tuple2<String, Integer> tuple : fromMerge)
                res.add(new Tuple3<>(tuple._1, tuple._2, Collections.singletonList(file)));

            return res;
        }
        for (Tuple3<String, Integer, List<File>> to : toMerge) {
            for (Tuple2<String, Integer> from : fromMerge) {
                if (from._1().equals(to._1()) && from._2().equals(to._2()) && flag) {
                    int index = toMerge.indexOf(to);
                    List<File> files = new ArrayList<>(toMerge.get(index)._3());
                    files.add(file);
                    res.set(index, new Tuple3<>(to._1(), to._2() + from._2(), files));
                    flag = false;
                }
                if (from.equals(fromMerge.get(fromMerge.size() - 1)) && flag) {
                    res.add(new Tuple3<>(from._1(), from._2(), Collections.singletonList(file)));
                    flag = false;
                }
            }
            flag = true;
        }
        return res;
    }
    */

    private static List<Tuple3<String, Integer, List<File>>> mergeTuples3(List<Tuple3<String, Integer, List<File>>> toMerge, List<Tuple2<String, Integer>> fromMerge, File file) {

        List<Tuple3<String, Integer, List<File>>> res = new ArrayList<>(toMerge);

        boolean flag = true;
        if (toMerge.isEmpty()) {
            for (Tuple2<String, Integer> tuple : fromMerge)
                res.add(new Tuple3<>(tuple._1, tuple._2, Collections.singletonList(file)));

            return res;
        }
        for (Tuple3<String, Integer, List<File>> to : toMerge) {
            for (Tuple2<String, Integer> from : fromMerge) {
                if (from._1().equals(to._1()) && from._2().equals(to._2()) && flag) {
                    int index = toMerge.indexOf(to);
                    List<File> files = new ArrayList<>(toMerge.get(index)._3());
                    files.add(file);
                    res.set(index, new Tuple3<>(to._1(), to._2() + from._2(), files));
                    flag = false;
                }
                if (from.equals(fromMerge.get(fromMerge.size() - 1)) && flag) {
                    res.add(new Tuple3<>(from._1(), from._2(), Collections.singletonList(file)));
                    flag = false;
                }
            }
            flag = true;
        }
        return res;
    }

    private static JavaPairRDD<String, Integer> wordCount(JavaRDD<String> inputRDD) {
        JavaRDD<String> wordsFromFile = inputRDD.flatMap(content -> Arrays.asList(content.split(" ")).iterator());

        wordsFromFile.filter(word -> {
            word = validate(word);
            return word != null;
        });

        JavaPairRDD<String, Integer> pairRDD = wordsFromFile.mapToPair(word -> new Tuple2(word, 1)).reduceByKey((x, y) -> (int) x + (int) y);
        return pairRDD;
    }

    private static String validate(String str) {
        if (str.length() > 1) {
            if (str.contains(".")) {
                String[] tmp = str.split("\\.");
                if (tmp.length == 0 || tmp[0] == null) return null;
                str = tmp[0];
            }
            if (str.contains(",")) {
                String[] tmp = str.split(",");
                if (tmp.length == 0 || tmp[0] == null) return null;
                str = tmp[0];
            }
        }
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) return matcher.group().toLowerCase();
        return null;
    }
}
