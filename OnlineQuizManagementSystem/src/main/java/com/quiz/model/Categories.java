package com.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categories {
	@Id

	@Column(name="category_id")
	private int categories_id;     //categoryId
	@Column(name="category_name")
	private String categories_name;    //categoryName
	

public Categories() {

}

public Categories(int categories_id, String categories_name) {

	this.categories_id = categories_id;
	this.categories_name = categories_name;
}

public int getCategories_id() {
	return categories_id;
}
public void setCategories_id(int categories_id) {
	this.categories_id = categories_id;
}
public String getCategories_name() {
	return categories_name;
}
public void setCategories_name(String categories_name) {
	this.categories_name = categories_name;
}
@Override
public String toString() {
	return "Categories [categories_id=" + categories_id + ", categories_name=" + categories_name + "]";
}

}


