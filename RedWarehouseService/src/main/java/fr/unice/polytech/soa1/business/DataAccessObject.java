package fr.unice.polytech.soa1.business;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by user on 02/10/14.
 */
@Singleton(name = "redWarehouseMockDB")
public class DataAccessObject {
    private List<Item> content;
    private List<Employee> employees;
    private List<WareHouse> wareHouses;
    private List<DayLog> dayLogs;
    private List<Task> taskAssigned;


    public DataAccessObject() { init(); }



    public Optional<Item> findItemByReference(String reference) {
        return getContent().stream().filter(r -> r.getReference().equals(reference)).findFirst();
    }

    public Optional<Item> findLocationOfProduct(String reference) {
        return null;
    }

    public Optional<Employee> findEmployeeById(String id){
        return getEmployees().stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public Optional<Task> getEmployeeTask(String id){
        ArrayList<Task> mockTasks = new ArrayList<>();

        for(Task t : getTaskAssigned()){
            for(String s : t.getEmployeesAssignedId()){
                if(s.equals(id)) mockTasks.add(t);
            }
        }
        return mockTasks.stream().findFirst();
    }

    public Optional<DayLog> findDayLogById(String id){
        return getDayLogs().stream().filter(r -> r.getEventId().equals(id)).findFirst();
    }

    public Optional<Task> findTaskById(String id){
        return getTaskAssigned().stream().filter(r -> r.getTaskId().equals(id)).findFirst();
    }

    public Optional<DayLog> dayLogs(){
        return null;
    }



    //getter and setter
    public List<Item> getContent() {
        return content;
    }
    public void setContents(List<Item> content) {
        this.content = content;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Task> getTaskAssigned() {
        return taskAssigned;
    }

    public void setTaskAssigned(List<Task> taskAssigned) {
        this.taskAssigned = taskAssigned;
    }

    public List<DayLog> getDayLogs() {
        return dayLogs;
    }

    public void setDayLogs(List<DayLog> dayLogs) {
        this.dayLogs = dayLogs;
    }

    public List<WareHouse> getWareHouses() {
        return wareHouses;
    }

    public void setWareHouses(List<WareHouse> wareHouses) {
        this.wareHouses = wareHouses;
    }



    private void init() {
        //contents

        List<Item> content = new ArrayList<>(Arrays.asList(
                new Item("F9T7FN4TG33WC5F",0,5,3,74,43,22,86),
                new Item("W3P3NV5OZ24BD1K",0,2,4,61,11,92,42),
                new Item("H5J4CP8ZY18SO6R",1,5,5,2,2,73,4),
                new Item("X9M7UD2NL47SB2W",3,1,3,79,24,96,60),
                new Item("H4O1ZU7DU23ZR9V",3,10,4,79,18,5,15),
                new Item("B4Z7QN1IB81OT5J",0,7,1,83,56,88,48),
                new Item("T1M7UW4AQ18KM6V",2,9,1,91,16,2,19),
                new Item("P3L5YD5GB59LN5G",1,1,3,60,64,30,1),
                new Item("E5T2VO1WB17UG7V",2,8,4,22,48,84,8),
                new Item("L5C1TR4OO94MD2D",2,1,3,82,71,35,93),
                new Item("I8D7TY9PU73UO6G",3,3,2,11,32,47,24),
                new Item("D7I1ZY8PZ28HZ5G",3,7,4,71,18,72,70),
                new Item("E6Y2OB1DQ45VQ7E",2,8,2,5,47,85,96),
                new Item("H9X5TL5LW53HI2M",3,10,4,60,13,17,17),
                new Item("M9H5AP9UB56GZ6U",3,6,4,56,8,2,18),
                new Item("U3E9BQ8AJ88KI2Y",3,6,1,68,59,16,52),
                new Item("V8X6ID5OY52GU8A",3,5,3,62,20,46,22),
                new Item("O5T2PR6JM18QK2T",2,6,4,71,59,76,67),
                new Item("J2Q4CM4PA37CR9H",0,5,4,21,62,43,65),
                new Item("L8G4YY1BK75TU4D",1,7,1,53,84,9,92),
                new Item("G2C7RA6HE49OM3R",0,3,1,53,97,95,73),
                new Item("N5X2ZA1TS18VO6K",2,10,3,38,72,12,89),
                new Item("K5C4EB9FL61TQ6F",2,9,3,37,31,11,74),
                new Item("C1B5KG5DU77ZL1X",3,8,2,52,74,70,85),
                new Item("Z3T3RB4JK56TV1R",3,6,2,13,3,36,4),
                new Item("A5D1IU3CK74MO6P",0,8,3,6,4,28,6),
                new Item("X9A6MS3GH48JQ7K",2,5,1,11,37,37,57),
                new Item("F3J7HK8OO47RH1B",0,6,1,12,92,73,48),
                new Item("N6S2KX8CT13UJ3C",2,6,5,15,46,20,96),
                new Item("A3R2TE7IL62ZP3D",2,9,4,2,62,30,83),
                new Item("A4N5TM4IR82VN7V",0,4,4,32,59,24,85),
                new Item("O1A8PZ4RQ73GS3X",3,8,4,79,99,41,51),
                new Item("G2T7BE4YL83ID4A",3,9,5,73,20,28,11),
                new Item("M6Q9HR9ZQ92PU5H",2,4,2,43,78,84,58),
                new Item("C1Q5IS4MA96TD1Y",0,5,4,65,68,18,11),
                new Item("T4X6EQ1KH49SI3T",2,2,4,70,22,99,42),
                new Item("S9H3BG1CE46MS8Z",2,10,4,15,47,65,65),
                new Item("R4D5RV8BQ31KB6K",2,7,1,88,75,75,49),
                new Item("N6N3PJ3KF67BX9X",0,9,5,70,59,99,16),
                new Item("D1F1IF6EL47FN1B",1,5,4,40,7,80,99),
                new Item("F1F1SX8UI43CZ4L",3,10,2,48,10,17,16),
                new Item("X3R4AA5TG41DK9C",1,4,4,48,29,90,32),
                new Item("B2U2YZ4SF33HY2A",0,7,3,78,93,54,8),
                new Item("F6U6RJ1NS12GB4Z",0,10,1,23,93,89,87),
                new Item("R6A3ET8OY12ZW4H",3,4,1,75,16,26,1),
                new Item("U7R7OK2TT98KO2I",0,7,2,63,75,90,65),
                new Item("V1E8SQ1EU76LK3W",3,3,1,65,27,56,15),
                new Item("J3V9FM4CU49ME6C",1,2,5,60,87,39,66),
                new Item("N4H9WJ2JQ73DJ6M",1,9,3,38,77,18,51),
                new Item("I3A9AO2ZB61TT3P",0,2,5,59,15,49,47),
                new Item("F2B4SN4LV12ZG2A",1,5,2,50,30,52,2),
                new Item("T8C5HR4VN56EQ7K",1,5,2,67,78,39,11),
                new Item("W4T1YL5QS96LV8H",2,1,3,13,4,40,32),
                new Item("L7S4PZ1KW94CQ8W",1,9,1,57,14,60,90),
                new Item("F7N9HT8KX79KY5W",1,7,4,7,65,91,77),
                new Item("C7F8OX4QD65GI3J",3,2,5,85,99,17,76),
                new Item("P6A2XZ4XE15HQ1Y",1,5,3,17,73,42,14),
                new Item("Z2P8AV3EV72GH7W",2,2,3,64,94,2,36),
                new Item("L6E1AZ2EY66GC4Z",3,9,2,58,73,28,42),
                new Item("F4H3BF2TE61NJ1X",1,4,1,39,17,97,45),
                new Item("X7F3TM3HI32SE1T",3,10,2,56,100,70,33),
                new Item("G4S4AI2QR32WZ3H",3,1,4,97,56,56,38),
                new Item("D4X9PY9PT46YZ1I",0,4,5,52,25,11,58),
                new Item("P1O8TE1TX98MN6P",0,4,4,24,85,40,90),
                new Item("N1R5FE9TV84XP3B",1,9,5,59,92,53,69),
                new Item("G6Q8RR6XH82MU5C",1,7,4,40,28,69,62),
                new Item("D3P3ML2UH24MF7F",3,1,2,39,93,39,48),
                new Item("P5B4ZK7BU47UI2Y",1,1,3,100,68,48,18),
                new Item("F7H7OS8LN17CX2K",1,4,5,95,65,99,26),
                new Item("Q6Q5DZ3BC15CZ9O",2,4,3,92,35,7,43),
                new Item("F6N3JE8RA13UZ4W",2,1,1,84,34,49,4),
                new Item("O7P9QD8EU56UN6E",0,8,2,96,50,58,67),
                new Item("L2Q3WM1ZH24FM1M",3,5,2,84,91,66,89),
                new Item("F3T2ZS2DX89MQ9Z",0,8,2,75,18,34,87),
                new Item("D8U4TH1YH83KO7W",2,6,2,5,66,83,83),
                new Item("H7W7EB8ZI95JA7T",2,8,2,58,95,52,70),
                new Item("A7V2QG6WY98KX7N",1,4,4,14,68,96,87),
                new Item("Z6L7XQ7CR16RO5J",3,7,2,23,11,25,35),
                new Item("S4G2XK6TQ81MJ6C",2,5,1,73,79,98,35),
                new Item("A8U7BM5RA91DO3H",0,7,2,81,69,14,100),
                new Item("S1H3FJ2AZ51YI6Q",1,10,4,8,85,79,14),
                new Item("P9F7WU4LJ15QQ7N",1,9,4,32,2,75,93),
                new Item("S7Z8RH1ZK19UI1N",0,2,5,88,11,63,100),
                new Item("V3V5ME4KI19CP5Y",3,3,1,47,25,93,58),
                new Item("S7G1JG4PM15PC7W",3,6,5,98,40,54,39),
                new Item("O5X5UA5EZ13FM7M",2,10,4,23,20,43,64),
                new Item("E8F8MX6AF41UM6L",1,7,4,20,61,7,30),
                new Item("V9S2TT9OU44IP8E",3,3,2,21,96,84,7),
                new Item("O8C6QB9AY36MW5S",0,8,4,87,37,47,93),
                new Item("K1T2UO4EF88JX5L",1,1,5,10,56,4,59),
                new Item("F4N6LD7QW44ZK9E",2,6,2,59,16,11,95),
                new Item("J8T5ED1UV21CB5L",0,8,5,17,40,14,32),
                new Item("A6H3WF8IG83AO4V",0,8,4,69,85,19,96),
                new Item("X8K8RN7SC25HL3G",3,3,2,80,61,66,33),
                new Item("G8F2ZW4JN68SO6X",0,10,4,91,59,83,22),
                new Item("L6Y2TH2NG56KX2C",1,9,1,84,49,80,55),
                new Item("V1W1RY1YL53BU4N",3,1,1,61,95,23,60),
                new Item("Q7S8OA5KF81JB8E",0,9,5,22,27,35,9),
                new Item("S6X2PX2TA81DR9K",3,1,2,90,10,19,24),
                new Item("D8I3JU7PV11EQ1U",1,9,3,11,31,80,64)));

                this.content = content;

        //day_logs
        List<DayLog> dayLogs = new ArrayList<>(Arrays.asList(
                new DayLog("1316387260","delivery",15,15,"Q2P4ZW8FJ21NG1Q",22,82,47,34),
                new DayLog("4695671566","delivery",15,00,"H8C7JA1OE73NU4P",9,11,32,30),
                new DayLog("6828765938","pickup",8,30,"N4E4MT9ZV46FD3S",42,72,87,38),
                new DayLog("9736601553","pickup",11,30,"D4K4UB7FJ34DB9Z",68,21,5,48),
                new DayLog("9008727099","pickup",16,45,"J9G5FR8UC16WU2Q",13,88,90,38),
                new DayLog("6389693407","pickup",14,00,"T3O7II9UP74GT5X",69,9,98,16),
                new DayLog("8021571331","pickup",12,30,"O2U1CQ5WQ96EI4I",23,46,50,8),
                new DayLog("6424730133","delivery",14,30,"H7S2VS2VS36JW7H",83,71,91,33),
                new DayLog("4237732723","pickup",15,15,"G1N2ZL2JG82HA7U",30,8,72,19),
                new DayLog("4339427917","pickup",12,30,"K2O6UM1EV77EL8J",72,16,37,11),
                new DayLog("9744950056","pickup",15,45,"M2Y5HL7TK13XN6M",49,60,56,28),
                new DayLog("7032344449","pickup",13,15,"I6W3VZ7WD41RE8V",89,37,1,49),
                new DayLog("3154412402","pickup",14,15,"C4L8OI2NB39ZG5A",86,77,9,27),
                new DayLog("7650781211","delivery",16,30,"C5Y1ZJ1GU24QQ2O",87,76,90,27),
                new DayLog("3824419973","delivery",16,30,"P1B9EQ8GT86KP3U",41,7,59,4),
                new DayLog("8000509310","pickup",9,00,"V4O1LC9HR21ZZ3E",80,33,55,26),
                new DayLog("9551415594","delivery",8,15,"V7U3AJ5TH51RH2W",59,65,90,8),
                new DayLog("8020408651","pickup",15,15,"S5Y5LP5WZ97OP5W",46,27,57,40),
                new DayLog("2927344192","pickup",17,15,"S2J6NO9ZR53BF4M",19,60,71,42),
                new DayLog("4485033317","delivery",13,30,"X5G3VX4ZX13WR6S",17,73,90,12),
                new DayLog("1402625871","delivery",14,45,"A2A2BP7ZA13TB9F",85,71,88,24),
                new DayLog("9549445604","pickup",13,00,"N1U4RC6CX25PE9A",15,27,19,38),
                new DayLog("1291479563","pickup",17,30,"Q9G2PV1NW49MJ1J",83,28,96,6),
                new DayLog("7544906543","delivery",10,30,"F9J8BH8NH13PZ7U",40,54,45,22),
                new DayLog("3557584291","pickup",8,45,"P4V9BE9BJ36AW7T",94,29,13,28),
                new DayLog("9119272695","pickup",11,45,"U7E9AT2MW96GZ5W",29,71,65,8),
                new DayLog("8457127530","delivery",15,00,"C3Z3PF5ZF53WF6S",53,13,28,6),
                new DayLog("9802462568","pickup",16,00,"Q3D4UQ7MT66CB9G",86,31,71,22),
                new DayLog("1748542925","pickup",9,15,"G2K4ZY6KF73BF1Q",38,37,51,38),
                new DayLog("4447671702","pickup",13,15,"Z7W9NS1FI15BK4A",57,8,63,16),
                new DayLog("6509464279","delivery",13,45,"Q7Y8MJ5VB75ZZ9Q",83,81,56,17),
                new DayLog("4410183276","pickup",12,30,"S6B5LB8AY16UE3W",48,44,13,36),
                new DayLog("4146754249","delivery",13,15,"E3O2MD2LS71HN5S",8,23,92,14),
                new DayLog("3675907524","delivery",14,30,"F9Y7SV5QF38RL4J",46,70,75,49),
                new DayLog("6561110035","pickup",15,45,"A8U6LS4ZL47DC1X",34,24,41,6),
                new DayLog("7603139035","pickup",10,30,"J2C4EH2ES54SR8M",21,84,85,47),
                new DayLog("1765277701","delivery",9,15,"V7F8XN3OG88LH4T",75,28,26,8),
                new DayLog("5771996582","delivery",16,30,"N5Y7KB7VJ42WR2A",12,34,95,48),
                new DayLog("4681990243","delivery",16,30,"J2P1FP8ZQ38UT1S",41,66,5,38),
                new DayLog("3393529253","delivery",13,30,"N3Y2AH5SJ82FC3O",57,56,70,37),
                new DayLog("9197368945","delivery",9,00,"C2I4XS3LN28XI8H",64,78,20,44),
                new DayLog("4093588456","delivery",15,45,"E8J3ME9RR88QO5E",67,33,36,14),
                new DayLog("2347369151","delivery",9,15,"Q5V4NT9UG16PG6M",44,93,7,2),
                new DayLog("8521807173","delivery",11,00,"J8C5AB6HE68KK4F",17,37,67,36),
                new DayLog("9906494895","delivery",17,00,"X2B6LP6CV67LP8N",68,7,94,40),
                new DayLog("3160066278","delivery",11,15,"I2U4BG2LU47SL3G",5,35,57,4),
                new DayLog("8279141750","pickup",10,30,"A7X5MK6LR75PD5H",76,77,34,39),
                new DayLog("7839421345","pickup",16,00,"D4A9RT6PR42WI4J",87,27,19,32),
                new DayLog("2683753033","pickup",14,30,"O7F4KQ5AC88XL9T",13,25,81,36),
                new DayLog("2926044655","pickup",8,15,"F1T8FN2PP49IL9V",77,58,17,50),
                new DayLog("4265056019","delivery",14,15,"T4S1PD3NE82GT2O",2,25,97,3),
                new DayLog("3144477441","pickup",9,30,"M5P5HL3OV75KJ2T",16,28,26,25),
                new DayLog("1891026024","delivery",14,45,"O6Z5OE4OF71OF2E",1,29,4,40),
                new DayLog("7470373042","pickup",10,45,"Q9R1CF9JX45GP7M",15,47,76,22),
                new DayLog("5521204436","delivery",11,00,"Q1Z6TA5IT57JC4E",12,23,72,12),
                new DayLog("1167190405","pickup",13,00,"G5W7JO9VY19NS7D",36,59,35,24),
                new DayLog("2385155434","pickup",10,15,"A9R1OF2YN52KB7W",29,11,95,2),
                new DayLog("4870164994","pickup",11,30,"P7U2AO8HR16NP7D",17,3,69,12),
                new DayLog("6625724062","pickup",14,00,"X9K9VT4YH18KS5K",54,34,72,18),
                new DayLog("4616764552","delivery",13,30,"H7Q3BN9UX27ZH3H",55,62,99,26),
                new DayLog("6954448054","delivery",12,00,"C8S1BR7XQ87EG5K",29,91,90,10),
                new DayLog("7425591094","delivery",8,15,"L9V9NJ2PB86PB1G",29,83,18,28),
                new DayLog("6938635529","delivery",12,15,"M5U3PE7UJ39NW2A",38,83,27,19),
                new DayLog("6467539512","delivery",15,15,"C4Z6MF7SF27NN9M",34,86,54,33),
                new DayLog("5427085971","pickup",13,30,"Z5N4WA4TW85CC9M",36,2,58,46),
                new DayLog("3602748104","pickup",10,45,"K9I3RQ6JU73NU1N",54,30,35,50),
                new DayLog("4169286767","delivery",8,00,"J9M2YU6TW83HF5G",36,99,61,41),
                new DayLog("3328876367","delivery",17,15,"O8P6ZI5LP29ID4F",29,25,26,6),
                new DayLog("8091126566","pickup",8,15,"G9Z3NO7BZ22IC9K",33,32,18,49),
                new DayLog("1903881950","pickup",12,00,"U3W4TK3EJ27XA3E",73,15,34,28),
                new DayLog("1447262433","delivery",14,00,"V8O8SW9UQ62DI9I",78,8,26,28),
                new DayLog("2642121930","pickup",10,00,"U3V1TS8BS14WT8G",35,25,10,32),
                new DayLog("9535870620","pickup",10,45,"V1Y7NU5OY45JQ5Q",58,49,2,1),
                new DayLog("7116885004","pickup",10,30,"M3W8UC9UR94GW3P",66,91,92,26),
                new DayLog("1638451841","pickup",10,30,"C5F3EE3VT56KU8B",76,49,94,31),
                new DayLog("8174247957","delivery",13,00,"T3G7ZU1SM98SB7R",44,35,87,7),
                new DayLog("9314156712","delivery",11,45,"X2Y6QE1WV11LW8J",48,44,42,19),
                new DayLog("5346984038","delivery",12,15,"U8E1RT3PK71AF2H",94,98,76,2),
                new DayLog("7051916876","pickup",16,45,"L5T2OH4OJ17JY9S",51,53,98,36),
                new DayLog("3612479327","pickup",10,45,"R3C4XC7VN65EQ6V",53,15,29,34),
                new DayLog("4455328214","delivery",8,15,"M7I2GU2VY28EP9X",19,3,75,23),
                new DayLog("7205460269","delivery",9,15,"T4D7SZ8SN74PJ4D",79,96,57,28),
                new DayLog("8592792449","pickup",15,30,"N9R2KX5AN65LT3W",9,82,33,6),
                new DayLog("4200060683","pickup",15,00,"A9Y6IA9IP63JO7A",58,11,63,10),
                new DayLog("5282337945","delivery",11,00,"S7F1VR3KV23AJ7L",80,95,44,24),
                new DayLog("2783116531","delivery",17,15,"K9H9GR6TR22WB8U",28,71,80,1),
                new DayLog("1782525612","pickup",17,00,"E2Q6OY5GR48BY8D",78,72,21,29),
                new DayLog("2925032978","delivery",17,30,"A1W7OR1UX29HF6V",60,26,66,18),
                new DayLog("4997043003","pickup",14,15,"E5Q5ZH5HJ52WA9L",56,62,31,4),
                new DayLog("3815756276","pickup",10,15,"M2U7TY1BN33IN3Z",82,28,96,30),
                new DayLog("4161801186","delivery",16,45,"L7J6WB6SY37YN7T",41,73,29,35),
                new DayLog("8133899569","pickup",9,15,"E2Q7CL4IP78EH6P",36,20,13,49),
                new DayLog("4858564792","pickup",12,45,"H8O4EE6VW41RI9K",15,95,85,1),
                new DayLog("3980529344","delivery",9,00,"K9Z5BX7AP27FJ2P",15,49,30,11),
                new DayLog("2188091297","delivery",9,30,"I4P1IZ1FJ99HY4N",70,82,91,44),
                new DayLog("2938292000","delivery",11,15,"H9Y2NH1HB79LJ5O",89,78,40,16),
                new DayLog("4162829502","pickup",13,30,"Y3E6FH9BJ27AU7P",87,2,49,12),
                new DayLog("4098875580","pickup",10,45,"Z2Q7HN2XQ39LC1R",58,7,69,27),
                new DayLog("2825740066","delivery",11,30,"J6A2MV2LN25TZ4U",89,28,12,29),
                new DayLog("9535291466","pickup",13,30,"M3V1NS5ZL31MH5U",68,41,35,20)));

                this.dayLogs = dayLogs;

        //employee
        List<Employee> employees = new ArrayList<>(Arrays.<Employee>asList(
                new Employee("Lesley","Bond","EP1"),
                new Employee("Cameron","Abbott","EP2"),
                new Employee("Daquan","Mcintosh","EP3"),
                new Employee("Barclay","Castillo","EP4"),
                new Employee("Sopoline","Compton","EP5"),
                new Employee("Lacy","Gardner","EP6"),
                new Employee("Bree","Colon","EP7"),
                new Employee("Belle","Wells","EP8"),
                new Employee("Cullen","Cruz","EP9"),
                new Employee("Len","Neal","EP10"),
                new Employee("Patricia","Craft","EP11"),
                new Employee("Susan","Crawford","EP12"),
                new Employee("Igor","Douglas","EP13"),
                new Employee("Carter","Jones","EP14"),
                new Employee("Patience","Wolfe","EP15"),
                new Employee("Hilda","Richards","EP16"),
                new Employee("Danielle","Holden","EP17"),
                new Employee("Kaye","Saunders","EP18"),
                new Employee("Tasha","Joyce","EP19"),
                new Employee("Kibo","Sosa","EP20"),
                new Employee("Urielle","Howard","EP21"),
                new Employee("Doris","Gallagher","EP22"),
                new Employee("Samantha","Brooks","EP23"),
                new Employee("Guinevere","Hurley","EP24"),
                new Employee("Karyn","Moore","EP25"),
                new Employee("Justin","Aguilar","EP26"),
                new Employee("Zelda","Dennis","EP27"),
                new Employee("Veda","Jimenez","EP28"),
                new Employee("Fletcher","Duke","EP29"),
                new Employee("Lawrence","Walker","EP30"),
                new Employee("Jared","Mullins","EP31"),
                new Employee("Callie","Tillman","EP32"),
                new Employee("Lacota","Guzman","EP33"),
                new Employee("Neville","Miranda","EP34"),
                new Employee("Fletcher","Marshall","EP35"),
                new Employee("Lois","Fleming","EP36"),
                new Employee("Vaughan","Greer","EP37"),
                new Employee("August","Beasley","EP38"),
                new Employee("Cally","Pittman","EP39"),
                new Employee("Jarrod","Tyler","EP40"),
                new Employee("Leslie","Holder","EP41"),
                new Employee("Laura","Andrews","EP42"),
                new Employee("Tobias","Conley","EP43"),
                new Employee("Benedict","Luna","EP44"),
                new Employee("Buckminster","Fitzpatrick","EP45"),
                new Employee("Ivy","Nichols","EP46"),
                new Employee("Victoria","Duke","EP47"),
                new Employee("Sonia","Osborn","EP48"),
                new Employee("Lacy","Stanley","EP49"),
                new Employee("Oliver","Hebert","EP50"),
                new Employee("Daniel","Jefferson","EP51"),
                new Employee("Holly","Wall","EP52"),
                new Employee("Joshua","Hanson","EP53"),
                new Employee("Chadwick","Pope","EP54"),
                new Employee("Winter","Gaines","EP55"),
                new Employee("Michelle","Bernard","EP56"),
                new Employee("Kristen","Cleveland","EP57"),
                new Employee("Alexis","Schultz","EP58"),
                new Employee("Charlotte","Wooten","EP59"),
                new Employee("Zahir","Graham","EP60"),
                new Employee("Hayes","Blackburn","EP61"),
                new Employee("Quon","Macdonald","EP62"),
                new Employee("Gretchen","Sandoval","EP63"),
                new Employee("Erin","May","EP64"),
                new Employee("Blossom","Riggs","EP65"),
                new Employee("Basil","Pitts","EP66"),
                new Employee("Jamal","Lee","EP67"),
                new Employee("Serina","Bentley","EP68"),
                new Employee("Luke","Lane","EP69"),
                new Employee("Nasim","Terry","EP70"),
                new Employee("Gemma","Mcpherson","EP71"),
                new Employee("Vance","Chandler","EP72"),
                new Employee("Cameran","Carey","EP73"),
                new Employee("Forrest","Greene","EP74"),
                new Employee("Cailin","Alford","EP75"),
                new Employee("Quentin","Manning","EP76"),
                new Employee("Tara","Wright","EP77"),
                new Employee("Laura","Guerrero","EP78"),
                new Employee("Jael","Burgess","EP79"),
                new Employee("Stacy","Davenport","EP80"),
                new Employee("Dustin","Hunt","EP81"),
                new Employee("Ishmael","Cox","EP82"),
                new Employee("Galena","Mccarty","EP83"),
                new Employee("Keiko","Watts","EP84"),
                new Employee("Wesley","Mendez","EP85"),
                new Employee("Marcia","Hartman","EP86"),
                new Employee("Orli","Snider","EP87"),
                new Employee("Barbara","Chase","EP88"),
                new Employee("David","Fitzgerald","EP89"),
                new Employee("Chandler","Barrera","EP90"),
                new Employee("Keith","Bauer","EP91"),
                new Employee("Darius","Hines","EP92"),
                new Employee("Demetrius","Sloan","EP93"),
                new Employee("Amena","Hawkins","EP94"),
                new Employee("Xenos","Nielsen","EP95"),
                new Employee("Liberty","Hyde","EP96"),
                new Employee("Carl","Burns","EP97"),
                new Employee("Ella","Clayton","EP98"),
                new Employee("Irma","Casey","EP99"),
                new Employee("Ina","Harrington","EP100")));

                this.employees = employees;

        //wareHouses
        List<WareHouse> wareHouses = new ArrayList<WareHouse>(Arrays.asList(
                new WareHouse("P.O. Box 216, 6557 Integer St.","0576JW","Vaux-sur-Sure","WH1","-21.06609, -163.63436"),
                new WareHouse("P.O. Box 430, 7013 Commodo St.","9239","Norderstedt","WH2","54.12438, 140.11072"),
                new WareHouse("8184 Erat Ave","1624","Sellano","WH3","66.5834, 93.90718"),
                new WareHouse("Ap #545-5349 Aliquet Road","98758","Sargodha","WH4","-53.58605, -112.00623"),
                new WareHouse("352-4460 Nunc St.","22714","Valda","WH5","-36.45038, 99.57527"),
                new WareHouse("356-3090 Sociis St.","47617","Feldkirchen in KÃ¤rnten","WH6","14.54857, 99.33126"),
                new WareHouse("Ap #569-158 Neque Rd.","1089","Henderson","WH7","-33.6888, -8.06549"),
                new WareHouse("Ap #188-948 Donec St.","7442","Bosa","WH8","15.17362, -111.80038"),
                new WareHouse("719-9027 Dui Avenue","843798","Lossiemouth","WH9","39.3695, -102.66681"),
                new WareHouse("4613 Ligula Rd.","141693","Armstrong","WH10","-17.00142, 129.28241"),
                new WareHouse("598-2533 Lorem Road","652548","Bayreuth","WH11","54.97228, -165.16272"),
                new WareHouse("6752 Interdum. Rd.","A1V 5V4","Zelem","WH12","-24.69047, 4.95682"),
                new WareHouse("P.O. Box 606, 394 Sapien. St.","48842","GambolÃ²","WH13","-89.29621, -126.7805"),
                new WareHouse("P.O. Box 664, 8927 Ornare St.","75336-112","Courbevoie","WH14","18.65788, -85.53116"),
                new WareHouse("670-9456 Duis St.","6687","Bhiwandi","WH15","-11.06918, 171.79833"),
                new WareHouse("735-158 Nec, Rd.","5809","Goes","WH16","-17.76726, -133.59838"),
                new WareHouse("584 Morbi Rd.","49226","Vergemoli","WH17","54.77107, 111.7533"),
                new WareHouse("1978 Turpis. St.","65650","Erode","WH18","-37.45044, 80.79906"),
                new WareHouse("787-4846 Tellus. Street","10802","Waalwijk","WH19","79.57346, 45.07077"),
                new WareHouse("P.O. Box 124, 1719 Nisl. St.","62100","Sassocorvaro","WH20","-21.50081, 166.97041"),
                new WareHouse("Ap #282-3041 Nunc Avenue","HZ3O 3WF","Lissewege","WH21","46.69854, 147.37981"),
                new WareHouse("P.O. Box 346, 5202 Imperdiet Rd.","4836WK","Sousa","WH22","76.21202, -75.26807"),
                new WareHouse("243-5372 Suspendisse St.","125911","Albury","WH23","12.89789, 104.5016"),
                new WareHouse("P.O. Box 552, 4997 Est St.","63475-577","Neufeld an der Leitha","WH24","51.13979, 24.2514"),
                new WareHouse("6209 Proin Rd.","54250-238","Oklahoma City","WH25","36.45954, 85.82717"),
                new WareHouse("P.O. Box 805, 5245 Interdum Rd.","5606","Nothomb","WH26","6.28971, 23.61294"),
                new WareHouse("P.O. Box 722, 7713 Nullam Road","38166","Ingelheim","WH27","-82.51505, 2.61672"),
                new WareHouse("Ap #971-4596 Ante. Rd.","V9R 9E6","Perth","WH28","21.53755, -64.95307"),
                new WareHouse("Ap #356-7528 Lorem Road","3229","Cape Breton Island","WH29","52.51649, -54.59511"),
                new WareHouse("3128 Fusce Rd.","5761","Mornimont","WH30","-5.13488, 177.36513"),
                new WareHouse("P.O. Box 750, 1693 Magnis Street","Y8J 3H0","Spormaggiore","WH31","58.51663, 102.25906"),
                new WareHouse("902-8046 Mi. Rd.","6311HL","Dover","WH32","-84.16856, 135.94448"),
                new WareHouse("Ap #114-4633 Non, Rd.","88942","Westmalle","WH33","-35.87854, -101.69245"),
                new WareHouse("P.O. Box 739, 8905 Facilisis Av.","88504","Pastena","WH34","-40.42685, -31.87774"),
                new WareHouse("2083 Fringilla St.","3686","Amsterdam","WH35","-6.13456, 81.54766"),
                new WareHouse("Ap #808-8768 Adipiscing Street","L5K 5B0","Baltimore","WH36","-47.7924, 118.46859"),
                new WareHouse("Ap #973-9314 Magna. Rd.","822597","Fahler","WH37","-2.9952, 150.44921"),
                new WareHouse("733-1385 Felis Rd.","88491","Nandyal","WH38","56.11584, -74.00545"),
                new WareHouse("5995 Quisque Av.","22158","Rhemes-Saint-Georges","WH39","-74.13198, -112.44886"),
                new WareHouse("753-4219 Euismod Rd.","534499","Cerreto di Spoleto","WH40","47.32707, -7.82588"),
                new WareHouse("4260 Sed, Ave","00606-086","Frederick","WH41","61.68122, -177.24931"),
                new WareHouse("Ap #385-5762 Quis St.","11470","Messancy","WH42","-46.2821, -26.67566"),
                new WareHouse("Ap #493-4257 Massa. Ave","1340","Varanasi","WH43","-69.8003, -52.43511"),
                new WareHouse("P.O. Box 275, 1955 Facilisis, Rd.","562574","Juneau","WH44","-53.18232, -152.90708"),
                new WareHouse("Ap #129-6003 Erat Ave","25432","Dorval","WH45","-68.5393, 14.22824"),
                new WareHouse("P.O. Box 966, 7049 Tempor, Road","2598","Ottawa","WH46","-64.99619, -29.46409"),
                new WareHouse("Ap #673-3020 Velit Street","964151","Gieï¿½en","WH47","19.4678, 99.03485"),
                new WareHouse("610-1532 Nunc Avenue","01439","Beaumont","WH48","-15.35583, -9.61584"),
                new WareHouse("Ap #632-1251 Duis St.","77-671","Sainte-Marie-sur-Semois","WH49","27.16537, 175.64363"),
                new WareHouse("Ap #654-4904 Dapibus Road","6104TX","Attimis","WH50","-50.31814, 167.31237"),
                new WareHouse("4744 Duis St.","70220","Laon","WH51","-43.65035, 25.21233"),
                new WareHouse("P.O. Box 990, 8080 Euismod Street","4774","Neustrelitz","WH52","-85.67837, 92.16699"),
                new WareHouse("8729 Et Rd.","0407","Moricone","WH53","6.86012, 79.63093"),
                new WareHouse("749-6328 Lorem. Avenue","6389VY","Rockville","WH54","-1.34743, -7.27852"),
                new WareHouse("339-9170 Porttitor Ave","5752","Grand-Rosiï¿½re-Hottomont","WH55","-76.40593, -104.31996"),
                new WareHouse("1002 Nullam Rd.","758391","Sambuca Pistoiese","WH56","-66.60203, 2.70619"),
                new WareHouse("4781 Lacus. St.","56902-240","Helensburgh","WH57","-1.839, 124.66392"),
                new WareHouse("Ap #651-5717 Mauris Av.","L9 1UZ","Affligem","WH58","-80.88263, -100.31987"),
                new WareHouse("558-2400 Lobortis Avenue","374857","Grande Prairie","WH59","-51.41318, 98.7217"),
                new WareHouse("Ap #639-2435 In St.","R6R 5T7","Tewkesbury","WH60","-47.46054, 137.76877"),
                new WareHouse("777-974 A Ave","59393","San Clemente","WH61","29.58607, 30.32445"),
                new WareHouse("6627 Auctor Rd.","44-962","Neumï¿½nster","WH62","56.7329, 107.68239"),
                new WareHouse("533-4724 Rutrum Av.","765668","Glovertown","WH63","-6.25385, 148.11614"),
                new WareHouse("1034 Nec, Rd.","41113","Patan","WH64","-35.86568, -94.49095"),
                new WareHouse("7517 Blandit Rd.","P0G 8W6","Boise","WH65","-70.98893, -139.55444"),
                new WareHouse("P.O. Box 657, 8449 Sem. Road","4005","Melton Mowbray","WH66","-29.0795, 69.86226"),
                new WareHouse("Ap #155-5619 Iaculis Avenue","1504","Konin","WH67","-14.14496, 173.46876"),
                new WareHouse("2179 Congue Ave","873816","Couthuin","WH68","74.09064, -87.58295"),
                new WareHouse("P.O. Box 923, 355 Sapien. St.","N1A 0Z4","Mobile","WH69","40.09383, 142.85837"),
                new WareHouse("354-7085 Lacus. Av.","12048","Witney","WH70","-48.28014, 120.00687"),
                new WareHouse("Ap #272-5295 Ut, Ave","60326-316","Bijapur","WH71","45.73391, 110.88471"),
                new WareHouse("P.O. Box 324, 8862 Massa. St.","56028","Bastogne","WH72","11.27573, -93.37415"),
                new WareHouse("583-5846 Luctus Road","93409","Hatfield","WH73","-54.49392, 17.68013"),
                new WareHouse("P.O. Box 971, 7973 Consectetuer Avenue","1288","Burlington","WH74","-38.80882, -5.09123"),
                new WareHouse("Ap #239-1774 Sit Road","3251","Asso","WH75","84.1165, -139.88376"),
                new WareHouse("2394 Purus Rd.","25073","Waardamme","WH76","-88.26196, 28.67523"),
                new WareHouse("6406 Quis, Av.","25747","Sainte-Marie-sur-Semois","WH77","15.00898, 43.54952"),
                new WareHouse("8064 Eu Road","70111","Bayswater","WH78","76.67207, 12.38644"),
                new WareHouse("P.O. Box 861, 2141 Rutrum, Av.","5536","Ashburton","WH79","-13.12524, -121.01757"),
                new WareHouse("309-4882 Metus. Rd.","6168","Gï¿½rouville","WH80","-83.05533, -151.97325"),
                new WareHouse("799-1019 Feugiat. Rd.","39798","Gonnosfanadiga","WH81","-26.06016, 9.81375"),
                new WareHouse("P.O. Box 433, 7541 A, Street","36040","Bras","WH82","42.19744, 26.02556"),
                new WareHouse("Ap #369-6415 Tempor Rd.","R9C 6G3","Shillong","WH83","-59.6315, 59.03349"),
                new WareHouse("6715 Molestie Rd.","401909","Rochester","WH84","-69.05627, -83.07202"),
                new WareHouse("Ap #471-6634 Turpis Ave","9803","Portici","WH85","-47.72852, -75.00493"),
                new WareHouse("1681 Lorem, Street","B2T 8EX","Minervino di Lecce","WH86","-75.57947, -150.26634"),
                new WareHouse("Ap #202-414 Magnis Ave","570578","Kansas City","WH87","-18.7761, -56.61797"),
                new WareHouse("318-1771 Sagittis. St.","2911","San Rafael Abajo","WH88","53.52336, 61.21775"),
                new WareHouse("6360 Et Ave","X5P 4E7","Buzenol","WH89","-36.58173, -87.86505"),
                new WareHouse("8570 Ullamcorper, Avenue","11213","Frankston","WH90","23.2458, -118.02645"),
                new WareHouse("Ap #267-5278 Nulla. St.","20189","Wernigerode","WH91","-45.65177, 145.23555"),
                new WareHouse("Ap #458-4170 Montes, Street","87030","Zwevegem","WH92","-68.88522, -2.21711"),
                new WareHouse("Ap #733-4698 Dui, Road","4386","Lafayette","WH93","28.25966, -137.30093"),
                new WareHouse("2779 Tellus Rd.","15189","Tsiigehtchic","WH94","81.22168, 47.39223"),
                new WareHouse("644-6260 Vitae, St.","9510OH","Tulita","WH95","42.06701, -163.60602"),
                new WareHouse("Ap #379-4068 Mauris Rd.","35034","Acciano","WH96","26.74649, -15.06386"),
                new WareHouse("P.O. Box 255, 9420 Sollicitudin Road","9722","Tampa","WH97","77.61178, -48.36461"),
                new WareHouse("P.O. Box 134, 7371 Magnis St.","1654","Bossuit","WH98","-16.84671, -52.30247"),
                new WareHouse("5169 Mus. Avenue","130507","Columbia","WH99","74.11813, -46.91089"),
                new WareHouse("Ap #765-7781 Lacus. Ave","11118","Kanchipuram","WH100","89.75078, -115.66372")));

                this.wareHouses = wareHouses;

                this.taskAssigned = new ArrayList<>();
              /*  ArrayList<String> employeesId = new ArrayList<>();
                employeesId.add(employees.get(1).getId());
                employeesId.add(employees.get(2).getId());*/
                Task task = new Task("1234","1316387260");
                taskAssigned.add(task);
    }


}
