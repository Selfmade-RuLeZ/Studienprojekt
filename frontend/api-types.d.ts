interface Car {
    id: number,
    model: string,
    vin: string,
    modelSeries: string,
    motorization: string,
    mileage: number,
    manufacturer: Manufacturer,
    repairs: Repair,
}

interface Manufacturer {
    id: number,
    name: string,
    origin: string,
}

interface RepairShop {
    id: number,
    name: string,
    postalCode: number,
    city: string,
    houseNumber: number,
    street: string,
}

interface Repair {
    id: number,
    description: string,
    cost: number,
    car: Car,
    repairShop: RepairShop,
}