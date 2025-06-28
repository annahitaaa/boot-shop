package com.annahita.bootshop.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;


import java.io.Serializable;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Audit implements Serializable {
    private static final long serialVersionUID = 109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productBrand;

    @NotEmpty
    private String productModel;

    @NotEmpty
    private String productDescription;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @NotNull
    @Range(min = 0)
    private Double discount;

    @NotEmpty
    private String productStatus;

    @NotEmpty
    private String productCategory;

    /*@Lob
    private byte[] img;*/

   /* @Transient
    private MultipartFile productImage;*/

    /*@OneToMany(mappedBy = "product")
    private List<CartItem> cartItem;*/

   /* @Transient
    private Map<String,String> categoryList;

    public Product(){
        categoryList= new HashMap<>();
        categoryList.put("laptop", "laptop");
        categoryList.put("TV", "TV");
        categoryList.put("Mobile", "Mobile");
    }*/

}
