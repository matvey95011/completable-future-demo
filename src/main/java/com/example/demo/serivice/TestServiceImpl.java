package com.example.demo.serivice;

import com.example.demo.model.TestDto;
import com.example.demo.repo.TestRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepo repo;

    @Async("executor")
    @Override
    public CompletableFuture<Stream<TestDto>> findAll() {
        return CompletableFuture.supplyAsync(repo::findAllStream);
    }


}
