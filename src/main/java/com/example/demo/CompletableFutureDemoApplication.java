package com.example.demo;

import com.example.demo.model.TestDto;
import com.example.demo.repo.TestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@EnableAsync
@SpringBootApplication
@RequiredArgsConstructor
public class CompletableFutureDemoApplication {

    private final TestRepo repo;

    public static void main(String[] args) {
        SpringApplication.run(CompletableFutureDemoApplication.class, args);
    }

    @Bean("executor")
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            List<TestDto> dtos = IntStream.range(0, 10000)
                    .mapToObj(this::createDto)
                    .collect(Collectors.toList());

            repo.saveAll(dtos);
        };
    }

    private TestDto createDto(int it) {
        TestDto dto = new TestDto();

        dto.setMessage("Message " + it);

        return dto;
    }

}
