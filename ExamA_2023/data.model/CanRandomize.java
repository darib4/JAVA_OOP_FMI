package data.model;
import java.util.Random;

public enum CanRandomize {
    RAND(new Random());
    public final Random GENERATOR;
    private CanRandomize(Random generator){
        GENERATOR = generator;
    }
}
