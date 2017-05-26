package org.qydata.tools.definexception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by jonhn on 2017/5/25.
 */
public class UserCustomerStatusNoPass extends AuthenticationException {

    private String retCd;
    private String msgDes;

    public UserCustomerStatusNoPass(String message) {
        super(message);
        this.msgDes = message;
    }

}
