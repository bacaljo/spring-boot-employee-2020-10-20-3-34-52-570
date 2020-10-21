package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")

public class CompanyController {

    private final List<Company> companies = new ArrayList<>();

    @GetMapping
    public List<Company> getAll() {
        return companies;
    }

    @GetMapping("/{id}")
    public Company get(@PathVariable int id) {
        return companies.stream()
                .filter(company -> company.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
