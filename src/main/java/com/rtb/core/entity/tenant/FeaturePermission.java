package com.rtb.core.entity.tenant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rtb.core.entity.user.Permission;
import com.rtb.core.utils.FeaturePermissionId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "feature_permission")
public class FeaturePermission implements Serializable {

    @EmbeddedId
    private FeaturePermissionId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("featureId")
    @JoinColumn(name = "feature_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Feature feature;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Permission permission;

    public FeaturePermission() {}

    public FeaturePermission(Feature feature, Permission permission) {
        this.feature = feature;
        this.permission = permission;
        this.id = new FeaturePermissionId(feature.getId(), permission.getId());
    }

    public FeaturePermissionId getId() {
        return id;
    }

    public void setId(FeaturePermissionId id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FeaturePermission that = (FeaturePermission) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
