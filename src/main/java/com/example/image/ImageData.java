package com.example.image;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ImageData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true, nullable = false, precision = 10)
    @SequenceGenerator(name = "image_data_id_seq", sequenceName = "image_data_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_data_id_seq")
    private Long id;

    @Column(name = "name")
    @Length(max = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
