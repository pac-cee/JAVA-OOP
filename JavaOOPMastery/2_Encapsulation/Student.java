    public void study() {
        System.out.println(name + " is studying.");
    }
    public static void main(String[] args) {
        Student alice = new Student();
        alice.setName("Alice");
        alice.setAge(20);
        alice.study(); // Output: Alice is studying.
        alice.setAge(-5); // Output: Age cannot be negative!
    }

