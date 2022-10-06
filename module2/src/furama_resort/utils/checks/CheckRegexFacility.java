package furama_resort.utils.checks;

public class CheckRegexFacility {

    public boolean checkServiceCodeVilla(String serviceCode ) {
        String regex = "^SVVL-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceCodeHouse (String serviceCode ) {
        String regex = "^SVHO-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceCodeRoom  (String serviceCode ) {
        String regex = "^SVRO-\\d{4}$";
        return serviceCode.matches(regex);
    }
    public boolean checkServiceName(String serviceName){
        String regex="^([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        return serviceName.matches(regex);
    }
    public boolean checkIdentityCard(String identityCard){
        String regex="^([0-9]{9})|([0-9]{12})$";
        return identityCard.matches(regex);
    }
    public boolean checkPhoneNumber(String phoneNumber){
        String regex="^\\+84[0-9]{9}$";
        return phoneNumber.matches(regex);
    }
    public boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        return email.matches(regex);
    }
    public boolean checkName(String name) {
        String regex = "^([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        return name.matches(regex);
    }
    public boolean checkAddress(String address) {
        String regex = "^([\\w/]+[ ]?)*([A-Z][a-z]+\\s)+([A-z][a-z]+)$";
        return address.matches(regex);
    }
}