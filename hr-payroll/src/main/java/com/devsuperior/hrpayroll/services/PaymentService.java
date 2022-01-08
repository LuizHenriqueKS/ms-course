package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final WorkerService workerService;

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerService.getWorker(workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
