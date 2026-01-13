void main() {
    Scanner scanner = new Scanner(System.in);
    IO.println("Введите выражение (например, 2 + 3):");
    if (scanner.hasNextLine()) {
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            IO.println(result);
        } catch (Exception e) {
            System.err.println("throws Exception // " + e.getMessage());
            System.exit(1);
        }
    }
}

public static String calc(String input) {
    String[] tokens = input.trim().split("\\s+");

    if (tokens.length != 3) {
        throw new RuntimeException("Некорректный формат ввода. Пример: 2 + 3");
    }

    int a = parseNumber(tokens[0]);
    int b = parseNumber(tokens[2]);
    String op = tokens[1];

    int res = switch (op) {
        case "+" -> a + b;
        case "-" -> a - b;
        case "*" -> a * b;
        case "/" -> a / b;
        default -> throw new RuntimeException("Операция '" + op + "' не поддерживается");
    };

    return String.valueOf(res);
}

private static int parseNumber(String str) {
    try {
        int val = Integer.parseInt(str);
        if (val < 1 || val > 10) {
            throw new RuntimeException("Число " + val + " вне диапазона [1..10]");
        }
        return val;
    } catch (NumberFormatException e) {
        throw new RuntimeException("'" + str + "' не является целым числом");
    }
}