public class Report {
    String content;
    Report(String content) { this.content = content; }
}

public class ReportPrinter {
    void print(Report report) {
        System.out.println("Printing report: " + report.content);
    }
    public static void main(String[] args) {
        Report r = new Report("OOP Principles");
        ReportPrinter printer = new ReportPrinter();
        printer.print(r); // Output: Printing report: OOP Principles
    }
}
