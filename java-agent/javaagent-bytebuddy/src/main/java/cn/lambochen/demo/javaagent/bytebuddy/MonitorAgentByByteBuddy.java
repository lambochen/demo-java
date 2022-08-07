package cn.lambochen.demo.javaagent.bytebuddy;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * @author lambochen
 * @date 2022-08-07 18:43
 */
public class MonitorAgentByByteBuddy {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("MonitorAgentByByteBuddy args: " + args);

        AgentBuilder.Transformer transformer = (builder, typeDescription, classLoader) -> {
            return builder.method(ElementMatchers.any()) // 拦截任意方法
                    .intercept(MethodDelegation.to(TimeInterceptor.class)); // 委托给 TimeInterceptor
        };

        AgentBuilder.Listener listener = new AgentBuilder.Listener() {
            @Override
            public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule, DynamicType dynamicType) {

            }

            @Override
            public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {

            }

            @Override
            public void onError(String s, ClassLoader classLoader, JavaModule javaModule, Throwable throwable) {

            }

            @Override
            public void onComplete(String s, ClassLoader classLoader, JavaModule javaModule) {

            }
        };

        new AgentBuilder.Default()
                // 指定需要拦截的类
                .type(ElementMatchers.nameStartsWith("cn.lambochen.demo"))
                .transform(transformer)
                .with(listener)
                .installOn(instrumentation);
    }
}
