package cn.springscloud.springdeeplearning.web.servlet3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kim QQ.Cong on 2019-09-05 / 13:24
 *
 * @author: CongQingquan
 * @Description:
 */
//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.getWriter().print("Hello man, this is Kim !");
    }
}