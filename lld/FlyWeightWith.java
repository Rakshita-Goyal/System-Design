//Flyweight pattern reduces memory usage by sharing common (intrinsic) objects instead of creating many duplicate objects.

package lld;
import java.util.*;

class AsteroidType {
    private String color;     // intrinsic
    private String texture;   // intrinsic

    public AsteroidType(String color, String texture) {
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) { // extrinsic
        System.out.println("Asteroid " + color + " " + texture +
                " at (" + x + "," + y + ")");
    }
}
class AsteroidFactory {
    private static Map<String, AsteroidType> cache = new HashMap<>();

    public static AsteroidType getAsteroidType(String color, String texture) {
        String key = color + "_" + texture;

        if (!cache.containsKey(key)) {
            cache.put(key, new AsteroidType(color, texture));
        }
        return cache.get(key);
    }
}
class Asteroid {
    private int x, y;                 // extrinsic
    private AsteroidType type;        // intrinsic (shared)

    public Asteroid(int x, int y, AsteroidType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

public class FlyWeightWith{
    public static void main(String args[]){
 List<Asteroid> asteroids = new ArrayList<>();

        String[] colors = {"Red", "Gray", "Blue"};
        String[] textures = {"Rocky", "Icy"};

        for (int i = 0; i < 10; i++) {
            AsteroidType type = AsteroidFactory.getAsteroidType(
                    colors[i % 3],
                    textures[i % 2]
            );

            asteroids.add(new Asteroid(i * 10, i * 20, type));
        }

        for (Asteroid a : asteroids) {
            a.draw();
        }
    }
}