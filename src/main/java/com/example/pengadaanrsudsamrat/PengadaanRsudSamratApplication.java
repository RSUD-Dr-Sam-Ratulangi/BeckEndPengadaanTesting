package com.example.pengadaanrsudsamrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class PengadaanRsudSamratApplication {

    public static void main(String[] args) {

        SpringApplication.run(PengadaanRsudSamratApplication.class, args);
        Logger.getLogger("com.example").info("Hello, JUL!");

    }

}
