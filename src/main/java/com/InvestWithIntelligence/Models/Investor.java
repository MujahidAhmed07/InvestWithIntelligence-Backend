package com.InvestWithIntelligence.Models;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "investor_data")
public class Investor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "investor_id")
    private Long id;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "investor_username")
    private String username;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "investor_email")
    private String email;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "investor_password")
    private String password;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "role")
    // @Enumerated(EnumType.STRING)
    private String role = "INVESTOR";

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_meta_id")
    private InvestorMetadata investorMetadata;

    public Investor(Long id, String username, String email, String password,
            InvestorMetadata investorMetadata) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.investorMetadata = investorMetadata;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return a collection of authorities (roles) for this user
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
