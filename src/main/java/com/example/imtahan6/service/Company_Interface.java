package com.example.imtahan6.service;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.CompanyNotFoundException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.dto.Company_Dto;
import com.example.imtahan6.dto.Users_Dto;

import java.util.List;


public interface Company_Interface {
    public List<Company_Dto> getAllCompany(Company_Dto dto);
    public Company_Dto getFromId(Long id) throws NotFoundUserException;
    public Company_Dto createCompany(Company_Dto dto) throws AvailableException;
    public Company_Dto updatecompany(Long id, Company_Dto dto) throws CompanyNotFoundException;
    public void deleteCompany(Long id) throws CompanyNotFoundException;
    public List<Users_Dto> allCompanyStaff(Long id) throws CompanyNotFoundException;
}
