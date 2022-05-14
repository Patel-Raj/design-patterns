package lld.crickinfo;

import decorator.Tea;

import java.util.Date;
import java.util.List;

public class CrickInfo {
    public static void main(String[] args) {
        String str = "aab";
        System.out.println(str.substring(1,1));
        System.out.println(str.substring(0,0).length());
        System.out.println(str.charAt(0) + str.substring(1,1) + str.charAt(1));
        char ch = '0';
        
    }
}

/*
1. To show ongoing series. and maintain them
2. Maintain matches, match status
3. Maintain schedules
4. Teams (squad as well as playing 11) => Players
5. supports api to query different stat (man of the match, highest wickets in a tournament, most run scored etc).
*/

// persons => player, umpire, commentator, Leg umpire, third umpire, ball boy

enum PayerType {
    BLOWER, BATSMAN, ALL_ROUNDER;
}

enum EmpireType {
    MAIN_UMPIRE, LEG_UMPIRE, THIRD_UMPIRE;
}

enum MatchType {
    ODI, T20, TEST;
}

enum MatchStatus {
    ONGOING, COMPLETED, CANCELLED, SCHEDULED;
}

abstract class Person {
    private String personName;
    // private Contact contact;
    // private Address address;
}

class Player extends Person {
    private Team team;
    private PayerType playerType;
}

class Umpire extends Person {
    private EmpireType empireType;
    private int experience;
    private double rating;
}

class Coach extends Person {
    private int experience;
    private double rating;
}

class Team {
    private List<Player> playerList;
    private List<Coach> coaches;
}

class Schedule {
    private Date dateScheduled;
    //private Address address;
}

class Match {
    private MatchType matchType;
    private Schedule schedule;
    private MatchStatus matchStatus;
    private Team playingTeam1;
    private Team playingTeam2;
    private Inning inning1;
    private Inning inning2;
}

enum BallType {
    RUN, WICKET, NO_BALL, WIDE;
}

class Ball {
    private int sequence;
    private BallType ballType;
    private int runs;
    private Player bolledBy;
    private Player facedBy;
    private Player catchThrowAction;
}

class Over {
    private List<Ball> balls;
    private int overNumber;
}

class Inning {
    private int inningNumber;
    private List<Over> overs;
    private Team battingTeam;
    private Team bollowingTeam;
}