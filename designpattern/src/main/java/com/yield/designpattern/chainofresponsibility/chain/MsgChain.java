package com.yield.designpattern.chainofresponsibility.chain;

import com.yield.designpattern.chainofresponsibility.Request;
import com.yield.designpattern.chainofresponsibility.Response;
import com.yield.designpattern.chainofresponsibility.filter.Filter;

/**
 * @author yzd
 * @des
 * @date 2019/5/23
 */
public interface MsgChain {

    boolean doRequest(Request request, Response response, MsgChain chain);

    void addMsgFilter(Filter filter);

}
