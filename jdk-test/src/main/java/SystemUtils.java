import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng yingsheng on 5/3/2017.
 */
public class SystemUtils {

    public static void main(String[] args) throws Exception {
        System.out.println(getCurrentProcessPID());
    }

    /**
     * 获取当前Java的进程PID
     * @return
     */
    private static int getCurrentProcessPID() {
        List list = new ArrayList();
        list.add(1);
        list.remove(0);
        return Integer.parseInt(java.lang.management.ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
    }

}
