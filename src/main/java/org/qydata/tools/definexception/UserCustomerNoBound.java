package org.qydata.tools.definexception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Created by jonhn on 2017/5/25.
 */
public class UserCustomerNoBound extends AuthenticationException {

    private String retCd;
    private String msgDes;

    public UserCustomerNoBound(String message) {
        super(message);
        this.msgDes = message;
    }

}
