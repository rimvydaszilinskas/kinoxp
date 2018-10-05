package antelopes.kinoxp.controllers;

import antelopes.kinoxp.models.Employee;
import antelopes.kinoxp.models.Snack;
import antelopes.kinoxp.repositories.EmployeeRepository;
import antelopes.kinoxp.repositories.SnackRepository;
import antelopes.kinoxp.utilities.ActiveUser;
import antelopes.kinoxp.utilities.PasswordHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@Controller
public class EmployeeController {
    private static final String URL_PATH = "/employees";
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private SnackRepository snackRepository= new SnackRepository();

    @GetMapping(URL_PATH + "/login")
    public String login(){
        return "employees/login";
    }

    @PostMapping(URL_PATH + "/login")
    public String login(@RequestParam("password")String password){
        Employee employee = employeeRepository.get("kinoxp");
        try{
            if(employee != null){
                if(PasswordHash.validatePassword(password, employee.getPassword())){
                    ActiveUser.login(employee);
                    return "redirect: /employees/employees";
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

    @GetMapping("/employees/snacksList")
    public String snacksList(Model model){
        model.addAttribute("snacks", snackRepository.getAll());
        return "employees/snacksList";
    }


    @GetMapping("/employees/updateSnacks")
    public String updateSnacks(@RequestParam("id") int snacksId, Model model) {

        Snack snack = snackRepository.get(snacksId);
        model.addAttribute("snack", snack);
        return "employees/updateSnacks";
    }
    @PostMapping("/employees/updateSnacks")
    public String updateSnacks(@ModelAttribute Snack snack) {

        snackRepository.update(snack);
        return "redirect:/employees/snacksList";
    }

    @GetMapping("/employees/deleteSnacks")
    public String deleteSnacks(@RequestParam("id") int snackId, Model model )
    {
        Snack snack = snackRepository.get(snackId);
        model.addAttribute("snack",snack);
        return "employees/deleteSnacks";
    }

    @PostMapping("/employees/deleteSnacks")
    public String deleteSnacks(@ModelAttribute Snack snack){
        snackRepository.delete(snack.getId());
        return "redirect:/employees/snacksList";
    }


 /*   @GetMapping("/employees/addSnacks")
    public String addSnacks() {
        return "employees/addSnacks";
    }

    @PostMapping("/employees/addSnacks")
    public String addSnacks(@ModelAttribute Snack snack) {
        snackRepository.create(snack);
        return "redirect: /employees/snacksList";
    }*/

    @GetMapping("/employees/addSnacks")
    public String addSnacks(){
        return "employees/addSnacks";
    }

    @PostMapping("/employees/addSnacks")
    public String addSnacks(@RequestParam("name")String name,
                           @RequestParam("price")String price){
        int p = Integer.parseInt(price);
        Snack snack = new Snack(name, p);
        snackRepository.create(snack);
        return "redirect:/employees/snacksList";
    }
}
