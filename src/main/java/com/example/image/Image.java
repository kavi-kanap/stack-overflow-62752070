package com.example.image;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Image implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true, nullable = false, precision = 10)
    @SequenceGenerator(name = "image_id_seq", sequenceName = "image_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_seq")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = javax.persistence.CascadeType.ALL ,mappedBy = "image")
    @JoinColumn(name = "default_image_data_id", nullable = false)
    @NotNull
    private ImageData defaultImageData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImageData getDefaultImageData() {
        return defaultImageData;
    }

    public void setDefaultImageData(ImageData defaultImageData) {
        this.defaultImageData = defaultImageData;
    }
}
