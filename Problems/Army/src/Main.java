class Army {

    public static void createArmy() {
        // Implement this method
        //creating the units:
        Unit[] units = new Unit[5];
        for (int i = 0; i < 5; i++) {
            int num = i + 1;
            String name = "Unit" + num;
            units[i] = new Unit(name);
        }
        //creating the knights:
        Knight[] knights = new Knight[3];
        for (int i = 0; i < 3; i++) {
            int num = i + 1;
            String name = "Knight" + num;
            knights[i] = new Knight(name);
        }
        //creating the general:
        General general = new General("Dwight");
        //creating the doctor:
        Doctor doctor = new Doctor("Michael");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}