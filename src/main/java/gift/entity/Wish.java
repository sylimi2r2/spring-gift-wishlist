package gift.entity;

public class Wish {

    private Long id;
    private final Long userId;
    private final Long productId;
    private final Long quantity;

    public Wish(Long userId, Long productId, Long quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
