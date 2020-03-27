package com.sml.user.controller;

import com.sml.user.model.Employee;
import com.sml.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping(value= "/add")
    public String create(@RequestBody Employee emp) {
        userService.createEmployee(emp);
        return "Employee records created.";
    }

    @GetMapping(value= "/all")
    public Collection<Employee> getAll() {
        return userService.getAllEmployees();
    }

    @GetMapping(value= "/{id}")
    public Optional<Employee> getById(@PathVariable(value= "id") int id) {
        return userService.findEmployeeById(id);
    }

    @PutMapping(value= "/update/{id}")
    public String update(@PathVariable(value= "id") int id, @RequestBody Employee employee) {
        employee.setId(id);
        userService.updateEmployee(employee);
        return "Employee record for employee-id= " + id + " updated.";
    }

    @DeleteMapping(value= "/remove/{id}")
    public String delete(@PathVariable(value= "id") int id) {
        userService.deleteEmployeeById(id);
        return "Employee record for employee-id= " + id + " deleted.";
    }
}
