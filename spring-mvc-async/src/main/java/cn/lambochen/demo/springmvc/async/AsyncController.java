package cn.lambochen.demo.springmvc.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * @author lambo.chen
 * @date 2021/2/10
 **/
@RestController
public class AsyncController {

    @GetMapping("/hello")
    public CompletableFuture<User> hello(String name, Integer age) {
        return CompletableFuture.supplyAsync(() -> new User(name, age), Executors.newSingleThreadExecutor());
    }

    static class User {
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}
