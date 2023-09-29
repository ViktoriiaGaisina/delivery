package com.example.delivery_example.web.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
    private Long id;

    private String numberOfOrder;

    private Instant created = Instant.now();

    private List<DishDTO> dishDTOS = new ArrayList<>();

    private String statusName;

    private BigDecimal toPay;
}
