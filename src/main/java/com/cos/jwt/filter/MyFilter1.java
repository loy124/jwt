package com.cos.jwt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        filterChain.doFilter(servletRequest, servletResponse);

//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        System.o
//        ut.println("필터1");

        //req.setCharacterEncoding("UTF-8");

        //시큐리티가 동작하기전에 돌려야한다.
        //토큰:코스
//        if(req.getMethod().equals("POST")){
//            System.out.println("POST 요청됨");
//            String headerAuth = req.getHeader("Authorization");
//            System.out.println("headerAuth = " + headerAuth);
//
//            if(headerAuth.equals("cos")){
//                filterChain.doFilter(req, res);
//            }else{
//                PrintWriter outPrintWriter = res.getWriter();
//                outPrintWriter.println("인증안됨");
//            }
//        }



    }
}
