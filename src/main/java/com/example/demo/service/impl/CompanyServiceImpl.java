package com.example.demo.service.impl;

import com.example.demo.mapper.CompanyMapper;
import com.example.demo.model.EntityBt.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyServiceImpl implements CompanyService {
    public final CompanyRepository companyRepository;
    public final CompanyMapper companyMapper;

    @Override
    public Company add(Company company) {
      return  companyRepository.save(company);

    }
}
