package com.devsuperior.hrpayroll.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.stereotype.Component;

@Component
public class ChildRibbonLoadBalancerClient extends RibbonLoadBalancerClient {

    public ChildRibbonLoadBalancerClient(SpringClientFactory clientFactory) {
        super(clientFactory);
    }

    @Override
    public <T> ServiceInstance choose(String serviceId, Request<T> hint) {
        ServiceInstance server = this.choose(serviceId);
        return server;
    }

}
