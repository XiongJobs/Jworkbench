package com.bjsxt.proxy;
import java.lang.reflect.Method;
public class Proxy1 implements com.bjsxt.proxy.test.UserMgr{
    public Proxy1(InvocationHandler h) {
        this.h = h;
    }
    com.bjsxt.proxy.InvocationHandler h;
@Override
public void addUser() {
    try {
    Method md = com.bjsxt.proxy.test.UserMgr.class.getMethod("addUser");
    h.invoke(this, md);
    }catch(Exception e) {e.printStackTrace();}
}
}