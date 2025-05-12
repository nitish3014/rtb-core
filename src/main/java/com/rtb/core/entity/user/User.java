package com.rtb.core.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(20) default 'active'")
    private String status = "active";

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @ManyToMany (cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(name = "user_subscriptions",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "subscription_id")})
    private Set<Subscription> subscription = new HashSet<>();

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
        joinColumns = {@JoinColumn (name = "user_id")},
        inverseJoinColumns = {@JoinColumn (name = "role_id")})
    private Set<Role> role = new HashSet<>();

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "verified", nullable = false)
    private boolean verified;

    @Column(name = "tenant_id")
    private Long tenantId;

    @Column(name = "apple_id")
    private String appleId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_details_id", referencedColumnName = "id", nullable = false, unique = true)
    private UserDetails userDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();


    public User() {
        UserDetails newUserDetails = new UserDetails();
    }

    public User(String firstName, String lastName, String email,
                String password, String username, Long tenantId) {
        UserDetails newUserDetails = new UserDetails();

        newUserDetails.setFirstName(firstName);
        newUserDetails.setLastName(lastName);
        newUserDetails.setEmail(email);
        newUserDetails.setPassword(password);
        newUserDetails.setUsername(username);

        this.userDetails = newUserDetails;

        this.tenantId = tenantId;
    }

    public User(String firstName, String lastName, String email,
                String password, String username, Long tenantId, String appleId) {
        UserDetails newUserDetails = new UserDetails();

        newUserDetails.setFirstName(firstName);
        newUserDetails.setLastName(lastName);
        newUserDetails.setEmail(email);
        newUserDetails.setPassword(password);
        newUserDetails.setUsername(username);

        this.userDetails = newUserDetails;

        this.tenantId = tenantId;
        this.appleId = appleId;
    }

    public String getFirstName() {
        return this.userDetails.getFirstName();
    }

    public String getLastName() {
        return this.userDetails.getLastName();
    }

    public String getEmail() {
        return this.userDetails.getEmail();
    }

    public String getPassword() {
        return this.userDetails.getPassword();
    }

    public String getUsername() {
        return this.userDetails.getUsername();
    }

    public LocalDate getDateOfBirth() {
        return this.userDetails.getDateOfBirth();
    }

    public String getProfilePicURL() {
        return this.userDetails.getProfilePicURL();
    }

    public String getGender() {
        return this.userDetails.getGender();
    }

    public void setFirstName(String firstName) {
        this.userDetails.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.userDetails.setLastName(lastName);
    }

    public void setEmail(String email) {
        this.userDetails.setEmail(email);
    }

    public void setPassword(String password) {
        this.userDetails.setPassword(password);
    }

    public void setUsername(String username) {
        this.userDetails.setUsername(username);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.userDetails.setDateOfBirth(dateOfBirth);
    }

    public void setProfilePicURL(String profilePicURL) {
        this.userDetails.setProfilePicURL(profilePicURL);
    }

    public void setGender(String gender) {
        this.userDetails.setGender(gender);
    }
}


