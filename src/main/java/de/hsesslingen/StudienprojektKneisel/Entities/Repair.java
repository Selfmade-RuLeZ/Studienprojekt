package de.hsesslingen.StudienprojektKneisel.Entities;

import javax.persistence.*;

@Entity
@Table(name = "repair")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "description", length = 2040, nullable = false)
    private String description;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @ManyToOne(optional = false)
    @JoinColumn(name = "repair_shop_id", nullable = false)
    private RepairShop repairShop;

    public RepairShop getRepairShop() {
        return repairShop;
    }

    public void setRepairShop(RepairShop repairShop) {
        this.repairShop = repairShop;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}