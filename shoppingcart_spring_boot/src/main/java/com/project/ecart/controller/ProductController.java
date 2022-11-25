package com.project.ecart.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecart.controller.RequestPojo.ApiResponse;
import com.project.ecart.model.Category;
import com.project.ecart.model.Products;
import com.project.ecart.service.ProductService.ProductServices;

@RestController
@RequestMapping("api/product/")
public class ProductController {
	@Autowired
	ProductServices ProductServices;

	@PostMapping("saveCategory")
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		if (ProductServices.findByIdAndName(category.getId(), category.getName()) && ProductServices.findById(category.getId()) && ProductServices.findByName(category.getName())) {
			ProductServices.saveCategory(category);
			return ResponseEntity.ok(category);
		} else {
			return ResponseEntity.badRequest().body(new ApiResponse("Category is already listed!","Category ID and Name should be Unique"));
		}
	}
	
//	@DeleteMapping("deleteCategory")
//	public ResponseEntity<?> DeleteCategory(@RequestBody HashMap<String, String> request)
//	{
//		String category_id = request.get("cat_id");
//		ProductServices.deleteCategory(category_id);
//		
//	}

	@RequestMapping("getAll")
	public List<Products> getAllPRoducts() {
		return ProductServices.getAllProducts();
	}

	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory() {
		return ProductServices.getAllCategory();
	}

	@RequestMapping("getProductsByCategory")
	public List<Products> getProductsByCategory(@RequestBody HashMap<String, String> request) {
		String category_id = request.get("cat_id");
		return ProductServices.getProductsByCategory(category_id);
	}

	@GetMapping(value = "/getimage/{img_name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
		InputStream in = getClass().getResourceAsStream("/images/" + img_name);
		return IOUtils.toByteArray(in);
	}
}
