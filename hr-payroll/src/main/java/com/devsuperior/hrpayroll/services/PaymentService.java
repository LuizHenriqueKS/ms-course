package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workId, int days) {
        return new Payment("Worker #" + workId, 100.0, days);
    }

}
