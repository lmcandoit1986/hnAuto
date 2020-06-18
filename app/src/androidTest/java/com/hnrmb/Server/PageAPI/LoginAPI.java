package com.hnrmb.Server.PageAPI;

import com.hnrmb.Server.Request;

public class LoginAPI {

    public static String del_login_log(String phone){
        String rl = "http://10.211.4.118:8084/gsvCode?username="+phone;
        return Request.requestPostString(rl,"");
    }

}
