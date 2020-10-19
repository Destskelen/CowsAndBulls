import java.util.ArrayList;

import static java.lang.Math.random;

// Класс-расширение стандартного класса ArrayList<Integer>
// для работы с задуманным стадом
public class HerdPC extends ArrayList<Integer> {
    // В конструкторе создаём задуманное стадо из SIZEHERD цифр
    HerdPC() {
    }

    public void init() {
        for (int i = 0; i < SizeHerd.SIZEHERD; i++) {
            int x;
            do {
                // Генерируем случайное число от 0 до 9
                x = (int) (random() * 9);
            } while (this.contains(x));
            // Если цифры в списке нет, то добавляем её
            this.add(x);
            //123 System.out.printf("%d ", x); // Для контроля
        }
    }

    // Определяем число быков
    public int howBulls(ArrayList<Integer> herd) {
        int bulls = 0;
        for (int i = 0; i < this.size(); i++) {
            // Если цифры в позиции i совпадают, увеличиваем число быков
            if (this.get(i).equals(herd.get(i))) bulls++;
        }
        return bulls;
    }

    // Определяем число коров
    public int howCows(ArrayList<Integer> herd) {
        int cows = 0;
        for (int i = 0; i < this.size(); i++) {
            // Если цифра в списке есть, увеличиваем число коров
            if (this.contains(herd.get(i))) cows++;
        }
        return cows;
    }
}
