package com.example.delivery_example.web.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardDTO {

    private Long id;

    private String nameOwner;

    private String cardNumber;

    private LocalDateTime expiryDate;

    private String cvv;

    private BigDecimal balance;
}
