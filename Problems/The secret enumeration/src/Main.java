import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //i wonder if I can use streams....
        long count = Arrays.stream(Secret.values())
                .filter(secret -> secret.toString().startsWith("STAR"))
                .count();
        System.out.println(count);
    }
}

/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START; // ...
}
*/