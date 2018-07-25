package com.xmx.oa.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xmx.model.entity.Manager;
import com.xmx.model.entity.Product;

public interface ProductService {
	public int addProduct(Product p);
	public int deleteProduct(String id);
	public int updateProduct(Product p);
	//public List<Person> findAllPerson();
	public List<Product> findAllProduct();
	public List<Product> findByName(String name);
	public Product findById(String pid);
	//public List<Person> findByAge(Person p);
	//@Param(alias):��עDAO�ӿڷ����Ĳ�������ʾ��������map���ϵ���ʽ�ṩ
	public List<Product> findAllByPage(@Param("currentPage")int currentPage,@Param("psize")int psize);
	public int mutilDeleteProduct(int id[]);
	public int getRows();
	public Manager loginManager(String name);
}
