package com.cos.jwt.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter3 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터3");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        System.out.println("필터1");

        req.setCharacterEncoding("UTF-8");

//        시큐리티가 동작하기전에 돌려야한다.
//        토큰:코스 id,pw가 정상적으로 들어와서 로그인이 완료되면 토큰을 만들어주고 응답
        // 요청할때마다 header에 Authorization으로 value 토큰 가지고온다.
        // 토큰이 넘어오는경우 이 토큰이 내가 만든 토큰인지 검증
        if(req.getMethod().equals("POST")){
            System.out.println("POST 요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println("headerAuth = " + headerAuth);

            if(headerAuth.equals("cos")){
                filterChain.doFilter(req, res);
            }else{
                PrintWriter outPrintWriter = res.getWriter();
                outPrintWriter.println("인증안됨");
            }
        }

    }
}
