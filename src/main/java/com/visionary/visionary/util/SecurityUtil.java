package com.visionary.visionary.util;

import com.visionary.visionary.config.security.Roles;
import com.visionary.visionary.domain.User;
import com.visionary.visionary.model.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static UserPrincipal getCurrentUser() {
        return (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static boolean currentUserHasHigherAuthority(User user) {
        return getCurrentUser().getAuthorities()
                .stream()
                .anyMatch(grantedAuthority ->
                        Roles.valueOf(grantedAuthority.getAuthority()).compareTo(user.getRoles()) > 0);
    }

    public static boolean isCurrentUserOrHigherAuthority(User user) {
         return isCurrentUser(user) || currentUserHasHigherAuthority(user);
    }

    public static boolean isCurrentUser(User user) {
        return getCurrentUser().getUsername().equals(user.getEmailAddress());
    }
}
