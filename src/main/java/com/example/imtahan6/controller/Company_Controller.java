package com.example.imtahan6.controller;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.CompanyNotFoundException;
import com.example.imtahan6.dto.Company_Dto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.service.Company_Interface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class Company_Controller {
    private final Company_Interface companyInterface;

    @GetMapping
    public List<Company_Dto> getAllCompany(@Valid @RequestBody Company_Dto dto) {
        return companyInterface.getAllCompany(dto);
    }
    @GetMapping("/id/{id}")
    public Company_Dto getFromId(@PathVariable Long id) throws NotFoundUserException{
        return companyInterface.getFromId(id);
    }

    @GetMapping("/{id}")
    public List<Users_Dto> allCompanyStaff(@Valid @PathVariable Long id) throws CompanyNotFoundException {
        return companyInterface.allCompanyStaff(id);
    }

    @PostMapping
    public Company_Dto createCompany(@Valid @RequestBody Company_Dto dto) throws AvailableException {
        return companyInterface.createCompany(dto);
    }

    @PutMapping("/{id}")
    public Company_Dto updatecompany(@Valid @PathVariable Long id, @Valid @RequestBody Company_Dto dto) throws CompanyNotFoundException {
        return companyInterface.updatecompany(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@Valid @PathVariable Long id) throws CompanyNotFoundException {
        companyInterface.deleteCompany(id);
    }
}
