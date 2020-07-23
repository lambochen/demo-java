package cn.lambochen.demo.javaagent.agent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/23
 * @description 字节码文件转换器/字节码转换器
 **/
public class MyTransformer implements ClassFileTransformer {

    final static String prefix = "\nlong startTime = System.currentTimeMillis();\n";
    final static String postfix = "\nlong endTime = System.currentTimeMillis();\n";


    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        // 过滤 JDK 方法
        if (className.startsWith("java") || className.startsWith("sun")) {
            return null;
        }

        className = className.replace("/", ".");
        CtClass ctClass = null;

        try {
            // 使用全称,用于取得字节码类<使用javassist>
            ctClass = ClassPool.getDefault().get(className);
            for (CtMethod ctMethod : ctClass.getDeclaredMethods()) {
                String methodName = ctMethod.getName();

                // 新定义一个方法叫做比如 execute$old
                String newMethodName = methodName + "$old";
                // 将原来的方法名字修改
                ctMethod.setName(newMethodName);

                // 创建新的方法，复制原来的方法，名字为原来的名字
                CtMethod newMethod = CtNewMethod.copy(ctMethod, methodName, ctClass, null);

                // 构建新的方法体
                StringBuilder bodyStr = new StringBuilder();
                bodyStr.append("{")
                        .append("System.out.println(\"==============Enter Method: " + className + "." + methodName + " ==============\");")
                        .append(prefix)
                        .append(newMethodName + "($$);\n")  // 调用原有代码，类似于method();($$)表示所有的参数
                        .append(postfix)
                        .append("System.out.println(\"==============Exit Method: " + className + "." + methodName + " Cost:\" +(endTime - startTime) +\"ms " + "===\");")
                        .append("}");

                System.out.println("JavaAgent new method: " + bodyStr.toString());

                // 替换新方法
                newMethod.setBody(bodyStr.toString());
                // 新增新方法
                ctClass.addMethod(newMethod);
            }

            return ctClass.toBytecode();
        } catch (CannotCompileException e) {
            // CtNewMethod.copy
            e.printStackTrace();
        } catch (NotFoundException e) {
            // ClassPool.getDefault().get
            e.printStackTrace();
        } catch (IOException e) {
            // ctClass.toBytecode
            e.printStackTrace();
        }
        return null;
    }
}
