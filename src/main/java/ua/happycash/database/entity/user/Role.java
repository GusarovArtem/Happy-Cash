package ua.happycash.database.entity.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    HOLDER,
    MANAGER,
    ADMIN,
    SUPER_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
