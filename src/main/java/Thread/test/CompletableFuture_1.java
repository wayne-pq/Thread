package Thread.test;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture这个类主要的作用就是提供了新的方式来完成异步处理,包括合成和组合事件的非阻塞方式。
 * 以前Future需要get（）才有结果（现在创建对象就会异步执行），而且get的时候会线程阻塞等待结果（CompletableFuture不阻塞，异步执行）。
 * Created by panqian on 2017/3/8.
 */
public class CompletableFuture_1 {
    public static void main(String[] args) {
        CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> {
            return UUID.randomUUID().toString();
        }).thenApplyAsync((x) -> {
            System.out.println("接受到的参数" + x);
            return true;
        }).thenAcceptAsync((x) -> {
            if (x == true) {
                System.out.println("结束");
            }
        });

        //task创建后会主动完成计算（什么时候开始不确定），所以下面的循环是用充分的时间给上面的程序执行
        for(int i =0;i<1000000;i++){
            System.out.println("");
        }
    }
}
