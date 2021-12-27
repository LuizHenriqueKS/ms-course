package com.devsuperior.hrpayroll.resources;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping("/{workId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workId, @PathVariable Integer days) {
        Payment payment = paymentService.getPayment(workId, days);
        return ResponseEntity.ok(payment);
    }

}
