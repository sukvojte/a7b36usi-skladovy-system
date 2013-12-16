package cz.a7b36usi.sklad.DTO;

import java.util.List;

/**
 *
 * @author Lukas L.
 */
public class ProductDTO extends AbstractDTO {

    private String name;
    private String code;
    private Integer quantity;
    private Long category;

    public ProductDTO(Long id,String name, String code, Integer quantity, Long category) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.category = category;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }


}
