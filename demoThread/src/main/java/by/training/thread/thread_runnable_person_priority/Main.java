package by.training.thread.thread_runnable_person_priority;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread());
        RunnablePerson dora = new RunnablePerson("Dora");
        RunnablePerson natasha = new RunnablePerson("Natasha");

        Thread threadDora = new Thread(dora,"ThreadDora");
        Thread threadNatasha = new Thread(natasha,"ThreadNatasha");

        threadDora.start();
        threadNatasha.start();
//        threadDora.setPriority(1);
//        threadNatasha.setPriority(10);
        System.out.println("main finished!");
    }
}
