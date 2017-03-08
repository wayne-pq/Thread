package Thread.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by panqian on 2017/3/7.
 */
public class ConcurrentHashMap_1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("target", "classes", "english.txt");
        if (path.toFile().exists()) {
            BufferedReader reader = Files.newBufferedReader(path);
            StringBuilder str = new StringBuilder();
            String s;
            while (null != (s = reader.readLine())) {
                str.append(s);
            }

            String s1 = str.toString().replaceAll("\\?|,'|\\.'|\\.|-|,", " ");

            String[] words = s1.split("\\s");

            ConcurrentHashMap<String, LongAdder> concurrentHashMap = new ConcurrentHashMap();

            ExecutorService pool = new ThreadPoolExecutor(10, 10, 3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());


            List<String> strings = Arrays.asList(words);

            ArrayList<List<String>> lists = new ArrayList<>();

            int i1 = strings.size() / 10;

            for (int i = 0; i < 10; i++) {
                if (i == 9) {
                    lists.add(strings.subList(i * i1, strings.size()));
                } else {
                    lists.add(strings.subList(i * i1, i * i1 + i1));

                }
            }

            for (int i = 0; i < 10; i++) {
                List<String> strings1 = lists.get(i);
                pool.submit(() -> {
                            for (String word : strings1) {
                                word = word.replace((char) 12288, ' ').trim().toLowerCase();
                                LongAdder l = concurrentHashMap.get(word);
                                if (null != l) {
                                    l.increment();
                                } else {
                                    LongAdder longAdder = new LongAdder();
                                    longAdder.increment();
                                    concurrentHashMap.putIfAbsent(word, longAdder);
                                }
                            }
                        }
                );
            }

            pool.shutdown();

            //判断线程池中的线程是否全部执行完毕
            while (!pool.isTerminated()) {

            }


            System.out.println(concurrentHashMap);

        }
    }


}
