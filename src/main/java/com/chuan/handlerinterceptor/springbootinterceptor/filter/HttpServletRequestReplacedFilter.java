package com.chuan.handlerinterceptor.springbootinterceptor.filter;


import com.chuan.handlerinterceptor.springbootinterceptor.filter.request.RequestReaderHttpServletRequestWrapper;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @description:
 * @author: diaoche
 * @create: 2019-11-18 14:01
 **/
public class HttpServletRequestReplacedFilter implements Filter, MultipartResolver {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        //判斷是否是文件上传
        boolean multipart = this.isMultipart((HttpServletRequest) request);
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest && !multipart) {
            requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
        }

        //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
        // 在chain.doFiler方法中传递新的request对象
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            chain.doFilter(requestWrapper, response);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return (request != null && ServletFileUpload.isMultipartContent(request));
    }

    @Override
    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
        return null;
    }

    @Override
    public void cleanupMultipart(MultipartHttpServletRequest request) {

    }
}
