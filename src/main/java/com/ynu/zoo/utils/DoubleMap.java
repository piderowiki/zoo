package com.ynu.zoo.utils;

import io.netty.channel.Channel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class DoubleMap {
    private Map<Channel,String> remoteAddressToNameMap = new HashMap<>();
    private Map<String,Channel> nameToRemoteAddressMap = new HashMap<>();

    public String get(Channel address){
        return remoteAddressToNameMap.get(address);
    }

    public Channel get(String name){
        return nameToRemoteAddressMap.get(name);
    }

    public void put(String name,Channel address){
        nameToRemoteAddressMap.put(name,address);
        remoteAddressToNameMap.put(address,name);
    }

    public void remove(Channel address){
        // 获取name
        String name = get(address);
        nameToRemoteAddressMap.remove(name);
        remoteAddressToNameMap.remove(address);
    }
}
