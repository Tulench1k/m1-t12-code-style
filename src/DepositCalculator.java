import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return roundNumber(pay, 2);
    }

    double calculateSimplePercent(double amount,
                                  double yearRate,
                                  int depositPeriod) {
        return roundNumber(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundNumber(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        Scanner readLine = new Scanner(System.in);
        int amount;
        int period;
        double out = 0;

        amount = readLine.nextInt();
        period = readLine.nextInt();

        System.out.println("Введите сумму вклада в рублях:");
        System.out.println("Введите срок вклада в годах:");
        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        int action = readLine.nextInt();
        if (action == 1) out = calculateSimplePercent(
                amount,
                0.06,
                period);
        else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount +
                " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }


}
