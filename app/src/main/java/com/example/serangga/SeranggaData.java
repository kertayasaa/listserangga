package com.example.serangga;

import java.util.ArrayList;

public class SeranggaData {
    public static String[][] data = new String[][]{
            {"Kupu Kupu","Serangga 1","http://berkahkhair.com/wp-content/uploads/2016/03/Kupu-kupu.jpg"},
            {"Lalat","Serangga 2","http://berkahkhair.com/wp-content/uploads/2016/03/Lalat.jpg"},
            {"Capung","Serangga 3","http://berkahkhair.com/wp-content/uploads/2016/03/Capung.jpg"},
            {"Semut","Serangga 4","http://berkahkhair.com/wp-content/uploads/2016/03/semut-2.jpg"},
            {"Nyamuk","Serangga 5","http://berkahkhair.com/wp-content/uploads/2016/03/nyamuk-3.jpg"},
            {"Lebah","Serangga 6","http://berkahkhair.com/wp-content/uploads/2016/03/lebah-4.jpg"},
            {"Ngengat","Serangga 7","https://i1.wp.com/berkahkhair.com/wp-content/uploads/2016/03/Ngengat.jpg?w=750&ssl=1"},
            {"Kumbang Tanduk","Serangga 8","http://berkahkhair.com/wp-content/uploads/2016/03/Kumbang-Tanduk.jpg"}    };

    public static ArrayList<Serangga> getListData(){
        Serangga serangga = null;
        ArrayList<Serangga> list = new ArrayList<>();
        for (String[] aData : data) {
            serangga = new Serangga();
            serangga.setName(aData[0]);
            serangga.setRemarks(aData[1]);
            serangga.setPhoto(aData[2]);

            list.add(serangga);
        }

        return list;
    }
}
