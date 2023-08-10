package com.example.imtahan6.service.impl;

import com.example.imtahan6.exceptions.AvailableException;
import com.example.imtahan6.exceptions.CompanyNotFoundException;
import com.example.imtahan6.exceptions.NotFoundUserException;
import com.example.imtahan6.dto.Company_Dto;
import com.example.imtahan6.dto.Users_Dto;
import com.example.imtahan6.entity.Company;
import com.example.imtahan6.entity.Users;
import com.example.imtahan6.mapper.Company_Map;
import com.example.imtahan6.mapper.Users_Map;
import com.example.imtahan6.repository.Company_Repository;
import com.example.imtahan6.repository.Users_Repository;
import com.example.imtahan6.service.Company_Interface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Company_Service implements Company_Interface {
    private final Company_Map map;
    private final Users_Map usersMap;
    private final Company_Repository repository;
    private final Users_Repository usersRepository;

    @Transactional
    @Override
    public List<Company_Dto> getAllCompany(Company_Dto dto) {
        Company company = map.toEntity(dto);
        List<Company> companies = repository.findAll();
        return map.toDtoList(companies);
    }

    @Transactional
    @Override
    public Company_Dto getFromId(Long id) throws NotFoundUserException {
        Company company = repository.findById(id).get();
        if (company == null) {
            throw new NotFoundUserException("This company is not available");
        }
        return map.toDto(company);
    }

    @Transactional
    @Override
    public Company_Dto createCompany(Company_Dto dto) throws AvailableException {
        if (repository.existsByName(dto.getName())) {
            throw new AvailableException("This company is available");
        }
        return map.toDto(repository.save(map.toEntity(dto)));
    }

    @Transactional
    @Override
    public Company_Dto updatecompany(Long id, Company_Dto dto) throws CompanyNotFoundException {
        Optional<Company> existingCompanyOptional = repository.findById(id);
        if (existingCompanyOptional.isPresent()) {
            Company existingCompany = existingCompanyOptional.get();
            existingCompany.setName(dto.getName());
            existingCompany.setCreate_date(dto.getCreate_date());
            existingCompany.setId(dto.getId());
            Company updatedCompany = repository.save(existingCompany);
            return map.toDto(updatedCompany);
        } else {
            throw new CompanyNotFoundException("This company is not available");
        }
    }

    @Transactional
    @Override
    public void deleteCompany(Long id) throws CompanyNotFoundException {
        Optional<Company> existingCompanyOptional = repository.findById(id);
        if (existingCompanyOptional.isPresent()) {
            Company existingCompany = existingCompanyOptional.get();
            repository.delete(existingCompany);
        } else {
            throw new CompanyNotFoundException("This company is not available");
        }
    }

    @Transactional
    @Override
    public List<Users_Dto> allCompanyStaff(Long id) throws CompanyNotFoundException {
        Company company = repository.findById(id).get();
        if (company == null) {
            throw new CompanyNotFoundException("This company is not available");
        }
        List<Users> usersList = company.getUsersList();
        return usersMap.mapUsersToDtoList(usersList);
    }
}
