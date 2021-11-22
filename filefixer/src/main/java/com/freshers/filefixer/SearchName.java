package com.freshers.filefixer;

import java.util.ArrayList;

public class SearchName implements Search {

    @Override
    public int search(String key, ArrayList<PDF> files) {
        int index = 0, ind = 0, check = 0;
        String regex = "(?i)(.*[^\\p{Alpha}])?" + key.replaceAll("\\s", "([^\\p{Alpha}]?)") + ".*";
        for (PDF pdf : files) {
            if (pdf.getName().matches(regex)) {
                ind = index;
                check++;
            }
            index++;
        }

        if (check > 1) {
            return -2;
        } else if (check == 1) {
            return ind;
        } else {
            return -1;
        }
    }

}
