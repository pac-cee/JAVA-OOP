public class ClassExercises {
    public static  class Person {
        private final String name;
        private final int age;
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) {
        Person person = new Person("Alice", 20);
        System.out.println("Person created: " + person.name + ", Age: " + person.age);

    }
}
