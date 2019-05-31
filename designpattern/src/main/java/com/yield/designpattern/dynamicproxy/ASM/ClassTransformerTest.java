package com.yield.designpattern.dynamicproxy.ASM;

import org.objectweb.asm.*;

import java.util.Objects;

import static org.objectweb.asm.Opcodes.ASM4;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author yzd
 * @des 动态代理ASM底层实现
 * @date 2019/5/30
 */
public class ClassTransformerTest {

    public static void main(String[] args) throws Exception {
        /*ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/yield/designpattern/dynamicproxy/ASM/Tank.class"));*/

        ClassReader cr = new ClassReader("com/yield/designpattern/dynamicproxy/ASM/Tank");

        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                if(!Objects.equals(name, "move")) return super.visitMethod(access, name, descriptor, signature, exceptions);

                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);

                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/yield/designpattern/dynamicproxy/ASM/Aspect", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };
        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        MyClaasLoader c1 = new MyClaasLoader();
        //Class c = c1.loadClass("com.yield.designpattern.dynamicproxy.ASM.Tank");
        //c1.loadClass("com.yield.designpattern.dynamicproxy.ASM.Aspect");
        Class c2 = c1.defineClass("com.yield.designpattern.dynamicproxy.ASM.Tank", b2);
        Object obj = c2.getConstructor().newInstance();
        obj.getClass().getMethod("move").invoke(obj, null);

        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path + "/com/yield/designpattern/dynamicproxy/ASM/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/yield/designpattern/dynamicproxy/ASM/Tank@Proxy.class"));
        fos.write(b2);
        fos.flush();
        fos.close();

    }

}
