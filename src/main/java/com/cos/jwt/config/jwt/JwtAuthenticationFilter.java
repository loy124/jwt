package com.cos.jwt.config.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 스프링 시큐리티에 존재하는 필터로써
// /login 요청시 username, password를 POST로 전송하면 해당 필터가 동작한다.

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;

    // /login 요청을 하면 로그인시도를 위해 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("JWTAuthenticationFilter: 로그인 시도중");
//        1.username, password를 받아서
        try {
            System.out.println(request.getInputStream().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        2. 정산인지 로그인시도를 해보는, authenticationManger로 로그인 시도를 하면 PrincipalDetailsService 호출
//        3. LoaduserByUsername이 실행된다.
//        4. PrincipalDetails를 세션에 담고 JWT 토큰을 만들어서 응답. (세션을 만드는 이유는 세션을 공유함이 아니라 세션을 통해 권한관리를 하기 위함)
        return super.attemptAuthentication(request, response);
    }
}
