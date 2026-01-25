package tomato.factories;
import java.time.LocalTime;
import java.util.List;
import tomato.models.*;
import tomato.strategies.*;
import tomato.Main;
import tomato.TomatoApp;

public class NowOrderFactory implements OrderFactory {
 @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                             PaymentStrategy paymentStrategy, double totalCost, String orderType) {


        Order order = null;

if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }
    order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(LocalTime.now().toString());
        order.setTotal(totalCost);
        return order;
                             }

}