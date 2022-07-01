package de.hsesslingen.StudienprojektKneisel.Entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.hsesslingen.StudienprojektKneisel.Serializers.ManufactureSerializer;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "vin", nullable = false, unique = true)
    private String vin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Column(name = "model_series", nullable = false)
    private String modelSeries;

    @Column(name = "motorization", nullable = false)
    private String motorization;

    @OneToMany(mappedBy = "car", orphanRemoval = true)
    private Set<Repair> repairs = new LinkedHashSet<>();

    @Column(name = "mileage")
    private Long mileage;

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Set<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    public String getMotorization() {
        return motorization;
    }

    public void setMotorization(String motorization) {
        this.motorization = motorization;
    }

    public String getModelSeries() {
        return modelSeries;
    }

    public void setModelSeries(String modelSeries) {
        this.modelSeries = modelSeries;
    }

    @JsonSerialize(using = ManufactureSerializer.class)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}