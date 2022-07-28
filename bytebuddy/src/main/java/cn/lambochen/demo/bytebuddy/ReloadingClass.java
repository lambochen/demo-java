package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 * @author lambochen
 * @date 2022-07-29 00:02
 *
 * 重新加载类
 */
public class ReloadingClass {

    public static void main(String[] args) {
        // 安装 ByteBuddyAgent，另外还可以在启动命令通过 -javaagent 指定
        ByteBuddyAgent.install();

        Foo foo = new Foo();

        new ByteBuddy()
                .redefine(Bar.class)
                .name(Foo.class.getName())
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        // 此处会输出 bar 而非 foo
        System.out.println(foo.fun());
    }

    public static class Foo {
        public String fun() {
            return "foo";
        }
    }

    public static class Bar {
        public String fun() {
            return "bar";
        }
    }

}
