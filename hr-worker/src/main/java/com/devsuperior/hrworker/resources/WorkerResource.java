package com.devsuperior.hrworker.resources;

import java.util.List;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.exception.BadRequestException;
import com.devsuperior.hrworker.repositories.WorkerRepository;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Log4j2
public class WorkerResource {

    private final Environment env;
    private final WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        log.info("PORT = {}", env.getProperty("local.server.port"));
        Worker obj = repository.findById(id).orElseThrow(() -> new BadRequestException("Worker not found"));
        return ResponseEntity.ok().body(obj);
    }
}
