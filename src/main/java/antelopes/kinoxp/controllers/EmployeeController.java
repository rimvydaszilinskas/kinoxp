package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Employee;
import antelopes.kinoxp.repositories.EmployeeRepository;
import antelopes.kinoxp.utilities.ActiveUser;
import antelopes.kinoxp.utilities.PasswordHash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    private static final String URL_PATH = "/employees";
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @GetMapping(URL_PATH + "/login")
    public String login(){
        return "employees/login";
    }

    @PostMapping(URL_PATH + "/login")
    public String login(@RequestParam("password")String password){
        Employee employee = employeeRepository.get("kinoxp");
        System.out.println(employee.getPassword());
        try{
            if(employee != null){
                if(PasswordHash.validatePassword(password, employee.getPassword())){
                    ActiveUser.login(employee);
                    return "employees/employees";
                }
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        // TODO create a link to the other page
        return "employees/login";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, path = URL_PATH + "/logout")
    public String logout(){
        ActiveUser.logout();
        return "index";
    }
}
