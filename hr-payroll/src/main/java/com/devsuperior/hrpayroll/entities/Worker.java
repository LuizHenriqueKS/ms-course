package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;

}
