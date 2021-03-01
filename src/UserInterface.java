import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Scanner;

public class UserInterface {

    private final Scanner reader;
    private final HashMap<String, Integer> wordCount;

    public UserInterface(Scanner reader) {
        this.reader = reader;
        this.wordCount = new HashMap<>();
    }

    public static String getText(){
        return "Since 1995, Java has changed our world . . . and our expectations.. \n"
                + "Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. \n"
                + "Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining. \n"
                + "In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. \n"
                + "In 1991, a small group of Sun engineers called the \"Green Team\" believed that the next wave in computing was the union of digital consumer devices and computers. \n"
                + "Led by James Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java. \n"
                + "The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. \n"
                + "Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. \n"
                + "In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology. \n"
                + "Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. \n"
                + "From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere!";
    }

    private void howManySunday(){
        int count = 0;
        LocalDate startDate = LocalDate.of(1901, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2000, Month.DECEMBER, 31);
        while (startDate.isBefore(endDate)) {
            startDate = startDate.plusMonths(1);
            if (startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                count++;
            }
        }
        System.out.println("Ada " + count + " hari");
    }

    private void countWord(){
        String[] words = getText().toLowerCase().split("\\W+");

        for (String word : words) {
            if (!wordCount.containsKey(word)){
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, wordCount.get(word) + 1);
            }
        }
    }

    private void numOfWords(){
        System.out.println("Teks tersebut memiliki " + wordCount.size() + " kata.");
    }

    private void everyWordOccurrence(){
        for (String a : wordCount.keySet()){
            System.out.println(a + " : " + wordCount.get(a) + " kata");
        }
    }

    private void oneWordOccurrence(){
        System.out.print("Ketik kata yang anda cari : ");
        String input = reader.next();
        String cari = input.toLowerCase();

        if (wordCount.containsKey(cari)){
            System.out.println("Kata " + cari + " muncul sebanyak " + wordCount.get(cari) + " kali");
        } else {
            System.out.println("Kata " + cari + " tidak ada dalam teks");
        }
    }

    private void onlyAppearOne(){
        int count = 0;
        for (int a : wordCount.values()){
            if (a == 1){
                count++;
            }
        }

        System.out.println("Ada " + count + " kata yang hanya muncul satu kali");
    }

    private void mostOccurrence(){
        String word = "";
        int max = 0;
        for (String a : wordCount.keySet()){
            if (wordCount.get(a) > max){
                max = wordCount.get(a);
                word = a;
            }
        }

        System.out.println("Kata \"" + word + "\" paling sering muncul dengan jumlah " + max + " kata.");
    }

    private void leastOccurrence(){
        String word = "";
        Integer min = Integer.MAX_VALUE;
        for (String a : wordCount.keySet()){
            if (wordCount.get(a) < min){
                min = wordCount.get(a);
                word = a;
            }
        }

        System.out.println("Kata \"" + word + "\" paling sedikit muncul dengan jumlah " + min + " kata.");
    }

    public void start() {
        countWord();

        System.out.println("Coding Test PT Multipolar Technology Tbk \n"
                + "---------------------\n");

        while (true) {
            System.out.print("Pilih operasi :\n"
                    + "[1] Jumlah hari senin pada bulan pertama di antara 1 Januari 1901 hingga 31 Desember 2000\n"
                    + "Diberikan sebuah teks, pilih operasi dibawah untuk mendapat informasi teks\n"
                    + "[2] Jumlah kata dari teks\n"
                    + "[3] Jumlah kemunculan semua kata\n"
                    + "[4] Jumlah kemunculan satu kata\n"
                    + "[5] Jumlah kata yang hanya muncul satu kali\n"
                    + "[6] Jumlah kata yang paling banyak muncul\n"
                    + "[7] Jumlah kata yang paling sedikit muncul\n"
                    + "[x] Exit\n"
                    + "> ");

            String operation = reader.next();

            if ("1".equals(operation)){
                howManySunday();
            } else if ("2".equals(operation)) {
                numOfWords();
            } else if ("3".equals(operation)) {
                everyWordOccurrence();
            } else if ("4".equals(operation)) {
                oneWordOccurrence();
            } else if ("5".equals(operation)) {
                onlyAppearOne();
            } else if ("6".equals(operation)) {
                mostOccurrence();
            } else if ("7".equals(operation)) {
                leastOccurrence();
            } else if ("x".equals(operation)) {
                System.out.println();
                break;
            }
            System.out.println();
        }
    }
}
