package com.chylee.demo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "/code")
public class DemoFilter implements Filter {
    private ObjectMapper objectMapper = new ObjectMapper();

    private RestTemplate restTemplate = new RestTemplateBuilder()
            .requestFactory(NoRedirectSimpleClientHttpRequestFactory.class)
            .setConnectTimeout(Duration.ofMillis(3000))
            .setReadTimeout(Duration.ofMillis(5000))
            .build();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        HttpSession session = request.getSession();

        String code = request.getParameter("code");
        if (code == null || code.trim().length() == 0) {
//            List<String> cookieList = new ArrayList<>();
//            Cookie[] cookies = request.getCookies();
//            for (int i = 0; i < cookies.length; i++)
//            {
//                cookieList.add(cookies[i].getName() + "=" + cookies[i].getValue());
//                System.out.println(cookies[i].getName() + "=" + cookies[i].getValue());
//            }
//
//            HttpHeaders header = new HttpHeaders();
//            header.put(HttpHeaders.COOKIE, cookieList);
//            Map<String,Object> param=new HashMap<>();
//            HttpEntity httpEntity = new HttpEntity(param, header);
            String s = URLEncoder.encode("http://192.168.1.109:9000/xx", "UTF-8");
            String url = "http://192.168.1.109:9001/code?redirect_url=" + s;
            response.sendRedirect(url);
//            ResponseEntity<String> entity = restTemplate.getForEntity(url,  String.class, httpEntity);
//            ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
//            if (entity.getStatusCode() == HttpStatus.FOUND) {
//                String location = entity.getHeaders().getLocation().toString();
//                Response resp = new Response();
//                resp.setData(location.split("code=")[1]);
//                response.setContentType("application/json");
//                response.setCharacterEncoding("utf-8");
//                response.getWriter().write(objectMapper.writeValueAsString(resp));
//            }
        }
        else {
            session.setAttribute("test_hahah", code);

            System.out.println(request.getSession().getId());

            Response resp = new Response();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(resp));
        }
    }
}
