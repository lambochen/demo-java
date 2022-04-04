package cn.lambochen.demo.design.pattern.builder;

/**
 * @author lambochen
 * @date 2022-04-04 18:20
 */
public class Product {

    private Long id;
    private String name;

    private Product() {
    }

    private Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;

        public Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Product build() {
            return new Product(id, name);
        }
    }
}
