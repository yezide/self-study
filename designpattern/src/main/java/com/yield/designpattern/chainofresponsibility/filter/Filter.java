package com.yield.designpattern.chainofresponsibility.filter;

import com.yield.designpattern.chainofresponsibility.Request;
import com.yield.designpattern.chainofresponsibility.Response;
import com.yield.designpattern.chainofresponsibility.chain.MsgChain;

/**
 * @author yzd
 * @des
 * @date 2019/5/23
 */
public interface Filter {

    boolean doRequest(Request request, Response response, MsgChain chain);

    default void lastHandel(Request request, Response response, boolean isLast) {
        if(isLast) response.setBody(request.getBody());
    }

}
