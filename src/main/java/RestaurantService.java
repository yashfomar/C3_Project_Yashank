import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName){
        public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
            for(Restaurant restaurant: restaurants) {
                if(restaurant.getName().equals(restaurantName))
                    return restaurant;
            }
            throw new restaurantNotFoundException(restaurantName);
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Double getOrderValue(String restaurantName,List<String> items) throws restaurantNotFoundException {
        Restaurant restaurant = findRestaurantByName(restaurantName);
        return restaurant.findOrderValue(items);
    }
}
