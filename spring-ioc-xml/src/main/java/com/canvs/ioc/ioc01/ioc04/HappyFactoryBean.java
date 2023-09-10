package com.canvs.ioc.ioc01.ioc04;

import org.springframework.beans.factory.FactoryBean;

public class HappyFactoryBean implements FactoryBean<HappyMachine> {
    private String machineName;
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
    @Override
    public HappyMachine getObject() throws Exception {
        HappyMachine happyMachine = new HappyMachine();
        happyMachine.setMachineName(this.machineName);
        return happyMachine;
    }

    @Override
    public Class<?> getObjectType() {
        //返回要生产的对象的类型
        return HappyMachine.class;
    }
}
