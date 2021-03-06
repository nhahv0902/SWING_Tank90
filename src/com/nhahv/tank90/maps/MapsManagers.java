package com.nhahv.tank90.maps;

import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class MapsManagers {

    private ArrayList<ItemsMaps> mListMaps;

    public MapsManagers(int level) {
        mListMaps = new ArrayList<>();
        setListMaps("src/MAPS/map" + level);
    }

    private void setListMaps(String path) {

        File file = new File(path);
        try {
            FileInputStream input = new FileInputStream(file);
            BufferedReader buff = new BufferedReader(new InputStreamReader(input));

            String content;
            int row = 0, type;

            while ((content = buff.readLine()) != null) {
                for (int column = 0; column < content.length(); column++) {
                    type = Integer.parseInt(content.charAt(column) + "");
                    mListMaps.add(new ItemsMaps(column, row, Models.SIZE_ITEMS_MAPS, type));
                }
                row++;
            }
            buff.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ItemsMaps> getListMaps() {
        return mListMaps;
    }

    public void drawMaps(Graphics2D graphics2D) {

        for (ItemsMaps itemsMaps : mListMaps) {
            itemsMaps.draw(graphics2D);
        }
    }

    public int size() {
        return mListMaps.size();
    }

    public ItemsMaps getItems(int i) {
        return mListMaps.get(i);
    }
//    public void changeType(int orient, int x) {
//        mListMaps.get(x).setType(Models.TYPE_ITEMS_1);
//        if (orient == Models.UP || orient == Models.DOWN) {
//            mListMaps.get(x + 1).setType(Models.TYPE_ITEMS_1);
//        } else if (orient == Models.LEFT || orient == Models.RIGHT) {
//            mListMaps.get(x + 26).setType(Models.TYPE_ITEMS_1);
//        }
//    }
}
