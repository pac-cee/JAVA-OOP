public class ClassExercises {
    public class Person {
        private final String name;
        private final int age;
        
        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }
        
        public String getName(){ return name; }
        public int getAge(){ return age; }
    }


    public class Dog {
        private String name;
        private String breed;
        
        public Dog(String name, String breed){
            this.name = name;
            this.breed = breed;
        }
        
        public String getName(){ return name; }
        public String getBreed(){ return breed; }
        
        public void setName(String name){ this.name = name; }
        public void setBreed(String breed){ this.breed = breed; }
}
}
