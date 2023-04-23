package com.example.demo.repo;

import com.example.demo.model.TestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface TestRepo extends JpaRepository<TestDto, Long> {

    Stream<TestDto> findAllStream();

}
