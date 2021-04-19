public class Marathon

{

    public static void main(String[] args) {
        String tempWinEvent = " удалось";
        String tempLossEvent = " не удалось";
        String eventName;
        String eventResult;

        Pferd pferd = new Pferd("Лошадь", 3, 1500, 100);
        Katze katze = new Katze("Кот", 2, 200, 0);
        Vogel vogel = new Vogel("Птица", 0.2f, 5, 0);
        Hund hund = new Hund("Пёс", 0.4f, 500, 10);




        Tier[] arr = { pferd, katze, vogel, hund };
        float jumpLength = 10;
        float runLength = 20;
        float swimLength = 110;

        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";

            eventName = "бежать " + arr[i].getMaxRun() + " метров. Хочет пробежать на ";
            eventResult = arr[i].run(runLength) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);

            eventName = "прыгать " + arr[i].getMaxJump() + " метров. Хочет прыгнуть на ";
            eventResult = (arr[i].jump(jumpLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, jumpLength, eventResult);

            int swimResult = arr[i].swim(swimLength);
            eventName = "плыть " + arr[i].getMaxSwim() + " метров. Хочет проплыть на ";
            eventResult = (swimResult == Tier.SWIM_OK) ? tempWinEvent : tempLossEvent;
            if (swimResult == Tier.SWIM_NONE)
                eventResult = " не удалось - не умеет плавать";
            result(nameString, eventName, swimLength, eventResult);
        }
    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + " метров - " + resultEvent);
    }
}
