package cloud;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyZuulFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    /*
        pre filters are executed before the request is routed,
        route filters can handle the actual routing of the request,
        post filters are executed after the request has been routed, and
        error filters execute if an error occurs in the course of handling the request.
    */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("MyZuulFilter: %s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

}