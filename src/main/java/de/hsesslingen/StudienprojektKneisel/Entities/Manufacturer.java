package de.hsesslingen.StudienprojektKneisel.Entities;

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

    @OneToMany(mappedBy = "manufacturer", orphanRemoval = true)
    private Set<RepairContract> repairContracts = new LinkedHashSet<>();

    public Set<RepairContract> getRepairContracts() {
        return repairContracts;
    }

    public void setRepairContracts(Set<RepairContract> repairContracts) {
        this.repairContracts = repairContracts;
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