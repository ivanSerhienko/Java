/*                                           №1
 * На основе массива рок-исполнителей создайте список из первых (по алфавиту) трех песен.
 * */

/*                                           №2
 * На основе адреса каталога выделите список файлов с расширением «txt».
 * */

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class IntermediateMethodsForChangingStream {
    public static void main(String[] args) {
        //1
        Singer singer1 = new Singer("Freddie Mercury", new String[] { "We Are the Champions", "Somebody to Love" });
        Singer singer2 = new Singer("David Bowie",new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
        Singer singer3 = new Singer("James Paul McCartney", new String[] { "Can’t Buy Me Love", "Another Girl" });

        Singer[] rockStars = new Singer[] { singer1, singer2, singer3 };

        System.out.print("№1: ");
        Arrays.stream(rockStars).flatMap(singer -> Arrays.stream(singer.getSongs())).
                sorted(Comparator.naturalOrder()).
                limit(3).
                toList().
                forEach(s -> System.out.print(s + ", "));
        System.out.println();

        //2
        System.out.print("№2: ");
        Arrays.stream(new File("Catalog").list()).filter(s -> s.contains(".txt")).
                toList().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
