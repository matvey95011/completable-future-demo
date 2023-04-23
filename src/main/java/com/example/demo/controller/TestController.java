package com.example.demo.controller;

import com.example.demo.model.TestDto;
import com.example.demo.serivice.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @GetMapping
    public ResponseEntity<CompletableFuture<Stream<TestDto>>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
