package com.project.employeemanager;

import com.project.employeemanager.model.Employee;
import com.project.employeemanager.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping //("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}") //find/{id}
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping //("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employee1 =    employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.CREATED);
    }

    @PutMapping // ("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employee1 =    employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // delete/{{id}}
    @Transactional
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
