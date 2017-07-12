package BattleShip;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Artem Konyukhov on 04.07.2016.
 */
public class DotComBust {
    //Объявляем и инициализируем переменные, которые нам понадобятся
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        //Создадим несколько "сайтов" и присвоим им адреса
        //Создаем три объекта DotCom, даем им имена и помещаем в ArrayList
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        //Выводим краткие инструкции для пользователя
        System.out.println("Ваша цель = потопить три сайта.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов.");

        //Повторяем с каждым объектом DotCom в списке
        for (DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3); //Запрашиваем у вспомогательного объекта адрес "сайта"
            dotComToSet.setLocationCells(newLocation); //Вызываем сеттер из объекта DotCom, чтобы передать ему местоположение,
                                                       // которое только что получили от вспомогательного объекта
        }
    }

    private void startPlaying() {
        while (!dotComList.isEmpty()) { //До тех пор, пока список объектов DotCom не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход"); //Получаем пользовательский ввод
            checkUserGuess(userGuess); //Вызываем метод checkUserGuess
        }
        finishGame(); //Вызываем метод finishGame
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; //Инкрементируем количество попыток, которые сделал пользователь
        String result = "Мимо"; //Подразумеваем промах, пока не выявили обратного
        for (DotCom dotComToTest : dotComList) { //Повторяем это для всех объектов DotCom в списке
            result = dotComToTest.checkYourself(userGuess); //Просим DotCom проверить ход пользователя, ищем попадание (или потопление)
            if (result.equals("Попал")) {
                break; //Выбираемся из цикла раньше времени, нет смысла проверять другие "сайты"
            }
            if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest); //Ему пришел конец, так что удаляем его из списка "сайтов" и выходим из цикла
                break;
            }
        } //конец for
        System.out.println(result); //Выводим для пользователя результат
    }

    private void finishGame() { //Выводим сообщение о том, как пользователь прошел игру
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        }
        else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main (String[] args) {
        DotComBust game = new DotComBust(); //СОздаем игровой объект
        game.setUpGame(); //Говорим игровому объекту подготовить игру
        game.startPlaying(); //Говорим игровому объекту начать главный игровой цикл (продолжаем запрашивать пользовательский ввод и проверять полученные данные
    }
}

