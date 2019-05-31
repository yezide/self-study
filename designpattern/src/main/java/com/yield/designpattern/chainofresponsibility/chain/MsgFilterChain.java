package com.yield.designpattern.chainofresponsibility.chain;

import com.yield.designpattern.chainofresponsibility.Request;
import com.yield.designpattern.chainofresponsibility.Response;
import com.yield.designpattern.chainofresponsibility.filter.Filter;
import com.yield.designpattern.chainofresponsibility.filter.JavaFilter;
import com.yield.designpattern.chainofresponsibility.filter.ScriptFilter;
import com.yield.designpattern.chainofresponsibility.filter.PythonFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzd
 * @des
 * @date 2019/5/23
 */
public class MsgFilterChain implements MsgChain {

    private List<Filter> filters = new ArrayList();

    private int index = 0;

    @Override
    public boolean doRequest(Request request, Response response, MsgChain chain) {

        if(index >= filters.size()) return true;

        Filter f = filters.get(index);
        index ++;
        boolean toNext = f.doRequest(request, response, this);
        if(!toNext) {
            index = filters.size();
        }
        return true;
    }

    @Override
    public void addMsgFilter(Filter filter) {
        filters.add(filter);
    }

    public static void main(String[] args) {
        MsgChain msgChain = new MsgFilterChain();
        msgChain.addMsgFilter(new PythonFilter());
        msgChain.addMsgFilter(new JavaFilter());
        msgChain.addMsgFilter(new ScriptFilter());

        Request request = new Request();
        request.setBody("Python is a programming language that lets you <work more quickly and integrate your systems more effectively>. Java Platform, Standard Edition (Java SE) lets you develop and deploy Java applications on desktops and servers.");
        msgChain.doRequest(request, new Response(), msgChain);
    }

}
