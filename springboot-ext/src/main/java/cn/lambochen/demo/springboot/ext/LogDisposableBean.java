package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 *
 * 时机：bean销毁时候
 */
@Component
public class LogDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("### DisposableBean.destroy");
    }
}
