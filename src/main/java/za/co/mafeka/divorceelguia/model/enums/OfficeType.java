package za.co.mafeka.divorceelguia.model.enums;

public enum OfficeType {
    LEGAL_AID("Legal Aid"),
    LAW_CLINIC("Law Clinic"),
    FAMILY_ADVOCATE("Family Advocate"),
    MAINTENANCE_COURT("Maintenance Court"),
    CCMA("CCMA"),
    ADVICE_OFFICE("Advice Office"),
    PRO_BONO("Pro Bono"),
    PRIVATE_ATTORNEY("Private Attorney");

    private final String officeType;

    OfficeType(String officeType) {
        this.officeType = officeType;
    }

    public String getStatus() {
        return officeType;
    }

    public static OfficeType getByType(String type) {
        if(type == null) {
            return null;
        }
        for (OfficeType officeType: values()) {
            if(officeType.getStatus().equalsIgnoreCase(type)) {
                return officeType;
            }
        }
        throw new IllegalArgumentException("Unknown OfficeType: " + type);
    }
}
