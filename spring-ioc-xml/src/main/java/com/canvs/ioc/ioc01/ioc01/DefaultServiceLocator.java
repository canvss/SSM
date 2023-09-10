package com.canvs.ioc.ioc01.ioc01;

public class DefaultServiceLocator {
    public ClientService createClientService(){
        return new ClientService();
    }
}
