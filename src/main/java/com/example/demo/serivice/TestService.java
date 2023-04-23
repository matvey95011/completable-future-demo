package com.example.demo.serivice;

import com.example.demo.model.TestDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public interface TestService {

    CompletableFuture<Stream<TestDto>> findAll();

}
