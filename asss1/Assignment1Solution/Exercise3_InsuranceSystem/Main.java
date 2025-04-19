package Assignment1Solution.Exercise3_InsuranceSystem;

import java.util.*;
import java.time.LocalDate;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<InsurancePolicy> policies = new ArrayList<>();
    private static final List<Person> people = new ArrayList<>();
    private static final List<Vehicle> vehicles = new ArrayList<>();
    private static final List<Claim> claims = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("--- Advanced Motor Vehicle Insurance System ---");
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:\n1. Add Person\n2. Add Vehicle\n3. Create Policy\n4. Process Claim\n5. Generate Report\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addPerson(); break;
                case 2: addVehicle(); break;
                case 3: createPolicy(); break;
                case 4: processClaim(); break;
                case 5: generateReport(); break;
                case 6: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }
        System.out.println("Exiting...");
    }

    private static void addPerson() {
        System.out.print("Person ID: "); String id = scanner.nextLine();
        System.out.print("Full Name: "); String name = scanner.nextLine();
        System.out.print("Date of Birth (yyyy-mm-dd): "); LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        Person p = new Person(id, name, dob, email, phone);
        if (p.validatePerson()) {
            people.add(p);
            System.out.println("Person added.");
        }
    }

    private static void addVehicle() {
        System.out.print("Vehicle ID: "); String id = scanner.nextLine();
        System.out.print("Make: "); String make = scanner.nextLine();
        System.out.print("Model: "); String model = scanner.nextLine();
        System.out.print("Year: "); int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type: "); String type = scanner.nextLine();
        Vehicle v = new Vehicle(id, make, model, year, type);
        if (v.validateVehicle()) {
            vehicles.add(v);
            System.out.println("Vehicle added.");
        }
    }

    private static void createPolicy() {
        System.out.println("Policy Types: 1. Comprehensive 2. Third Party 3. Collision 4. Liability 5. Roadside Assistance");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Policy ID: "); String pid = scanner.nextLine();
        System.out.print("Vehicle ID: "); String vid = scanner.nextLine();
        Vehicle v = vehicles.stream().filter(x -> x.getVehicleId().equals(vid)).findFirst().orElse(null);
        if (v == null) { System.out.println("Vehicle not found."); return; }
        System.out.print("Person ID: "); String perid = scanner.nextLine();
        Person p = people.stream().filter(x -> x.getPersonId().equals(perid)).findFirst().orElse(null);
        if (p == null) { System.out.println("Person not found."); return; }
        System.out.print("Coverage Amount: "); double coverage = scanner.nextDouble();
        System.out.print("Premium Amount: "); double premium = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Policy Start Date (yyyy-mm-dd): "); LocalDate start = LocalDate.parse(scanner.nextLine());
        System.out.print("Policy End Date (yyyy-mm-dd): "); LocalDate end = LocalDate.parse(scanner.nextLine());
        InsurancePolicy policy = null;
        switch (type) {
            case 1:
                policy = new ComprehensivePolicy(pid, v, p, coverage, premium, start, end);
                break;
            case 2:
                System.out.print("Engine Capacity: "); double ec = scanner.nextDouble();
                System.out.print("Extra Coverage (true/false): "); boolean extra = scanner.nextBoolean();
                scanner.nextLine();
                policy = new ThirdPartyPolicy(pid, v, p, coverage, premium, start, end, ec, extra);
                break;
            case 3:
                System.out.print("Safe Driver (true/false): "); boolean safe = scanner.nextBoolean();
                System.out.print("Safety Checked (true/false): "); boolean checked = scanner.nextBoolean();
                scanner.nextLine();
                policy = new CollisionPolicy(pid, v, p, coverage, premium, start, end, safe, checked);
                break;
            case 4:
                System.out.print("Medical Checked (true/false): "); boolean med = scanner.nextBoolean();
                System.out.print("Extended Disability Coverage (true/false): "); boolean ext = scanner.nextBoolean();
                scanner.nextLine();
                policy = new LiabilityPolicy(pid, v, p, coverage, premium, start, end, med, ext);
                break;
            case 5:
                System.out.print("Commercial (true/false): "); boolean comm = scanner.nextBoolean();
                System.out.print("Registration Verified (true/false): "); boolean reg = scanner.nextBoolean();
                System.out.print("Inspection Verified (true/false): "); boolean insp = scanner.nextBoolean();
                scanner.nextLine();
                policy = new RoadsideAssistancePolicy(pid, v, p, coverage, premium, start, end, comm, reg, insp);
                break;
            default:
                System.out.println("Invalid policy type.");
        }
        if (policy != null && policy.validatePolicy()) {
            policies.add(policy);
            System.out.println("Policy created.");
        }
    }

    private static void processClaim() {
        System.out.print("Policy ID: "); String pid = scanner.nextLine();
        InsurancePolicy policy = policies.stream().filter(x -> x.policyId.equals(pid)).findFirst().orElse(null);
        if (policy == null) { System.out.println("Policy not found."); return; }
        System.out.print("Claim ID: "); String cid = scanner.nextLine();
        System.out.print("Claim Amount: "); double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Claim Date (yyyy-mm-dd): "); LocalDate date = LocalDate.parse(scanner.nextLine());
        Claim claim = new Claim(cid, amount, date, "Pending");
        if (policy.processClaim(claim)) {
            claims.add(claim);
            System.out.println("Claim processed and added.");
        }
    }

    private static void generateReport() {
        System.out.println("\n--- Insurance Report ---");
        System.out.println("Total Policies: " + policies.size());
        System.out.println("Total Claims: " + claims.size());
        double totalPremiums = policies.stream().mapToDouble(x -> x.premiumAmount).sum();
        System.out.println("Total Premiums Collected: " + totalPremiums);
        Map<String, Long> claimStatusCounts = new HashMap<>();
        for (Claim c : claims) {
            claimStatusCounts.put(c.getClaimStatus(), claimStatusCounts.getOrDefault(c.getClaimStatus(), 0L) + 1);
        }
        System.out.println("Claims Status Breakdown: " + claimStatusCounts);
        Map<String, Long> policyTypeCounts = new HashMap<>();
        for (InsurancePolicy p : policies) {
            String type = p.getClass().getSimpleName();
            policyTypeCounts.put(type, policyTypeCounts.getOrDefault(type, 0L) + 1);
        }
        System.out.println("Policy Type Breakdown: " + policyTypeCounts);
    }
}
