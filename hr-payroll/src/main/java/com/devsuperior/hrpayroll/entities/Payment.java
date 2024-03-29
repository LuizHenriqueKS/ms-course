package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return this.dailyIncome * this.days;
    }

}
