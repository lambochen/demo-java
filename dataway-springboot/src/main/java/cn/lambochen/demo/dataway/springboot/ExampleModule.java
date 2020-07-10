package cn.lambochen.demo.dataway.springboot;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/5/11
 * @Description TODO
 **/
@DimModule
@Component
public class ExampleModule implements SpringModule {

    @Autowired
    private DataSource dataSource;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full, dataSource));
    }
}
