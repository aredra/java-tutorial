package lambda;

// Lambda식을 위한 Interface
// Method 2개 이상 구현 불가
@FunctionalInterface
public interface MyMaxNumber {
    int getMaxNumber(int x, int y);
}
