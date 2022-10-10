package com.connectedcooking.opcua.dynamicnodemanager.core;

import java.util.Objects;

/**
 * Simple user context abstraction.
 */
// TODO check with Milo, potentially rename to DynUserContext
public class UserContext {

    private final String username;
    private final String credentials;
    private final String sessionName;

    /**
     * Creates a new user context.
     */
    public UserContext() {
        this(null, null, null);
    }

    /**
     * Creates a new user context.
     *
     * @param sessionName the session name
     */
    public UserContext(String sessionName) {
        this(null, null, sessionName);
    }

    /**
     * Creates a new user context.
     *
     * @param username    the username
     * @param credentials the credentials
     * @param sessionName the session name
     */
    public UserContext(String username, String credentials, String sessionName) {
        this.username = username;
        this.credentials = credentials;
        this.sessionName = sessionName;
    }

    /**
     * Getter for the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for the credentials.
     *
     * @return the credentials
     */
    public String getCredentials() {
        return credentials;
    }

    /**
     * Getter for the session name.
     *
     * @return the session name
     */
    public String getSessionName() {
        return sessionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserContext that = (UserContext) o;
        return Objects.equals(username, that.username) && Objects.equals(credentials, that.credentials) && Objects.equals(sessionName, that.sessionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, credentials, sessionName);
    }

    @Override
    public String toString() {
        return "UserContext{username='" + username + "', sessionName='" + sessionName + "'}";
    }
}
