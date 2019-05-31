package com.yield.designpattern.dynamicproxy.ASM;

/**
 * @author yzd
 * @des
 * @date 2019/5/30
 */
class MyClaasLoader extends ClassLoader {

    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }

}
