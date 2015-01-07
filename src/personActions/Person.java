package personActions;

public class Person {
    private final String name;
    private final String secondName;
    private final int age;

    private Person(Builder builder) {
        this.name = builder.name;
        this.secondName = builder.secondName;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return !(name != null ? !name.equals(person.name) : person.name != null) && !(secondName != null ? !secondName.equals(person.secondName) : person.secondName != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private String name;
        private String secondName;
        private int age;

        public Builder() {

        }

        public Builder(Person original) {
            this.name = original.name;
            this.secondName = original.secondName;
            this.age = original.age;
        }

        public Builder name(String name) {
            this.name = name;
            return this;

        }

        public Builder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
