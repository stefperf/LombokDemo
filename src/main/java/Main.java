import lombok.*;
import lombok.Builder.Default;

// Demonstrating Lombok's main annotations.
// Note that @Getter / @Setter could be used also more granularly on single member fields that need them.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
class Person {
    private String firstName;
    private String lastName;
    @Default private int age = 30;

    // Custom method
    public String getFullName() {
        return firstName + " " + lastName;
    }
}

// doing the same with fewer annotations, thanks to @Data which encompasses several others
@Data
@Builder
class Individual {
    private String firstName;
    private String lastName;
    private int age;

    // Custom method
    public String getFullName() {
        return firstName + " " + lastName;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a Person object using Lombok's @AllArgsConstructor
        Person person0 = new Person("Taylor", "Smith", 28);

        // Create a Person object using Lombok's @NoArgsConstructor
        // then set all properties using setters created by Lombok's @Data
        Person person1 = new Person();
        person1.setFirstName("Jane");
        person1.setLastName("Doe");
        person1.setAge(29);

        // Create a Person object using Lombok's @Builder and @Default  for the age
        Person person2 = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        // Print the Person object; uses @ToString for the object
        System.out.printf("Person0 %s has a very generic and gender-neutral name.%n", person0);

        // Use Lombok's @Getter and @ToString for a field
        System.out.printf("Person1 has the generic female name %s and is aged %d.%n",
                person1.getFullName(), person1.getAge());
        System.out.printf("Person2 has the generic male name %s and is aged %d.%n",
                                person2.getFullName(), person2.getAge());

        // Use Lombok's @EqualsAndHashCode
        System.out.printf("Content equality test: person1.equals(person2)) = %b.%n", person1.equals(person2));
        System.out.printf("Indeed, Person1 and Person2 have different hashes: %s and %s.%n",
                person1.hashCode(), person2.hashCode());

        // Now doing everything with fewer annotations by using Lombok's @Data
        Individual individual0 = new Individual("Taylor", "Smith", 28);

        Individual individual1 = new Individual("Jane", "Doe", 29);

        Individual individual2 = Individual.builder()
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .build();

        System.out.printf("Individual0 %s has a very generic and unisex name.%n", individual0);

        System.out.printf("Individual1 has the generic female name %s and is aged %d.%n",
                individual1.getFullName(), individual1.getAge());
        System.out.printf("Individual2 has the generic male name %s and is aged %d.%n",
                                individual2.getFullName(), individual2.getAge());

        System.out.printf("Content equality test: individual1.equals(individual2)) = %b.%n",
                individual1.equals(individual2));
        System.out.printf("Indeed, Individual1 and Individual2 have different hashes: %s and %s.%n",
                individual1.hashCode(), individual2.hashCode());
    }
}
