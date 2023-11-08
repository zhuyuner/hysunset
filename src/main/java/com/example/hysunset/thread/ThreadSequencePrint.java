package com.example.hysunset.thread;

public class ThreadSequencePrint {


    public static class ThreadPrinterA implements Runnable {
        private String name;
        private Object obj;

        public ThreadPrinterA(String name, Object obj) {
            this.name = name;
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (true) {
                    try {
                        System.out.println("A");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


    public static class ThreadPrinterB implements Runnable {
        private String name;
        private Object obj;

        public ThreadPrinterB(String name, Object obj) {
            this.name = name;
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (true) {
                    System.out.println(name);
                    obj.notify();
                }
            }
        }
    }


    public static class ThreadPrinterC implements Runnable {
        private String name;
        private Object obj;
        public ThreadPrinterC(String name, Object obj) {
            this.name = name;
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj) {
                while (true) {
                    try {
                        System.out.println("C");
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object objA = new Object();
        Object objB = new Object();
        Object objC = new Object();
        ThreadPrinterA t1 = new ThreadPrinterA("A", objA);
        ThreadPrinterB t2 = new ThreadPrinterB("B", objB);
        ThreadPrinterC t3 = new ThreadPrinterC("C", objC);

    }

}
