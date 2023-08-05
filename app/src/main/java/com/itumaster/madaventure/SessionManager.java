package com.itumaster.madaventure;

public class SessionManager {
    private static SessionManager instance;
    private String username; // Autres données de session peuvent être ajoutées ici

    private SessionManager() {
        // Initialisation
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setLoggedInUser(String username) {
        this.username = username;
    }

    public String getLoggedInUser() {
        return username;
    }
}

