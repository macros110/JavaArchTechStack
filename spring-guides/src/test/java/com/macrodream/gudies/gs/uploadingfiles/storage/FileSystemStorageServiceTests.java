package com.macrodream.gudies.gs.uploadingfiles.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileSystemStorageServiceTests {

    private StorageProperties properties = new StorageProperties();
    private FileSystemStorageService service;

    @BeforeEach
    public void init(){
        properties.setLocation("target/files/"+Math.abs(new Random().nextLong()));
        service = new FileSystemStorageService(properties);
        service.init();
    }

    @Test
    public void loadNonExistent(){
        assertThat(service.load("foo.txt")).doesNotExist();
    }

    @Test
    public void saveAndLoad(){
        service.store(new MockMultipartFile("foo","foo.txt", MediaType.TEXT_PLAIN_VALUE,
                "Hello, World".getBytes()));
        assertThat(service.load("foo.txt")).exists();
    }

    @Test
    public void saveRelativePathNotPermitted(){
        assertThrows(StorageException.class, ()->{
            service.store(new MockMultipartFile("foo","../foo.txt",
                    MediaType.TEXT_PLAIN_VALUE,"Hello, World".getBytes()));
        });
    }

    @Test
    public void saveAbsolutePathNotPermitted(){
        assertThrows(StorageException.class, ()->{
            service.store(new MockMultipartFile("foo","D:\\tmp\\foo.txt",
                    MediaType.TEXT_PLAIN_VALUE,"Hello, World".getBytes()));
        });
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void saveAbsolutePathInFilenamePermitted(){
        String fileName = "D:\\tmp\\foo2.txt";
        service.store(new MockMultipartFile(fileName, fileName,
                MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
        assertTrue(Files.exists(
                Paths.get(properties.getLocation()).resolve(Paths.get(fileName))));
    }

    @Test
    public void savePermitted(){
        service.store(new MockMultipartFile("foo","bar/../foo.txt",
                MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
    }
}
