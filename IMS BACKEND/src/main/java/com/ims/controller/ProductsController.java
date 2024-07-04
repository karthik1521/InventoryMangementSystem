package com.ims.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ims.entity.Products;
import com.ims.service.ProductsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Products")
public class ProductsController {
	
	@Autowired
	private ProductsService prodserv;
	
	@PostMapping("/createN")
	public Products AddnewProd(@RequestBody Products prdt)
	{
		return prodserv.newProd(prdt);
	}
	
	@GetMapping("/getall")
	public List<Products> getAll()
	{
		return prodserv.getAllProd();
	}
	
	@GetMapping("/getone/{pid}")
	public Optional<Products> getsinglePid(@PathVariable int pid)
	{
		return prodserv.getBypid(pid);
	}
	
	@DeleteMapping("/delt/{pid}")
	public void deletProd(@PathVariable Integer pid)
	{
		prodserv.deltProdu(pid);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> getCusById(@PathVariable int id)
	{
		Products products=prodserv.getsingleProdu(id);
		if(products==null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(products);
		}
	}
	
	@PutMapping("/updateprod/{id}")
	public ResponseEntity<Products>UpdateProtNew(@PathVariable int id,@RequestBody Products product)
	{
		Products prodts=prodserv.UpdateProt(id, product);
		if(prodts==null)
		{
			return ResponseEntity.notFound().build();
		}
		else
		{
			return ResponseEntity.ok(prodts);
		}
	}
	

}
