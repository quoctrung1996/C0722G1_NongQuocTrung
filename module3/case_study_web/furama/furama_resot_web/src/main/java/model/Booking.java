package model;

public class Booking {
    private String codeBooking;
    private int startDay;
    private int endDay;
    private int id;
    private String serviceCode;
    private String typeService;

    public Booking() {
    }

    public Booking(String codeBooking, int startDay, int endDay, int id, String nameService, String typeService) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.id = id;
        this.serviceCode = nameService;
        this.typeService = typeService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", codeCustomer='" + id + '\'' +
                ", nameService='" + serviceCode + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
