public class CallDetails {

    private String accountNumber;
    private String aNumber;
    private String bNumber;
    private String startTime;
    private String endTime;
    private char callType;
    private int callCost;

    public CallDetails(String line) {
        String[] strings = line.split(" ");

        this.accountNumber = strings[0];
        this.aNumber = strings[1];
        this.bNumber = strings[2];
        this.startTime = strings[3].substring(0, 14);
        this.endTime = strings[3].substring(15, 28);
        this.callType = strings[3].charAt(29);
        this.callCost = Integer.parseInt(strings[3].substring(30));
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
