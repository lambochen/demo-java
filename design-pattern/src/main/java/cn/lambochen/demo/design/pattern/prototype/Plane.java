package cn.lambochen.demo.design.pattern.prototype;

/**
 * @author lambochen
 * @date 2022-04-04 13:39
 */
public class Plane implements Cloneable {

    private Long id;
    private String name;

    @Override
    protected Plane clone() {
        try {
            return (Plane) super.clone();
        } catch (CloneNotSupportedException e) {
            // todo
        }
        return null;
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
}
