public class SchoolSystem {
    private List<SchoolMember> members = new ArrayList<>();
    
    public void addMember(SchoolMember member) {
        members.add(member);
    }
    
    public void printAllRoles() throws InvalidRoleException {
        for (SchoolMember member : members) {
            String role = member.getRole();
            boolean validRole = false;
            
            for (String validRoleName : Person.VALID_ROLES) {
                if (validRoleName.equals(role)) {
                    validRole = true;
                    break;
                }
            }
            
            if (!validRole) {
                throw new InvalidRoleException("Invalid role detected: " + role);
            }
            
            System.out.println(member.getDetails());
            System.out.println("Responsibilities:");
            for (String responsibility : member.getResponsibilities()) {
                System.out.println("- " + responsibility);
            }
            System.out.println();
        }
    }
    
    public List<Student> getStudentsInGrade(int grade) {
        List<Student> result = new ArrayList<>();
        for (SchoolMember member : members) {
            if (member instanceof Student) {
                Student student = (Student) member;
                if (student.getGrade() == grade) {
                    result.add(student);
                }
            }
        }
        return result;
    }
    
    public List<Teacher> getTeachersBySubject(String subject) {
        List<Teacher> result = new ArrayList<>();
        for (SchoolMember member : members) {
            if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getSubjectTaught().equals(subject)) {
                    result.add(teacher);
                }
            }
        }
        return result;
    }
}

public class InvalidRoleException extends Exception {
    public InvalidRoleException(String message) {
        super(message);
    }
}