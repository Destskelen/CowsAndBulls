import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
// Класс для работы с данными игрока
public class HerdHuman {

    public ArrayList<Integer> input() {
        // Объекты для получения данных с клавиатуры
        Scanner scanner = new Scanner(System.in);
        String inputString;
        ArrayList<Integer> resultHerd = new ArrayList<>();

        while (true) {
            System.out.print("Ваша попытка (введите число из " +
                    SizeHerd.SIZEHERD +
                    " цифр или exit для завершения игры):");
            // Получаем строку с клавиатуры
            inputString = scanner.nextLine();
            if (inputString.equals("exit")) System.exit(0);
    /*        if (inputString.equals("help")) {
                System.out.println("Правила игры:");
                continue; // Продолжить с ввода данных
            } */
            // Паттерн для регулярного выражения "цифры от 0 до 9"
            String str = "\\b[0-9]{" + SizeHerd.SIZEHERD + "}\\b";
            Pattern pattern = Pattern.compile(str);
            //Pattern pattern = Pattern.compile("\\b[0-9]{4}\\b");
            if (!pattern.matcher(inputString).find()) {
                System.out.println("Ошибка ввода. Попробуйте ещё раз.");
                // Если паттерн сработал выходим из цикла ввода
            } else break;
        }
        // Разбиваем строку на цифры и заносим их в список-результат
        for (int i = 0; i < SizeHerd.SIZEHERD; i++) {
            resultHerd.add(Integer.parseInt((Character.toString(inputString.charAt(i)))));
        }
        return resultHerd;
    }
}
