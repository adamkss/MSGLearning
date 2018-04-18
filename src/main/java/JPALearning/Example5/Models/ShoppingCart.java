package JPALearning.Example5.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public int getId() {
        return id;
    }

    @OneToMany(mappedBy = "shoppingCart")
    private Set<ShoppingCartItem> cartItems;

    public Set<ShoppingCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<ShoppingCartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
