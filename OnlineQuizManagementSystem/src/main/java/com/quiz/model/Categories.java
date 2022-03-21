package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Categories is the Entity representing categories_table in database
 * 
 * @author Sanjana Salunke
 *
 */

@Entity
@Table(name = "category")
public class Categories {
	@Id

	@Column(name = "category_id")
	private int categoriesId;
	@Column(name = "category_name")
	private String categoriesName;

	/**
	 * Categories default Constructor
	 */

	public Categories() {

	}

	/**
	 * Course Constructor with fields as parameters
	 * 
	 * @param categoryId   the category Id
	 * @param categoryName the name of category
	 */
	public Categories(int categoriesId, String categoriesName) {
		super();
		this.categoriesId = categoriesId;
		this.categoriesName = categoriesName;
	}

	public int getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(int categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategoriesName() {
		return categoriesName;
	}

	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
//	@Override
//	public String toString() {
//		return "Categories [categoriesId=" + categoriesId + ", categoriesName=" + categoriesName + "]";
//	}

}
