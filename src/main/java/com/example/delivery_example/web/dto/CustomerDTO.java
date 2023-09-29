package com.example.delivery_example.web.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    private Long id;

    private String username;

    private String email;

    private String password;
}
