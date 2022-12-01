import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double sum, double rate, int period) {
        double finalSum = sum * Math.pow((1 + rate / 12), 12 * period);
        return roundValue(finalSum, 2);
    }

    double calculateSimplePercent(double sum, double rate, int period) {
        return roundValue(sum + sum * rate * period, 2);
    }

    double roundValue(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void countFinalDepositSum() {
        int depositPeriod;
        int depositType;
        double finalDepositSum = 0;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositSum = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = userInput.nextInt();

        if (depositType == 1) {
            finalDepositSum = calculateSimplePercent(depositSum, 0.06, depositPeriod);
        } else if (depositType == 2) {
            finalDepositSum = calculateComplexPercent(depositSum, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositSum + " за " + depositPeriod + " лет превратятся в " + finalDepositSum);
    }

    public static void main(String[] args) {
        new DepositCalculator().countFinalDepositSum();
    }


}
