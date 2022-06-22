package de.hsesslingen.StudienprojektKneisel.Entities;

import javax.persistence.*;

@Entity
@Table(name = "repair_contract")
public class RepairContract {
    @ManyToOne(optional = false)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "repair_shop_id", nullable = false)
    private RepairShop repairShop;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RepairShop getRepairShop() {
        return repairShop;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}