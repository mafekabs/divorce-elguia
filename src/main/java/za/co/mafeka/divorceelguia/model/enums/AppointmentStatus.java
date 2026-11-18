package za.co.mafeka.divorceelguia.model.enums;

public enum AppointmentStatus {
    REQUESTED("REQUESTED"), CONFIRMED("CONFIRMED"), COMPLETED("CONFIRMED"), MISSED("MISSED");
    private final String status;

    AppointmentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static AppointmentStatus getByName(String name) {
        if(name == null) {
            return null;
        }
        for (AppointmentStatus appStatus: values()) {
            if(appStatus.getStatus().equalsIgnoreCase(name)) {
                return appStatus;
            }
        }
        throw new IllegalArgumentException("Unknown AppointmentStatus: " + name);
    }
}