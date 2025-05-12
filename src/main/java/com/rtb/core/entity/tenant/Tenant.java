package com.rtb.core.entity.tenant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rtb.core.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tenant")
public class Tenant extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "long_name", nullable = false)
  private String longName;

  @Column(nullable = false)
  private String description;

  @Column (nullable = false, unique = true)
  private String email;

  @Column(name = "is_enabled", nullable = false)
  private boolean isEnabled = false;

  @Column(name = "logo")
  private String logo;

  @Column(name = "short_name", nullable = false)
  private String shortName;

  @Column(name = "address")
  private String address;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "primary_color")
  private String primaryColor;

  @Column(name = "secondary_color")
  private String secondaryColor;

  @Column(name = "privacy_policy_link")
  private String privacyPolicyLink;

  @Column(name = "terms_conditions_link")
  private String termsConditionsLink;

  @Column(name = "about_us_link")
  private String aboutUsLink;

  @Column(name = "upload_csv_faq")
  private String uploadCsvFaq;

  @Column(name = "youtube_handle")
  private String youtubeHandle;

  @Column(name = "twitter_handle")
  private String twitterHandle;

  @Column(name = "api_key")
  private String apiKey;

  @OneToMany(mappedBy = "tenant")
  @JsonManagedReference
  private Set<TenantCommunication> communications;

  @OneToMany(mappedBy = "tenant")
  private Set<TenantCommunicationChannels> channels;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "tenant_features",
    joinColumns = @JoinColumn(name = "tenant_id"),
    inverseJoinColumns = @JoinColumn(name = "feature_id")
  )
  @JsonBackReference // Avoid looping when serializing `Tenant`
  private Set<Feature> features;

}
