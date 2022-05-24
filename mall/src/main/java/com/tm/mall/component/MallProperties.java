package com.tm.mall.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "mall")
@Data
public class MallProperties implements Serializable {
    private String title;
    private String content;
    private Integer count;
}
