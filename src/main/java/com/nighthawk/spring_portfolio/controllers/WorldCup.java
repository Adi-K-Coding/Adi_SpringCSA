package com.nighthawk.spring_portfolio.controllers;
public class WorldCup {
    private char group;

    public WorldCup(char group) {
        this.group = group;
    }

    public char getGroup() {
        return group;
    }

    public class Brazil extends WorldCup {
        private String name;
        private String continent;
        private String jerseyColor;

        public Brazil(char group, String name, String continent, String jerseyColor) {
            super(group);
            this.name = name;
            this.continent = continent;
            this.jerseyColor = jerseyColor;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ": {" + "group: " + group + " continent: " + continent + ", jersey color: " + jerseyColor
                    + "}";
        }

    }

    public class Argentina extends WorldCup {
        private String name;
        private String continent;
        private String jerseyColor;

        public Argentina(char group, String name, String continent, String jerseyColor) {
            super(group);
            this.name = name;
            this.continent = continent;
            this.jerseyColor = jerseyColor;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ": {" + "group: " + group + " continent: " + continent + ", jersey color: " + jerseyColor
                    + "}";
        }

    }

    public class Croatia extends WorldCup {
        private String name;
        private String continent;
        private String jerseyColor;

        public Croatia(char group, String name, String continent, String jerseyColor) {
            super(group);
            this.name = name;
            this.continent = continent;
            this.jerseyColor = jerseyColor;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ": {" + "group: " + group + " continent: " + continent + ", jersey color: " + jerseyColor
                    + "}";
        }

    }

    public class Morocco extends WorldCup {
        private String name;
        private String continent;
        private String jerseyColor;

        public Morocco(char group, String name, String continent, String jerseyColor) {
            super(group);
            this.name = name;
            this.continent = continent;
            this.jerseyColor = jerseyColor;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ": {" + "group: " + group + " continent: " + continent + ", jersey color: " + jerseyColor
                    + "}";
        }

    }

    public class France extends WorldCup {
        private String name;
        private String continent;
        private String jerseyColor;

        public France(char group, String name, String continent, String jerseyColor) {
            super(group);
            this.name = name;
            this.continent = continent;
            this.jerseyColor = jerseyColor;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ": {" + "group: " + group + " continent: " + continent + ", jersey color: " + jerseyColor
                    + "}";
        }

    }

    public static void main(String[] args) {
        WorldCup Qatar = new WorldCup('A');
        Brazil brazilTeam = Qatar.new Brazil('F', "Brazil", "South America", "Yellow");
        Argentina argentinaTeam = Qatar.new Argentina('C', "Argentina", "South America", "Blue");
        Croatia croatiaTeam = Qatar.new Croatia('F', "Croatia", "Europe", "White");
        Morocco moroccoTeam = Qatar.new Morocco('F', "Morocco", "Africa", "Red");
        France franceTeam = Qatar.new France('D', "France", "Europe", "Blue");
        System.out.println(brazilTeam);
        System.out.println(argentinaTeam);
        System.out.println(croatiaTeam);
        System.out.println(moroccoTeam);
        System.out.println(franceTeam);

    }

}