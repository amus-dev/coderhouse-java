package ventas.cheffify.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTHORS")
public class Author {

    public Author() {
        super();
    }



    public Author(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
