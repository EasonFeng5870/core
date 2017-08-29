import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by feng yingsheng on 3/7/2017.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
    }
}
