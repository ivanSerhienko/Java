import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static JavaPairRDD<String, String> pairRDD;
    private static final Map<Tuple2<String, String>, Integer> match = new HashMap<>();

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Triangles");
        JavaSparkContext context = new JavaSparkContext(conf);
        JavaRDD<String> rdd = context.textFile("src/main/resources/graph.txt");
        pairRDD = rdd.mapToPair(
                (PairFunction<String, String, String>) s -> {
                    String[] pair = s.split(" ");
                    return new Tuple2<>(pair[0], pair[1]);
                }
        );

        //pairRDD.collect().forEach(System.out::println);

        pairRDD.persist(StorageLevel.MEMORY_ONLY());

       List<Tuple2<String, String>> list = pairRDD.collect().
                stream().
                filter(Main::reverseCheck).
                collect(Collectors.toList());

        pairRDD.unpersist();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(list.size());
    }

    private static boolean reverseCheck(Tuple2<String, String> pair) {
        return pairRDD.collect().stream().anyMatch(el -> el.equals(new Tuple2<>(pair._2, pair._1)));
    }
}