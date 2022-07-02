package de.hsesslingen.StudienprojektKneisel.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.hsesslingen.StudienprojektKneisel.Serializers.RepairShopSetSerializer;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "origin", nullable = false)
    private String origin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "repair_authorization",
            joinColumns = @JoinColumn(name = "manufacturer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "repair_shop_id", referencedColumnName = "id"))
    private Set<RepairShop> repairShops = new LinkedHashSet<>();

    @JsonSerialize(using = RepairShopSetSerializer.class)
    public Set<RepairShop> getRepairShops() {
        return repairShops;
    }

    public void setRepairShops(Set<RepairShop> repairShops) {
        this.repairShops = repairShops;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}