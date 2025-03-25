public interface Person {
    String[] VALID_ROLES = {"Student", "Teacher", "Administrator"};
    
    String getDetails();
    String getRole();
}