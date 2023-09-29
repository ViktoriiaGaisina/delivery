package com.example.delivery_example.web.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusOrderDTO {
    private Long id;
    private String name;
}
