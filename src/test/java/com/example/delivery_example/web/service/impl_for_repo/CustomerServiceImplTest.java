package com.example.delivery_example.web.service.impl_for_repo;
import com.example.delivery_example.config.TestConfig;
import com.example.delivery_example.store.entity.CustomerEntity;
import com.example.delivery_example.store.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
class CustomerServiceImplTest {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void createTest() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .username("Semen34")
                .password("12345678")
                .email("kek@gmail.com")
                .build();
        CustomerEntity expected = CustomerEntity.builder()
                .id(1l)
                .username("Semen34")
                .password("12345678")
                .email("kek@gmail.com")
                .build();
        CustomerEntity actual = customerService.save(customerEntity);
        Assertions.assertEquals(expected, actual);
    }
}
