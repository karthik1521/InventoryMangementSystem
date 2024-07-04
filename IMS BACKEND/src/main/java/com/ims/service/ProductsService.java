package com.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ims.entity.Products;
import com.ims.repo.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	public ProductsRepository prodrepo;
	
	public Products newProd(Products prod)
	{
		return prodrepo.save(prod);
	}
	
	public List<Products> getAllProd()
	{
		return prodrepo.findAll();
	}
	
	public Optional<Products> getBypid(int pid)
	{
		return prodrepo.findById(pid);
	}
	
	public void deltProdu(Integer pid)
	{
		prodrepo.deleteById(pid);
	}
	public Products getsingleProdu(int pid)
	{
		return prodrepo.findById(pid).orElse(null);
	}
	
	public Products UpdateProt(int id,Products prod)
	{
		Optional<Products> pro=prodrepo.findById(id);
		if(pro.isPresent())
		{
			Products prod1=pro.get();
			prod1.setPname(prod.getPname());
			prod1.setPquantity(prod.getPquantity());
			prod1.setPrice(prod.getPrice());
			prod1.setCategory(prod.getCategory());
			prod1.setSupplier(prod.getSupplier());
			prod1.setDateofpacking(prod.getDateofpacking());
			
			return prodrepo.save(prod1);
		}
		return null;
	}
}
