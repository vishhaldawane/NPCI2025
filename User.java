package com.vishal.demo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a user in the system with security details.
 * 
 * 
 * Download the lombok jar.
https://search.maven.org/remotecontent?filepath=org/projectlombok/lombok/1.18.4/lombok-1.18.4.jar.

Execute in cmd prompt, like open cmd prompt in jar location. run java -jar jarname.

Restart the IDE, It will work fine.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
    // Delimiter used to split authorities string
    private static final String AUTHORITIES_DELIMITER = "::";

    // Unique identifier for the user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Username of the user
    private String username;

    // Password of the user
    private String password;

    // Authorities granted to the user, stored as a single string
    private String authorities;

    /**
     * Returns the authorities granted to the user.
     * @return a collection of GrantedAuthority objects
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Split the authorities string and convert to a list of SimpleGrantedAuthority objects
        return Arrays.stream(this.authorities.split(AUTHORITIES_DELIMITER))
                     .map(SimpleGrantedAuthority::new)
                     .collect(Collectors.toList());
    }

    /**
     * Returns the password used to authenticate the user.
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user.
     * @return the username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Indicates whether the user's account has expired.
     * @return true if the account is non-expired, false otherwise
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     * @return true if the account is non-locked, false otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials have expired.
     * @return true if the credentials are non-expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled.
     * @return true if the user is enabled, false otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
    
    
}
