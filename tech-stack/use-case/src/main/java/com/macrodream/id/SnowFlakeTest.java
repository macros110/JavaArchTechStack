package com.macrodream.id;

public class SnowFlakeTest {

    public static void generateIdsOneSecond() {
        SnowFlake idWorker = new SnowFlake(1,1);
        long start = System.currentTimeMillis();
        int i = 0;
        for (; System.currentTimeMillis() - start < 1000; i++) {
            //System.out.println(idWorker.nextId());
            idWorker.nextId();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println("生成id个数：" + i);
    }

    public static void main(String[] args) {
        generateIdsOneSecond();
    }
}
