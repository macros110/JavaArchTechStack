package com.macrodream.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Macros.Zhang
 * @date 5/13/2022 07:48
 *
 * 监听文件系统目录变更
 *  bug JDK-8177809 File.lastModified() is losing milliseconds (always ends in 000)
 *  
 *
 */
public class WatchFileDir {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 10; i++) {
            String fileName = "D:/tmp/file_test/"+i;
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(i);
            fileWriter.close();
            long sleep = 1000 + ThreadLocalRandom.current().nextInt(500);
            Thread.sleep(sleep);
            File file = new File(fileName);
            System.out.println(fileName + " lastModified " + file.lastModified());
        }

        //testWatchDir();
    }

    private static void testWatchDir() throws InterruptedException, IOException {
        Thread thread = new Thread(() -> watchDir("D:/tmp/file_test"));
        thread.setDaemon(false);
        thread.start();
        Thread.sleep(500L);

        for (int i = 0; i < 3; i++) {
            String path = "D:/tmp/file_test/test";
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(i);
            fileWriter.close();
            File file = new File(path);
            System.out.println(file.lastModified());
            Thread.sleep(5);
        }
    }

    public static void watchDir(String dir) {
        Path path = Paths.get(dir);
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.OVERFLOW);
            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("create..." + System.currentTimeMillis());
                    } else if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("modify..." + System.currentTimeMillis());
                    } else if (watchEvent.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("delete..." + System.currentTimeMillis());
                    } else if (watchEvent.kind() == StandardWatchEventKinds.OVERFLOW) {
                        System.out.println("overflow..." + System.currentTimeMillis());
                    }
                }
                if (!key.reset()) {
                    System.out.println("reset false");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
