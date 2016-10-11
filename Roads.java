public class Roads {
    private String sName;
    private String startLoc;
    private String endLoc;

    public Roads(String streetName, String start, String end) {
        this.sName = streetName;
        this.startLoc = start;
        this.endLoc = end;
    }

    public String getStartLocation() {
        return startLoc;
    }

    public String getEndLocation() {
        return endLoc;
    }

    public String getStreet() {
        return sName;
    }
}