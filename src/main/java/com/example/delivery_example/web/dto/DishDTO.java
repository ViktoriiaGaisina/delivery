package com.example.delivery_example.web.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishDTO {

    private Long id;

    private String name;

    private BigDecimal price;
}
