public class Link {
    private Link next;
    private EmployeeRecord record;

    public Link(EmployeeRecord record) {
        this.record = record;
    }

    public Link add(EmployeeRecord record) {
        if(next == null) {
            next = new Link(record);
        } else {
            next.add(record);
        }

        return this;
    }

    public EmployeeRecord get(int index) {
        if(index <= 0) {
            return record;
        } else {
            if(next == null) {
                System.out.print("Out of Bounds");
                return record;
            } else {
                return next.get(index - 1);
            }
        }
    }
}

class EmployeeRecord {
    private String name;
    private String ssn;
    private int salery;

    public EmployeeRecord(String name, String ssn, int salery) {
        this.name = name;
        this.salery = salery;
        this.snn = ssn;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getSSN() {
        return ssn;
    }

    public int getSalery() {
        return salery;
    }
}