package com.xmx.oa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xmx.model.entity.Manager;
import com.xmx.model.entity.Product;
import com.xmx.oa.model.service.ProductService;
import com.xmx.oa.model.service.impl.ProductServiceImpl;


/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
       private int pageSize = 10;
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method1 = request.getParameter("method");
		System.out.println(method1);
        if(method1.equals("add")){
       	 addServlet(request,response);
        }else if(method1.equals("all")){
       	 findServlet1(request,response);
        }else if(method1.equals("delete1")){
        	//-------------start---------------------

            deleteServlet1(request,response);
     //--------------end----------------------
             }  else if(method1.equals("deletemore")){
            	 System.out.println("can in deletemore");
             	deletemoreServlet(request,response);
                }else if(method1.equals("find")){
         findServletProducts(request,response);
        }else if(method1.equals("loginServlet")){
         loginServlet(request,response);
        }else if(method1.equals("edit")){
         editServlet(request,response);
        }else if(method1.equals("editoperation")){
         editServlet1(request,response);
        }
	}
	private void editServlet1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//2.��ȡ����
		String pid=request.getParameter("pid");
		System.out.println(pid);
		String category=request.getParameter("category");
		String pname=request.getParameter("pname");
		String pprize=request.getParameter("pprize");
		String introduction=request.getParameter("introduction");
		String rigdate=request.getParameter("rigdate");
		//3.��װ��һ������
		
		
		pid = new String(pid.getBytes("ISO8859_1"), "UTF-8");
		category = new String(category.getBytes("ISO8859_1"), "UTF-8");
		pname = new String(pname.getBytes("ISO8859_1"), "UTF-8");
		pprize = new String(pprize.getBytes("ISO8859_1"), "UTF-8");
		introduction = new String(introduction.getBytes("ISO8859_1"), "UTF-8");
		rigdate = new String(rigdate.getBytes("ISO8859_1"), "UTF-8");
		
		Product p=new Product(pid,category,pname,pprize,introduction,rigdate);
		System.out.println(p.toString());
		//4.����һ���ӿڶ���
		ProductService ip=new ProductServiceImpl();
		   ip.updateProduct(p);
			findServlet(request,response);
	}
	
	private void editServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductService ip = new ProductServiceImpl();
		String pid = request.getParameter("productid");
		System.out.println(pid);
		Product p = ip.findById(pid);
		System.out.println(p.getPname());
		
		pid = new String(pid.getBytes("ISO8859_1"), "UTF-8");
		
		request.setAttribute("pid", pid);
		request.setAttribute("product", p);
		request.getRequestDispatcher("/files/editproduct.jsp").forward(request, response);
	}
	
	private void deleteServlet1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("productid");
		//2.创建一个接口对象
		ProductService ip=new ProductServiceImpl();
		System.out.println("productid="+id);
		int i=ip.deleteProduct(id);
		if(i>0){
			findServlet(request,response);
		}
		else{
			request.getRequestDispatcher("files/addProduct.jsp").forward(request, response);
		}
		
	}
	private void deletemoreServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("can in deletemore Servlet");
		ProductService ip=new ProductServiceImpl();
		String selectlength=request.getParameter("selectlength");
		for(int i=0;i<Integer.parseInt(selectlength);i++)
		{
			String id=request.getParameter("productid"+i);
			if(id!=null)
			{
			  ip.deleteProduct(id);
			  System.out.println("delete:"+id);
			}
			
		}
		findServlet(request,response);
		
	}
	
	private void loginServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductService ip=new ProductServiceImpl();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Manager m=ip.loginManager(id);
		if(m!=null&&m.getPassword().equals(password) == true){
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
	
	private void findServletProducts(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			//��������ѯ����ҳ��
					//��ȡ���е��ܼ�¼��
			ProductService ip=new ProductServiceImpl();   
					
					String requestName = request.getParameter("pname");
					List<Product> products = ip.findByName(requestName);
					int totalPages = 1;
					request.setAttribute("list", products);
					//}
					//����ҵ���߼����еķ�ҳ��ѯ��������ȡ��ѯ�Ľ����
					//����ѯ���������request�洢��Χ��.
					request.setAttribute("totalPages", totalPages);
					request.setAttribute("currentPage",totalPages);
					//ת������ʾҳ��
					request.getRequestDispatcher("/files/listProduct.jsp")
					.forward(request, response);
	}
	
	private void deleteServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productid");
		//2.����һ���ӿڶ���
		ProductService ip=new ProductServiceImpl();
		int i=ip.deleteProduct(id);
		if(i>0){
			findServlet(request,response);
		}
		else{
			request.getRequestDispatcher("files/addProduct.jsp").forward(request, response);
		}
		
	}


