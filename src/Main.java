import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            // Флаг режима бота
            boolean botMode = false;
            // Обработчик параметров командной строки
            int index;
            // Отгадывает человек
            if (!botMode) {
                // Создаём задуманное стадо
                HerdPC herdPC = new HerdPC();
                herdPC.init();
                // Создаём стадо для игрока
                HerdHuman herdHuman = new HerdHuman();
                System.out.print("Привет! Я задумал " + SizeHerd.SIZEHERD +
                        "-значное число из неповторяющихся цифр, " +
                        "попробуй отгадать его!\n");

                boolean gameOn = true;
                while (gameOn) {
                    // Получаем ответ от игрока
                    ArrayList<Integer> herdIn = herdHuman.input();
                    // Определяем число быков
                    int bulls = herdPC.howBulls(herdIn);
                    // Определяем число коров
                    int cows = herdPC.howCows(herdIn);
                    // Опредяем статус игры
                    if (bulls == SizeHerd.SIZEHERD) {
                        System.out.println("Вы победили!");
                        System.out.println("Game over!");
                        gameOn = false;
                    } else System.out.println("\tБыков: " + bulls +
                            " Коров: " + (cows - bulls) + " Вы угадали " +
                            bulls + " из " + SizeHerd.SIZEHERD +
                            ". Играйте дальше.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



