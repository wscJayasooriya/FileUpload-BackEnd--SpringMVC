package sandun.file.upload.dto;

public class ProductDTO {

    private String name;
    private String description;
    private Double price;
    private String imgURL;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, Double price, String imgURL) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setImgURL(imgURL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
