package cn.lambochen.demo.design.pattern.flyweight;

import cn.lambochen.demo.design.pattern.abstractfactory.product.Roach;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lambochen
 * @date 2022-04-05 14:20
 * <p>
 * 图件工厂
 */
public class TileFactory {

    // 图库
    private Map<String, Drawable> images;

    public TileFactory(Map<String, Drawable> images) {
        this.images = images;
    }

    public TileFactory() {
        images = new HashMap<>();
    }

    public Drawable get(String image) {
        if (!images.containsKey(image)) {
            switch (image) {
                case "river":
                    images.put(image, new River());
                    break;
                case "grass":
                    images.put(image, new Grass());
                    break;
                case "stone":
                    images.put(image, new Stone());
                    break;
            }
        }

        return images.get(image);
    }
}
