package backend.project.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @ManyToMany
    @JoinTable(
            name = "products_storages",
            joinColumns = {
                    @JoinColumn (
                            name = "product_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn (
                            name = "storage_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            }
    )
    private List<Storage> storages;


}
