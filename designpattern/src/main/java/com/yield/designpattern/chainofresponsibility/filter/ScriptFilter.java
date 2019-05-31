package com.yield.designpattern.chainofresponsibility.filter;

import com.yield.designpattern.chainofresponsibility.Request;
import com.yield.designpattern.chainofresponsibility.Response;
import com.yield.designpattern.chainofresponsibility.chain.MsgChain;

/**
 * @author yzd
 * @des
 * @date 2019/5/23
 */
public class ScriptFilter implements Filter {

    @Override
    public boolean doRequest(Request request, Response response, MsgChain chain) {

        System.out.println("script filter request handel...");
        String filterBody = request.getBody().replaceAll("<", "[").replaceAll(">", "]");
        request.setBody(filterBody);

        lastHandel(request, response, true);
        chain.doRequest(request, response, chain);

        System.out.println("script filter response handel... response body:" + response.getBody());
        return true;
    }

}
