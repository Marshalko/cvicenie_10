package sk.stuba.fei.oop.cvicenie;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;



}
