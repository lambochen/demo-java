package cn.lambochen.demo.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author lambochen
 * @date 2022-08-07 18:09
 */
public class PerformMonitorTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        try {
            String currentClassName = className.replaceAll("/", ".");

            /**
             * TODO 此处可通过注册下需要过滤的类
             */

            System.out.println("transform: " + currentClassName);

            CtClass ctClass = ClassPool.getDefault().get(currentClassName);

            CtBehavior[] methods = ctClass.getDeclaredMethods();
            for (CtBehavior method : methods) {
                enhanceMethod(method);
            }

            return ctClass.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private void enhanceMethod(CtBehavior method) throws CannotCompileException {
        if (method.isEmpty()) {
            return;
        }

        String methodName = method.getName();
        if ("main".equalsIgnoreCase(methodName)) {
            return;
        }

        final StringBuilder source = new StringBuilder();
        source.append("{")
                // 前置增强: 打入时间戳
                .append("long start = System.nanoTime();\n")
                // 保留原有的代码处理逻辑
                .append("$_ = $proceed($$);\n")
                .append("System.out.print(\"method:[" + methodName + "]\");\n")
                // 后置增强
                .append("System.out.println(\" cost:[\" +(System.nanoTime() -start)+ \"ns]\");")
                .append("}");

        ExprEditor exprEditor = new ExprEditor() {
            @Override
            public void edit(MethodCall m) throws CannotCompileException {
                m.replace(source.toString());
            }
        };

        method.instrument(exprEditor);
    }
}
