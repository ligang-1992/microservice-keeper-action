package com.moon.content.center.framework.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbon.RibbonConfiguration;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 23:21
 */
@Configuration
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class UserCenterRibbonConfiguration {

}
