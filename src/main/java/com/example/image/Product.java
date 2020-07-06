package com.example.image;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true, nullable = false, precision = 10)
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY, optional=false, cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name="image_screenshot_id",nullable=false)
    private Image image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

