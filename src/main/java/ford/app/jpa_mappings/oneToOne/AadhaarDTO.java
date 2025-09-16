package ford.app.jpa_mappings.oneToOne;

public class AadhaarDTO {
    private String aadhaarNumber;

    public AadhaarDTO() {
    }

    public AadhaarDTO(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }


    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

}
