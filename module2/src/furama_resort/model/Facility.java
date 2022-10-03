package furama_resort.model;

public abstract class Facility {
    private String serviceName;
    private double areaUse;
    private double rentaClosts;
    private int people;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, double areaUse, double rentaClosts, int people, String rentalType) {
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.rentaClosts = rentaClosts;
        this.people = people;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentaClosts() {
        return rentaClosts;
    }

    public void setRentaClosts(double rentaClosts) {
        this.rentaClosts = rentaClosts;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", areaUse=" + areaUse +
                ", rentaClosts=" + rentaClosts +
                ", people=" + people +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
