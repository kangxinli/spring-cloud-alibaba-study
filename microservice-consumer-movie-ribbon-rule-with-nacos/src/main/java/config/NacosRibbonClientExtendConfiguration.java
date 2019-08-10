package config;

import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ServerList;
import com.sample.app.ribbon.NacosRibbonServerList;


/**
 * 参考：org.springframework.cloud.alibaba.nacos.ribbon.NacosRibbonClientConfiguration
 */
@Configuration
public class NacosRibbonClientExtendConfiguration {
    @Bean
    public ServerList<?> ribbonServerList(IClientConfig config, NacosDiscoveryProperties nacosDiscoveryProperties) {
        NacosRibbonServerList serverList = new NacosRibbonServerList(nacosDiscoveryProperties);
        serverList.initWithNiwsConfig(config);
        return serverList;
    }
}
