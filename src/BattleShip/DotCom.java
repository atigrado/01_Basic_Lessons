package BattleShip;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells; //ArrayList с ячейками, опмсывающими местоположение
    private String name; //имя "сайта"

    public void setLocationCells(ArrayList<String> loc) { //Сеттер, который обновляет местоположение "сайта" (случайный адрес, предоставляемый методом placeDotCom() из класса GameHelper
        locationCells = loc;
    }

    public void setName(String n) { //Простой сеттер
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput); //Если ход совпал с одним из элементов ArrayList, то метод вернет его местоположение. Если нет - вернет -1
        if (index >= 0) {
            locationCells.remove(index); //Применяем метод remove() для удаления элемента

            if (locationCells.isEmpty()) { //Используем метод, чтобы проверить, все ли адреса были разгаданы
                result = "Потопил";
                System.out.println("Ой, вы потопили " + name + " :("); //Сообщаем пользователю о потоплении "сайта"
            } else {
                result = "Попал";
            }
        }
        return result;  //Возвращаем "Мимо", "Попал" или "Потопил"
    }
}
