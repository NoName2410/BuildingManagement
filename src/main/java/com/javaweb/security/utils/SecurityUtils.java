package com.javaweb.security.utils;

import com.javaweb.model.dto.MyUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//public class SecurityUtils {
//
//    public static MyUserDetail getPrincipal() {
//        return (MyUserDetail) (SecurityContextHolder
//                .getContext()).getAuthentication().getPrincipal();
//    }
//
//    public static List<String> getAuthorities() {
//        List<String> results = new ArrayList<>();
//        List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
//        for (GrantedAuthority authority : authorities) {
//            results.add(authority.getAuthority());
//        }
//        return results;
//    }
//}

public class SecurityUtils {

    // Method to get the authenticated user's principal
    public static MyUserDetail getPrincipal() {
        return (MyUserDetail) (SecurityContextHolder
                .getContext()).getAuthentication().getPrincipal();
    }

    // Method to retrieve the user's granted authorities as a list of strings
    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();

        // Get the authorities as a Collection, no need to cast to List
        Collection<? extends GrantedAuthority> authorities =
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        // Iterate over the authorities and extract the authority string
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }

        return results;
    }
}

