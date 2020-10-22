package com.thoughtworks.springbootemployee.integration;

import com.thoughtworks.springbootemployee.models.Employee;
import com.thoughtworks.springbootemployee.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeIntegrationTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void should_get_all_employees_when_get_all() throws Exception {
        //given
        Employee employee = new Employee(1, "Tom", 45, "male", 140000);
        employeeRepository.save(employee);

        //when
        //then
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employeeId").isNumber())
                .andExpect(jsonPath("$[0].name").value("Tom"))
                .andExpect(jsonPath("$[0].age").value(45))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].salary").value(140000));
    }

    @Test
    void should_create_employee_when_create_give_employee_request() throws Exception {
        //given
        String employeeAsJson = "{\n" +
                "\"name\": \"Chels\",\n" +
                "\"age\": 18,\n" +
                "\"gender\": \"female\",\n" +
                "\"salary\": 1000,\n" +
                "\"companyId\": 0\n" +
                "}";

        //when
        //then
        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeAsJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.employeeId").isNumber())
                .andExpect(jsonPath("$.name").value("Chels"))
                .andExpect(jsonPath("$.age").value(18))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(jsonPath("$.salary").value(1000))
                .andExpect(jsonPath("$.companyId").value(0));

        List<Employee> employee = employeeRepository.findAll();
        Assertions.assertEquals(1, employee.size());
        Assertions.assertEquals("Chels", employee.get(0).getName());
    }
}
