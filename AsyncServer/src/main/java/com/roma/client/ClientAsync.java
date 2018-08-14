package com.roma.client;

import com.roma.entity.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ClientAsync {
    public static final String BASE_URI = "http://localhost:8080/myapp/";
    static Client client;
    static WebTarget target;
    static ExecutorService exec = Executors.newCachedThreadPool();
    static List<Future> futures = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String responseMsg = getResp("1");
//                action(responseMsg);
//            }
//        };
//
//        exec.execute(runnable);

//        System.out.println("Мы не ждем. Результат увидим позже.");

        // тут уже должен быть список юзеров
//        на каждого юзера в цикле отправлим запрос

        for (int i = 0; i < 10; i++) {
            final int finalI = i + 1;
            Callable<User> callable = new Callable<User>() {
                @Override
                public User call() throws Exception {
                    return getResp(String.valueOf(finalI));
                }
            };
            final Future<User> future = (Future<User>) exec.submit(callable);
            futures.add(future);
        }
//имеем лист асинхронных запросов futures

//        ExecutorService exService = Executors.newSingleThreadExecutor();
//        exService.execute(new Runnable() {
//            @Override
//            public void run() {
//                while (!future.isDone()) {
//                    System.out.println("Ждем 1 сек.");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
        while (futures.size() > 0) {
            Iterator<Future> iterator = futures.iterator();
            while (iterator.hasNext()) {
                Future future = iterator.next();
                if (future.isDone()) {
                    Object o = future.get();
                    System.out.println("Дождались ответа: " + o.toString());
                    iterator.remove();
                }
            }
        }
//        while (!future.isDone()) {
////            System.out.println("Ждем 1 сек.");
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


        exec.shutdown();
//        action(responseMsg);
    }

    private static void action(String responseMsg) {
        System.out.println("Результат запроса: " + responseMsg);
    }

    private static User getResp(String name) {
        client = ClientBuilder.newClient();
        target = client.target(BASE_URI);

        User user = target.path("/async/check/" + name).request().get(User.class);
        return user;
    }
}
