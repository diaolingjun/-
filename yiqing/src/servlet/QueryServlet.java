package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dao;
import entity.Info;




@SuppressWarnings("serial")
public class QueryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 这里是设置编码集，以避免出现乱码问题
         */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /**
         * 下面是获取从query.jsp页面传回的值
         */
        String Date=request.getParameter("Date");
        System.out.println(Date);
        /**
         * 实现服务的实例化
         */
        dao dao=new dao();
        List<Info> infos=dao.Query(Date);
        System.out.println(infos);
        request.setAttribute("infos",infos);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

