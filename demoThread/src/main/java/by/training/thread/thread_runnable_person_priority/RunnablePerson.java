package by.training.thread.thread_runnable_person_priority;

import java.util.concurrent.TimeUnit;

public class RunnablePerson extends Person implements Runnable {
    public RunnablePerson(String name ){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ")" + getSurname() + " ");
            System.out.println(Thread.currentThread());
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
