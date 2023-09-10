package com.canvs.ioc.ioc01.ioc04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class CommonComponent {
    //${key} 取外部配置key对应的值
    //${key:defaultValue} 没有key,可以给与默认值
    @Value("${name:root}")
    private String name;
    private String city;

    @Value("${city:上海}")
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CommonComponent{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

