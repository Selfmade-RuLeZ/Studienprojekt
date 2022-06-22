package de.hsesslingen.StudienprojektKneisel.Entities;

import javax.persistence.*;

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