private void findServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		//1.���ñ���
	   request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	//2.����һ���ӿڶ���
		ProductService ip=new ProductServiceImpl();
	//3.���ò�ѯ����
		 List<Product>list=ip.findAllProduct();
	//4.���浽request��
		  request.setAttribute("list", list);
		 //5.��ת��listPerson.jsp
		  request.getRequestDispatcher("files/listProduct.jsp").forward(request, response);
	
	
	}

	private void findServlet1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//��������ѯ����ҳ��
				//��ȡ���е��ܼ�¼��
		ProductService ip=new ProductServiceImpl();   
				int rows =ip.getRows();
				//�����ҳ��ѯ����ҳ��
				System.out.println("rows="+rows);
				int totalPages = rows/pageSize;
				System.out.println("totalPages="+totalPages);
				if(rows % pageSize !=0)
					totalPages ++;
				
				/*��ȡ��ǰҳ(Ĭ�ϵ�һҳ)
				//int currentPage  =1 ;
				//��ȡ�ͻ��˲�ѯ��ҳ��������
				//String requestPage =request.getParameter("currentpage");
				//if(requestPage != null){
					// currentPage = Integer.parseInt(requestPage);*/
				int requestPage =Integer.parseInt(request.getParameter("currentpage"));
				System.out.println("currentpage="+requestPage);
				//}
				//����ҵ���߼����еķ�ҳ��ѯ��������ȡ��ѯ�Ľ����
				List<Product> products =ip.findAllByPage(pageSize*requestPage-pageSize, pageSize);
				//����ѯ���������request�洢��Χ��.
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("currentPage", requestPage);
				request.setAttribute("list", products);
				
				//ת������ʾҳ��
				request.getRequestDispatcher("/files/listProduct.jsp")
				.forward(request, response);
	}



public void addServlet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	//1.���ñ���
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			//2.��ȡ����
			String pid=request.getParameter("pid");
			String category=request.getParameter("category");
			String pname=request.getParameter("pname");
			String pprize=request.getParameter("pprize");
			String introduction=request.getParameter("introduction");
			String rigdate=request.getParameter("rigdate");
			//3.��װ��һ������
			
			pid = new String(pid.getBytes("ISO8859_1"), "UTF-8");
			category = new String(category.getBytes("ISO8859_1"), "UTF-8");
			pname = new String(pname.getBytes("ISO8859_1"), "UTF-8");
			pprize = new String(pprize.getBytes("ISO8859_1"), "UTF-8");
			introduction = new String(introduction.getBytes("ISO8859_1"), "UTF-8");
			rigdate = new String(rigdate.getBytes("ISO8859_1"), "UTF-8");
			
			String currentpage = "1";
			
			request.setAttribute("currentpage", currentpage);
			
			Product p=new Product(pid,category,pname,pprize,introduction,rigdate);
			System.out.println(p.toString());
			//4.����һ���ӿڶ���
			ProductService ip=new ProductServiceImpl();
			   ip.addProduct(p);
				findServlet(request,response);
			   
			
		
			
}

}
