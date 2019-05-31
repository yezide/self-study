package com.yield.designpattern.chainofresponsibility.filter;

import com.yield.designpattern.chainofresponsibility.Request;
import com.yield.designpattern.chainofresponsibility.Response;
import com.yield.designpattern.chainofresponsibility.chain.MsgChain;

/**
 * @author yzd
 * @des
 * @date 2019/5/23
 */
public class JavaFilter implements Filter{

    @Override
    public boolean doRequest(Request request, Response response, MsgChain chain) {

        System.out.println("Java filter request handel...");
        String filterBody = request.getBody().replaceAll("Java", ":)");
        request.setBody(filterBody);

        if(Math.random() > 0.5) {
            lastHandel(request, response, false);
            chain.doRequest(request, response, chain);
            System.out.println("Java filter response handel... response body:" + response.getBody());
        } else {
            System.out.println("Java filter response handel... response body:" + response.getBody());
            return false;
        }
        return true;
    }
}