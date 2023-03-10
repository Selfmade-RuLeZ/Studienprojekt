package de.hsesslingen.StudienprojektKneisel.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.hsesslingen.StudienprojektKneisel.Serializers.ManufacturerSetSerializer;
import de.hsesslingen.StudienprojektKneisel.Serializers.RepairSetSerializer;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "repair_shop")
public class RepairShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;

    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;

    @Column(name = "city", nullable = false)
    private String city;

    @ManyToMany(mappedBy = "repairShops")
    private Set<Manufacturer> manufacturers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "repairShop", orphanRemoval = true)
    private Set<Repair> repairs = new LinkedHashSet<>();

    @JsonSerialize(using = RepairSetSerializer.class)
    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @JsonSerialize(using = ManufacturerSetSerializer.class)
    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}