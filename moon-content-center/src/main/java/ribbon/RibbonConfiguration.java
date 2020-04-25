package ribbon;

import com.moon.content.center.framework.nacos.NacosWeightedRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: 无忧
 * @date: 2020-04-06 23:23
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRuld() {
        return new NacosWeightedRule();
    }
}
