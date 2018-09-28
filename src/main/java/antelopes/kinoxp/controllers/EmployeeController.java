package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Employee;
import antelopes.kinoxp.repositories.EmployeeRepository;
import antelopes.kinoxp.utilities.ActiveUser;
import antelopes.kinoxp.utilities.PasswordHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    private static final String URL_PATH = "/employees";
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping(URL_PATH + "/login")
    public String login(){
        return "employees/login";
    }

    @GetMapping(URL_PATH + "/register")
    public String register(){
        // TODO make a register page for employees
        return null;
    }

    @PostMapping(URL_PATH + "/register")
    public String register(@RequestParam("name")String name, @RequestParam("username")String username, @RequestParam("password")String password){
        try{
            String hashedPasword = PasswordHash.generatePassword(password);
            Employee employee = new Employee(username, hashedPasword, name);
            if(!employeeRepository.create(employee)){
                // TODO create a redirect back to register page
                return null;
            }
        } catch (Exception ex){
            ex.printStackTrace();
            // TODO create an error page
        }

        return "employees/employees";
    }

    @PostMapping(URL_PATH + "/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password){
        Employee employee = employeeRepository.get(username);
        try{
            if(employee != null){
                if(PasswordHash.validatePassword(password, employee.getPassword())){
                    ActiveUser.login(employee);
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        // TODO create a link to the other page
        return null;
    }
}