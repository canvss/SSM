package com.canvs.ioc.ioc01;

public class ClientService {
    public static ClientService clientService = new ClientService();
    public static ClientService createInstance(){
        return clientService;
    }
}
