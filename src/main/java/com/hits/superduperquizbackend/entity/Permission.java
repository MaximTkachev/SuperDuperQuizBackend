package com.hits.superduperquizbackend.entity;

public enum Permission {
    ROLE_USER_PERMISSION("user"),
    ROLE_ADMIN_PERMISSION("admin");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
