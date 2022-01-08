package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public Worker getWorker(long workId) {
        String url = this.workerHost + "/workers/{workerId}";
        Worker worker = restTemplate.getForObject(url, Worker.class, workId);
        return worker;
    }

}
