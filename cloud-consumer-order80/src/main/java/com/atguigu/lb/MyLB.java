package com.atguigu.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int  getRequestNum(){


        int current;
        int next ;
        do {
            current =atomicInteger.get();
            next = current < Integer.MAX_VALUE ? current+1 : 0;
        }while (!atomicInteger.compareAndSet(current,next));
        return current;
    }

    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> serviceInstances) {
        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        int index = getRequestNum() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
