// Example for Single Responsibility Principle
class Report {
    public String getReportData() {
        return "Report Data";
    }
}

class ReportPrinter {
    public void printReport(String data) {
        System.out.println(data);
    }
}

public class SingleResponsibilityDemo {
    public static void main(String[] args) {
        Report report = new Report();
        ReportPrinter printer = new ReportPrinter();
        printer.printReport(report.getReportData());
    }
}
