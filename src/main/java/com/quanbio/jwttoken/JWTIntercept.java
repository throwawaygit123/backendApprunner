package com.quanbio.jwttoken;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JWTIntercept  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Map<String,Object> map = new HashMap<>();
//        log.info("输入的token为：{{}}",token);
        try {
            JwtToken.verify(token);
            return true;
        }catch (SignatureVerificationException e){
            map.put("msg","invalid data！");
            e.printStackTrace();
        }catch (TokenExpiredException e){
            map.put("msg","token overdue！");
            e.printStackTrace();
        }catch (AlgorithmMismatchException e){
            map.put("msg","token Algorithm inconsistency");
            e.printStackTrace();
        }catch (Exception e){
            map.put("msg","token invalid!");
            e.printStackTrace();
        }
        map.put("state",false);
        String jsonStr = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(jsonStr);
        return false;
    }


}
