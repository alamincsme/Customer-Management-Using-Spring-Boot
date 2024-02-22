package io.alamincsme.controller;

import io.alamincsme.model.Customer;
import io.alamincsme.service.CustomerNotFoundException;
import io.alamincsme.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public String showAllCustomer(Model model) {
        List<Customer> listCustomer = service.allCustomer();
        model.addAttribute("customer", listCustomer);
        return "customers";
    }

    @GetMapping("/new")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "newCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer) {
        service.save(customer);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateCustomer(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Customer customer = service.getId(id);
            model.addAttribute("customer", customer);
            return "newCustomer";

        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id , RedirectAttributes ra ) {
        try {
            service.deleteCustomer(id);
        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message", "deleted success!");
        }
        return "redirect:/";
    }


    @GetMapping("/search")
    public String customerSearch(@RequestParam("searchWord") String searchWord , Model model) {
        List<Customer> searchCustomer = service.search(searchWord);
        model.addAttribute("customer", searchCustomer);
        if (! searchWord.isEmpty()) {
            model.addAttribute("pageTitle" , "search for : " + searchWord);
        }
        return "customers";
    }
}
