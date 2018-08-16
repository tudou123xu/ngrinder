package org.ngrinder.common.util;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/**
 * Spring Security Utility functions.
 *
 * @author DongGyu Lee
 * @since 3.4.2
 */
public class SpringSecurityUtils {

    /**
     * Get current user authorities.
     */
    public static Collection<? extends GrantedAuthority> getCurrentAuthorities() {
        return (getContext().getAuthentication() != null) ? getContext().getAuthentication().getAuthorities() : new ArrayList<GrantedAuthority>();
    }

    /**
     * Check current user has specific authority.
     */
    public static boolean containsAuthority(Collection<? extends GrantedAuthority> authorities, String requiredAuth) {
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals(requiredAuth)) {
                return true;
            }
        }
        return false;
    }
}
