import java.util.Objects;

public class Person {
    public final Profession profession;
    private final User user;
    private final Integer age;
    private final Sex sex;

    public Person(
            Profession profession,
            User user,
            Integer age,
            Sex sex
    ) {
        this.profession = profession;
        this.user = user;
        this.age = age;
        this.sex = sex;

    }


    public User getUser() {
        return user;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Profession getProfession() {
        return profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return profession == person.profession &&
                Objects.equals(user, person.user) &&
                Objects.equals(age, person.age) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profession, user, age, sex);
    }

    @Override
    public String toString() {
        return " ваша учётная запись =>" +
                " профессия: " + profession +
                ", имя и фамилия: " + user +
                ", возраст, лет: " + age +
                ", пол: " + sex;
    }

}
