package com.devsuperior.hrpayroll.resources;

import java.util.concurrent.CompletableFuture;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/payments")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService paymentService;

    @CircuitBreaker(name = "hr-payment", fallbackMethod = "getPaymentAlternative")
    @TimeLimiter(name = "hr-payment")
    @GetMapping("/{workId}/days/{days}")
    public CompletableFuture<ResponseEntity<Payment>> getPayment(@PathVariable Long workId,
            @PathVariable Integer days) {
        return CompletableFuture.supplyAsync(() -> {
            Payment payment = paymentService.getPayment(workId, days);
            return ResponseEntity.ok(payment);
        });
    }

    public CompletableFuture<ResponseEntity<Payment>> getPaymentAlternative(Long workId, @PathVariable Integer days,
            Throwable cause) {
        return CompletableFuture.supplyAsync(() -> {
            Payment payment = Payment.builder().name("Brann")
                    .dailyIncome(400.0)
                    .days(days)
                    .build();
            return ResponseEntity.ok(payment);
        });
    }

}