package calcScore.model;

import java.util.Date;
import java.util.Random;

public interface IDomainModel {
    default String generateId(String suffix) {
            return new Date().getTime() + new Random().nextInt(1000) + suffix;
    };
}
