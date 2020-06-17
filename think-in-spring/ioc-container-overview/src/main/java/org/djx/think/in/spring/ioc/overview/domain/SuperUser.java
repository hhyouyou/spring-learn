package org.djx.think.in.spring.ioc.overview.domain;

import org.djx.think.in.spring.ioc.overview.annotation.Super;

/**
 * @author dong jing xi
 * @date 2020/6/17 23:20
 **/
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
