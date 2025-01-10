public class CallDetails {

    private String accountNumber;
    private String aNumber;
    private String bNumber;
    private String startTime;
    private String endTime;
    private char callType;
    private int callCost;

    public CallDetails(String line) {
        this.accountNumber = line.substring(0, 10).trim();
        this.aNumber = line.substring(10, 25).trim();
        this.bNumber = line.substring(25, 40).trim();
        this.startTime = line.substring(40, 54).trim();
        this.endTime = line.substring(54, 68).trim();
        this.callType = line.charAt(68);
        this.callCost = Integer.parseInt(line.substring(69).trim());
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getaNumber() {
        return aNumber;
    }

    public void setaNumber(String aNumber) {
        this.aNumber = aNumber;
    }

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public char getCallType() {
        return callType;
    }

    public void setCallType(char callType) {
        this.callType = callType;
    }

    public int getCallCost() {
        return callCost;
    }

    public void setCallCost(int callCost) {
        this.callCost = callCost;
    }
}
