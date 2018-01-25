package com.padc.tunlinaung.burpplefoodstore.network.responses;

/**
 * Created by eidoshack on 1/25/18.
 */

public interface LoginDataAgent {

    /**
     * login user
     * @param phoneNo
     * @param password
     */
    void loginUser(String phoneNo, String password);

    /**
     * register user
     * @param phoneNo
     * @param password
     * @param name
     */
    void registerUser(String phoneNo, String password, String name);

}
