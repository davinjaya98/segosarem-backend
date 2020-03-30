package com.segosarem.web.webservices.db.service;

import com.segosarem.web.webservices.bean.GeneralWsResponseBean;

public interface AuthenticationService {

    public GeneralWsResponseBean authenticate(String username, String password, String token);
    public String getLatestToken();
}