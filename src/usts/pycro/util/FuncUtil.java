package usts.pycro.util;

import java.util.function.Consumer;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-08 11:22 AM
 */
public class FuncUtil {
    /**
     * 计算函数执行时间
     *
     * @param consumer
     * @param arg
     * @param <T>
     */
    public static <T> void timeConsumer(Consumer<T> consumer, T arg) {
        long start = System.currentTimeMillis();
        consumer.accept(arg);
        long end = System.currentTimeMillis();
        System.out.printf("该方法耗时：%.3fs\n", (double) (end - start) / 1000);
    }

}
