package com.example.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);

		ProductService service = context.getBean(ProductService.class);

        // create image data
		ImageData imageData = new ImageData();
		imageData.setName("one");

		//create image and associate it with image
		Image image = new Image();
		image.setDefaultImageData(imageData);
		imageData.setImage(image);

		//create product and associate it with image
		Product product =  new Product();
		product.setImage(image);

		//store the product
		Product saved = service.save(product);

		Product retrieved = service.retrieveTheProduct(saved.getId());
		System.out.println("Product Id :" + retrieved.getId());
		System.out.println("Image Id :" + retrieved.getImage().getId());
		System.out.println("ImageData Id :" + retrieved.getImage().getDefaultImageData().getId());
		System.out.println("ImageData Name :" + retrieved.getImage().getDefaultImageData().getName());

	}
}


