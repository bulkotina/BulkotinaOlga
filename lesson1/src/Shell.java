import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;
import java.lang.*;
import java.util.Scanner;

import static java.lang.String.*;
import static java.util.List.*;
import static java.util.stream.Collectors.toMap;

/*
    Реализовать программу консольной оболочки Shell
    1) Программа представляет собой набор команд. Команды вводятся с консоли: time, date, exit
    2) Каждая команда реализуется классом имплементирующем интерфейс Command
    3) Интерфейс должен описывать методы для получения имени и исполнения команды
    4) Для чтения с консоли пользуемся методом Scanner: Scanner in = new Scanner(System.in);
    5) Для работы с датой/временем пользуемся localDateTime
    6) Интерфейс Command может определять вызов двух методов: getName() и execute()
    7) На страрте проги инициализируется массив с набором команд
 */

public class Shell {
    interface Action {
        String act(String cmd);
    }
//Интерфейс Command может определять вызов двух методов: getName() и execute()
    interface Command {
        String getName();
        Action execute();
    }
//Переопределение методов - получение даты
    static class MyDate implements Command {
        @Override
        public String getName() {
            return "date";
        }
        @Override
        public Action execute() {
            return (cmd) -> LocalDate.now().toString();
        }
    }
//Переопределение методов - получение времени
    static class MyTime implements Command {
        @Override
        public String getName() {
            return "time";
        }
        @Override
        public Action execute() {
            return (cmd) -> LocalTime.now().toString();
        }
    }
//Переопределение методов - реализация выхода из программы
    static class MyExit implements Command {
        @Override
        public String getName() {
            return "exit";
        }
        @Override
        public Action execute() {
            return (cmd) -> {
                System.exit(0);
                return "";
            };
        }
    }

    Map<String, Action> commands = of(
            new MyDate(),
            new MyTime(),
            new MyExit()
    ).stream().collect(toMap(Command::getName, Command::execute));

    String eval(String name) {
        Action cmd = commands.get(name);
        if (cmd != null) return cmd.act(name);
        else return format("command not found", name);
    }
//Read/Eval/Print loop
    public void repl() {
        String[] command = new String[]{"time", "date", "exit"};
        System.out.println(Arrays.toString(command));
        Scanner in = new Scanner(System.in);
        System.out.print("Введите команду из списка: ");
        while (in.hasNextLine()) {
            System.out.println(eval(in.nextLine()));
        }
    }
}

class Lesson2 {
    public static void main(String[] args) {
        new Shell().repl();
    }
}