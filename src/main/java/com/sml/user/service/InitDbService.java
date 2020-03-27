package com.sml.user.service;

import com.sml.user.model.Employee;
import com.sml.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class InitDbService implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public InitDbService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setEmployeeName("Ann");
        employee.setEmployeeEmail("ann@live.com");
        employee.setEmployeeMobile("0917282332");

        userRepository.save(employee);
    }
}
