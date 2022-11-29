package com.project.ecart.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.ecart.model.Category;

public interface CategoryRepo  extends JpaRepository<Category, Long> {

	

	Optional<Category> findByName(String name);

	Optional<Category> findByIdAndName(long id, String name);

//	@Query("delete cat FROM category cat WHERE cat.category_id=:cat_id")
//	void deleteById(@Param("cat_id")String cat_id);

}
