package org.example;

import java.io.*;
import java.util.ArrayList;

public class TxtRead {

    public String path;
    ArrayList<String> packet = new ArrayList<>();
    //public String[] input_arr = new String[packet.size()];
    BufferedReader br = null;

    public ArrayList<String> run(String path) {


        try {
            br = new BufferedReader(new FileReader(new File(path)));
            String s;

            while (( s = br.readLine()) != null) {
                packet.add(s);
            }
            //input_arr = packet.toArray(input_arr);

            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if( br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
        System.out.println("input arr: " +packet);
        return packet;

    }

}