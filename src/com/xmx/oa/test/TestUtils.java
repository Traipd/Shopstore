package com.xmx.oa.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.xmx.model.entity.Product;
import com.xmx.oa.model.service.ProductService;
import com.xmx.oa.model.service.impl.ProductServiceImpl;
import com.xmx.oa.model.utils.MybatisUtils;

public class TestUtils {
@Test
public void test3(){
	//PersonDao p=new PersonDao();
	ProductService p=new ProductServiceImpl();
	List<Product>l1=p.findAllByPage(2, 3);
	for(Product s:l1){
		System.out.println(s.toString());
	}
	
}
@Test
public void test5() throws Exception{
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	 SqlSession session=MybatisUtils.getSqlSession();
	 //2.��ȡ��Ҫ�����Ľӿ�ʵ��
	 //ͨ�������ӿڶ�Ӧ��ӳ���ļ�������ӳ���ļ��е���������ȡ�ӿ�ʵ��
	 ProductService aa=session.getMapper(ProductService.class);
	 Product p=new Product("3","003","ŷ����","38","���ͽ���","2018-7-21");
	int i= aa.addProduct(p);
    session.commit();
	System.out.println(i);
}
@Test
public void test6(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	 SqlSession session=MybatisUtils.getSqlSession();
	 //2.��ȡ��Ҫ�����Ľӿ�ʵ��
	 //ͨ�������ӿڶ�Ӧ��ӳ���ļ�������ӳ���ļ��е���������ȡ�ӿ�ʵ��
	 ProductService aa=session.getMapper(ProductService.class);
	 
	int i= aa.deleteProduct("4");
    session.commit();
	System.out.println(i);
}
@Test
public void test7(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	 SqlSession session=MybatisUtils.getSqlSession();
	 //2.��ȡ��Ҫ�����Ľӿ�ʵ��
	 //ͨ�������ӿڶ�Ӧ��ӳ���ļ�������ӳ���ļ��е���������ȡ�ӿ�ʵ��
	 ProductService aa=session.getMapper(ProductService.class);
	 
	List<Product>list=aa.findAllByPage(2, 3);
    session.commit();
	for(Product p:list){
		System.out.println(p.toString());
	}
}
@Test
public void test8(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	 SqlSession session=MybatisUtils.getSqlSession();
	 //2.��ȡ��Ҫ�����Ľӿ�ʵ��
	 //ͨ�������ӿڶ�Ӧ��ӳ���ļ�������ӳ���ļ��е���������ȡ�ӿ�ʵ��
	 ProductService aa=session.getMapper(ProductService.class);
	 Product p=aa.findById("7");
    session.commit();
		System.out.println(p.toString());
	}
@Test
public void test9(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	ProductService ip=new ProductServiceImpl();
	List<Product>list=ip.findAllProduct();
	for(Product p:list){
		System.out.println(p.toString());
	}
}
@Test
public void test10(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	ProductService ip=new ProductServiceImpl();
	 int id[]={6,7};
	int i=ip.mutilDeleteProduct(id);
	 //int i=ip.deletePerson(5);
	System.out.println(i);
}

@Test
public void test12(){
	//1.Ϊ��ǰ���ݿ�����Ӳ�������һ���Ự
	ProductService ip=new ProductServiceImpl();
	//Person p=new Person(20,30);
	List<Product>list=ip.findByName("��");
	 for(Product p1:list){
		 System.out.println(p1.toString()); 
	 }
	
}
}


