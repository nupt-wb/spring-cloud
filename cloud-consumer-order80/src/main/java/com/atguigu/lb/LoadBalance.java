package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalance {

    ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances);
}
