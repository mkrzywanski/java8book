package chapter2;

public class Task9 {
    public static void main(String[] args) throws NotEnoughGasolineException {
        Car car = new Car(10);
        car.pourGasoline(20);
        car.drive(190);
        System.out.println("Gasoline combustion l/km = " + car.gasolineCombustion);
        System.out.println("Current gasoline amount = " + car.currentGasolineAmount + "l");
        System.out.println("Current distance travelled = " + car.totalDistanceTravelled + "km");
    }

    private static class Car {

        private double gasolineCombustion;
        private double currentGasolineAmount;
        private double totalDistanceTravelled;

        public Car(double gasolineCombustion) {
            this.gasolineCombustion = gasolineCombustion;
            this.currentGasolineAmount = 0;
            this.totalDistanceTravelled = 0;
        }

        private void drive(double distance) throws NotEnoughGasolineException {
            double gasolineForDistance = distance * gasolineCombustion / 100;
            if(gasolineForDistance < currentGasolineAmount) {
                totalDistanceTravelled += distance;
                currentGasolineAmount -= gasolineForDistance;
            } else {
                throw new NotEnoughGasolineException("msg");
            }
        }

        private void pourGasoline(double gasolineAmount) {
            this.currentGasolineAmount += gasolineAmount;
        }

        public double getCurrentGasolineAmount() {
            return currentGasolineAmount;
        }

        public double getTotalDistanceTravelled() {
            return totalDistanceTravelled;
        }
    }

    private static class NotEnoughGasolineException extends Exception {
        public NotEnoughGasolineException(String message) {
            super(message);
        }
    }
}
