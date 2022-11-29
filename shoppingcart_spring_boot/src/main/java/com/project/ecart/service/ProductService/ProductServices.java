package com.project.ecart.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecart.Repository.CategoryRepo;
import com.project.ecart.Repository.ProductRepo;
import com.project.ecart.model.Category;
import com.project.ecart.model.Products;

@Service
public class ProductServices {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CategoryRepo cateRepo;

	public List<Products> getAllProducts() {
		return productRepo.findAll();
	}

	public List<Products> getProductsByCategory(String product_id) {
		return productRepo.getByCategoryId(product_id);
	}

	public List<Category> getAllCategory() {
		return cateRepo.findAll();
	}

	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() -> new Exception("Product is not found"));
	}

	public void saveCategory(Category category) {
		cateRepo.save(category);
	}

	public boolean findById(long id) {
		if (cateRepo.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean findByName(String name) {
		if (cateRepo.findByName(name).isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean findByIdAndName(long id, String name) {

		if (cateRepo.findByIdAndName(id, name).isEmpty()) {
			return true;
		}
		return false;
	}
}
