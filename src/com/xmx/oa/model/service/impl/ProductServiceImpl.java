package com.xmx.oa.model.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xmx.model.entity.Manager;
import com.xmx.model.entity.Product;
import com.xmx.oa.model.service.ProductService;
import com.xmx.oa.model.utils.MybatisUtils;

public class ProductServiceImpl implements ProductService{
	 SqlSession session=MybatisUtils.getSqlSession();
	 //2.��ȡ��Ҫ�����Ľӿ�ʵ��
	 //ͨ�������ӿڶ�Ӧ��ӳ���ļ�������ӳ���ļ��е���������ȡ�ӿ�ʵ��
	 ProductService aa=session.getMapper(ProductService.class);
	@Override
	public int addProduct(Product p) {
		int i= aa.addProduct(p);
		session.commit();
		return i;
	}

	@Override
	public int deleteProduct(String id) {
		
		int i=aa.deleteProduct(id);
		session.commit();
		return i;
	}

	@Override
	public int updateProduct(Product p) {
		
		int i=aa.updateProduct(p);
		session.commit();
		return i;
	}


	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return aa.findById(id);
	}

	@Override
	public List<Product> findAllByPage(int currentPage, int psize) {
		// TODO Auto-generated method stub
		return aa.findAllByPage(currentPage, psize);
	}

	@Override
	public int mutilDeleteProduct(int[] id) {
		int t=0;
		for(int i=0;i<id.length;i++){
		//this.deleteProduct(id[i]);
		t++;
		}
		return t;
	}

	

	@Override
	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub

    List<Product>list= aa.findByName(name);
    session.commit();
    return list;
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return aa.findAllProduct();
	}

	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return aa.getRows();
	}

	@Override
	public Manager loginManager(String name) {
		// TODO Auto-generated method stub
		return aa.loginManager(name);
	}

	
}
