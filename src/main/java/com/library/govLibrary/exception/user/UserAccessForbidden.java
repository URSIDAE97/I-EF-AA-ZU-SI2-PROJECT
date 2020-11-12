package com.library.govLibrary.exception.user;

public class UserAccessForbidden extends RuntimeException {
    public UserAccessForbidden(String username) {
        super("{\n\"message\": \"No access for " + username + " user\"\n}");
    }
}
