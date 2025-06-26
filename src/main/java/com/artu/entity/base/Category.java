package com.artu.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "ctgr_id", nullable = false)
    private Byte ctgrId;

    @Size(max = 50)
    @NotNull
    @Column(name = "ctgr_name", nullable = false, length = 50)
    private String ctgrName;

    @NotNull
    @Column(name = "is_used_main", nullable = false)
    private Boolean isUsedMain = false;

    @NotNull
    @Column(name = "is_used_oneday", nullable = false)
    private Boolean isUsedOneday = false;

}