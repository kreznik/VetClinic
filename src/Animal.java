import java.sql.SQLOutput;

class Animal {
    private AnimalKind kind;
    private String name;
    private int age;
    private String additionalInfo;

    private Animal(AnimalBuilder builder) {
        this.kind = builder.kind;
        this.name = builder.name;
        this.age = builder.age;
        this.additionalInfo = builder.additionalInfo;

    }

    static class AnimalBuilder {
        private AnimalKind kind;
        private String name;
        private int age;
        private String additionalInfo;

        public AnimalBuilder(AnimalKind kind) {
            this.kind = kind;
        }

        public AnimalBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public AnimalBuilder setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    public String toString(AnimalKind kind, Animal animal){
        StringBuilder sb = new StringBuilder();
        if(animal.name == null && animal.age == 0){
            sb.append("Animal kind is: ").append(animal.kind);
            return  sb.toString();
        }
        if(animal.name == null){
            sb.append("Animal kind is: ").append(animal.kind).append(", name is unknown ").append(", age is: ").append(animal.age);
            return  sb.toString();
        }
        if(animal.age == 0){
            sb.append("Animal kind is: ").append(animal.kind).append(", name is: ").append(animal.name);
            return  sb.toString();
        }
        sb.append("Animal kind is: ").append(animal.kind).append(", name is: ").append(animal.name).append(", age is: ").append(animal.age);
        return sb.toString();
    }
}