package Thread.callable;

import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Callable 跟 Runnable 相似，但是Callable有返回值
 * Created by panqian on 2016/12/27.
 */
public class UUIDCounter implements Callable<String> {

    @Override
    public String call() throws Exception {
        return UUID.randomUUID().toString();
    }
}
