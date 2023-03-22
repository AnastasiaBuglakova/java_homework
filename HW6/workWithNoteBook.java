import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class workWithNoteBook {
    public static void main(String[] args) {
        Notebook n1 = new Notebook();
        System.out.println(n1);
        Notebook n2 = new Notebook();
        n2.color = "pink";
        Notebook n3 = new Notebook();
        n3.size = 18d;
        n3.weight = 1.5;
        Notebook n4 = new Notebook("ff9876086", "gray", 333d, 550d, 
        "MacOs", 14.5,2.1, "used");
        Notebook n5 = new Notebook("ww87657800-x", "silver", 225d, 450d, 
        "WS", 16.5,2.5, "new");
        
        Set <Notebook> notes = new HashSet<>();
        notes.add(n1);
        notes.add(n2);
        notes.add(n3);
        notes.add(n4);
        notes.add(n5);
        System.out.println(notes);

        Map <String, String[]> criterias = new HashMap <>();
        
        Scanner iSc = new Scanner(System.in);
        Boolean exit = false;
        String[] msg = {"00 Введите цифру, соответствующую необходимому критерию:\n1 - Цвет, \n2 - ОЗУ, \n3 - Объём ЖД,\n4 - Операционная система,\n5 - Дигональ экрана,\n6 - Вес,\n7 - Новый/восстановленный", 
                        "01 Введите минимальное и максимальное значение для поиска через запятую \"33,99\":", "02 --",
                        "03 Введите нужный цвет через запятую (black, pink и т.п.)",
                        "04 Для очистки фильтов введите \"с\",\n для добавления параметров фильтрации введите\"с\", для выхода введите \"e\"\n", 
                        "05 Введите OS (m, w или l, для нескольких ОС через запятую:)",
                        "06 Введите \"n\" для выбора новых ноубуков и \"u\" для восстановленных",
                        };

        while (!exit){
            System.out.println(msg[0]);
            int criteria = iSc.nextInt();
            Set <Notebook> notesFiltered = new HashSet<>();
            switch (criteria) {
                case 1:
                    System.out.println(msg[3]);
                    iSc.nextLine();
                    String[] cColor = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("color", cColor);
                    System.out.println(Arrays.deepToString(cColor));
                    Set <Notebook> notesFilteredColor = new HashSet<>();
                    for (int index = 0; index < cColor.length; index++) {
                        for (Notebook n : notes) {
                            if(n.color.contains(cColor[index])) notesFilteredColor.add(n);
                        }
                    }
                    if (!notesFilteredColor.isEmpty()) notesFiltered.addAll(notesFilteredColor);
                    else notesFiltered.retainAll(notesFilteredColor);
                    break;
                case 2:
                    System.out.println(msg[1]);
                    iSc.nextLine();
                    String[] ozuGb = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("ozuGb", ozuGb);
                    System.out.println(Arrays.deepToString(ozuGb));
                    Set <Notebook> notesFilteredOzu = new HashSet<>();
                    double min = Double.parseDouble(ozuGb[0]);
                    double max = Double.parseDouble(ozuGb[1]);
                    for (Notebook n : notes) {
                        Double b = Double.valueOf(n.ozuGb);
                        if(b >= min && b <= max) notesFilteredOzu.add(n);
                    }
                    if (!notesFilteredOzu.isEmpty()) notesFiltered.addAll(notesFilteredOzu);
                    else notesFiltered.retainAll(notesFilteredOzu);
                    break;
                case 3:
                    System.out.println(msg[1]);
                    iSc.nextLine();
                    String[] pzuGb = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("pzuGb", pzuGb);
                    System.out.println(Arrays.deepToString(pzuGb));
                    Set <Notebook> notesFilteredPzu = new HashSet<>();
                    double min1 = Double.parseDouble(pzuGb[0]);
                    double max1 = Double.parseDouble(pzuGb[1]);
                    for (Notebook n : notes) {
                        Double b = Double.valueOf(n.pzuGb);
                        if(b >= min1 && b <= max1) notesFilteredPzu.add(n);
                    }
                    if (!notesFilteredPzu.isEmpty()) notesFiltered.addAll(notesFilteredPzu);
                    else notesFiltered.retainAll(notesFilteredPzu);
                    break;
                case 4:
                    System.out.println(msg[5]);
                    iSc.nextLine();
                    String[] os = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("OS", os);
                    System.out.println(Arrays.deepToString(os));
                    Set <Notebook> notesFilteredOS = new HashSet<>();
                    for (int index = 0; index < os.length; index++) {
                        for (Notebook n : notes) {
                            if(n.oS.toLowerCase().contains(os[index])) notesFilteredOS.add(n);
                        }
                    }
                    if (!notesFilteredOS.isEmpty()) notesFiltered.addAll(notesFilteredOS);
                    else notesFiltered.retainAll(notesFilteredOS);
                    break;
                case 5:
                    System.out.println(msg[1]);
                    iSc.nextLine();
                    String[] size = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("size", size);
                    System.out.println(Arrays.deepToString(size));
                    Set <Notebook> notesFilteredSize = new HashSet<>();
                    double min2 = Double.parseDouble(size[0]);
                    double max2 = Double.parseDouble(size[1]);
                    for (Notebook n : notes) {
                        Double b = Double.valueOf(n.size);
                        if(b >= min2 && b <= max2) notesFilteredSize.add(n);
                    }
                    if (!notesFilteredSize.isEmpty()) notesFiltered.addAll(notesFilteredSize);
                    else notesFiltered.retainAll(notesFilteredSize);
                    break;
                case 6:
                    System.out.println(msg[1]);
                    iSc.nextLine();
                    String[] weight = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("weight", weight);
                    System.out.println(Arrays.deepToString(weight));

                    Set <Notebook> notesFilteredWeight = new HashSet<>();
                    double min3 = Double.parseDouble(weight[0]);
                    double max3 = Double.parseDouble(weight[1]);
                    for (Notebook n : notes) {
                        Double b = Double.valueOf(n.weight);
                        if(b >= min3 && b <= max3) notesFilteredWeight.add(n);
                    }
                    if (!notesFilteredWeight.isEmpty()) notesFiltered.addAll(notesFilteredWeight);
                    else notesFiltered.retainAll(notesFilteredWeight);

                    break;
                case 7:
                    System.out.println(msg[6]);
                    iSc.nextLine();
                    String[] used = iSc.nextLine().replace(" ","").trim().toLowerCase().split(",");
                    criterias.put("used", used);
                    System.out.println(Arrays.deepToString(used));
                    Set <Notebook> notesFilteredUsed = new HashSet<>();
                    for (int index = 0; index < used.length; index++) {
                        for (Notebook n : notes) {
                            if(n.used.toLowerCase().contains(used[index])) notesFilteredUsed.add(n);
                        }
                    }
                    if (!notesFilteredUsed.isEmpty()) notesFiltered.addAll(notesFilteredUsed);
                    else notesFiltered.retainAll(notesFilteredUsed);
                    break;
                default:
                System.out.println("Необходимо выбрать цифру:");
                    break;
                }
                // выводим результаты фильтрации
                if (notesFiltered.isEmpty())System.out.println("Заданным критериям не соответсвует ни один ноутбук");
                else { System.out.println("Указанным критериям соответсвуют ноутбуки:");
                System.out.println(notesFiltered);

                System.out.println(msg[4]);
                // iSc.nextLine();
                String exitOrContinue = iSc.nextLine().trim().toLowerCase();
                if (exitOrContinue.equals("с")) notesFiltered.removeAll(notesFiltered);
                if (exitOrContinue.equals("e")) break;
            }
        }
    iSc.close();
    }
}
