package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DomainForm;
import com.example.repository.CalcuMapper;



@Service
public class CalcuService {

	@Autowired
	public CalcuMapper calcuMapper;

	@Transactional
	public List<DomainForm> findAll() {
		return calcuMapper.findAll();

	}

	@Transactional
	public DomainForm findOne(String id) {
		return calcuMapper.findONE(id);

	}

	@Transactional
	public void save(DomainForm domainform) {
		calcuMapper.save(domainform);
	}

	@Transactional
    public void update(DomainForm domainform) {
        calcuMapper.update(domainform);
    }


	@Transactional
	public void delete(String id) {
		calcuMapper.delete(id);
	}

}