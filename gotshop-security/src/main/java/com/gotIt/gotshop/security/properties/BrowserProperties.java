package com.gotIt.gotshop.security.properties;


import com.gotIt.gotshop.security.enumer.LoginType;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
public class BrowserProperties {

    private String signUpUrl = "/signUp.html";

    private String loginPage = "/signIn.html";

    private String signOutUrl = "/signOut.html";

    private LoginType loginType = LoginType.JSON;

    private SessionProperties session = new SessionProperties();


    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignOutUrl() {
        return signOutUrl;
    }

    public void setSignOutUrl(String signOutUrl) {
        this.signOutUrl = signOutUrl;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }
}



