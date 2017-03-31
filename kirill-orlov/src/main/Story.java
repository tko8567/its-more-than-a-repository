package main;

/*
Козлик тоже вначале исправно дежурил в коридоре у двери, но, видя, что покупатели не являются,
переселился в контору, и они с Незнайкой по целым дням играли в "плюсики-нолики", сидя на мягком
диване, и вели разные разговоры. От нечего делать Незнайка часто смотрел на висевшую на стене
картину с непонятными кривульками и загогулинками и все силился понять, что на ней нарисовано.
 */


import code.*;

public class Story {

    static Location corridor = new Location("Corridor", Location.SPACE);
    static Entity goaty = new Entity("Goaty");
    final static int A_LITTLE = 5000;

    static {
        goaty.go(corridor);
        goaty.setOnGuestEnteredListener(entity ->
                System.out.println(goaty.getName() + " found that " + entity.getName() + " has come to " + goaty.getLocation().getName())
        );
    }

    public static void main(String[] args){

        System.out.println("History starts");
        new Entity("SOMEBODY").go(corridor);


        watcherCycle:
        do {
            try {
                Thread.sleep(A_LITTLE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (goaty.wasGuestFound());


        System.out.println("History ends");

    }

}
