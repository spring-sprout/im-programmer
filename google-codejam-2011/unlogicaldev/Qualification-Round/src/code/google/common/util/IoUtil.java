package code.google.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.Map.Entry;

public class IoUtil {

	public static List<String> readInputFile(String file){
		List<String> list = new ArrayList<String>();
				try{
					String configFilePath = file;
					InputStreamReader ir = new InputStreamReader(new FileInputStream(configFilePath), "UTF-8");
			        BufferedReader in = new BufferedReader(ir);
			        String s = "";
			        s = in.readLine().trim();
			        int cnt = Integer.parseInt(s);
			        for(int i =0; i<cnt; i++){
			        	s = in.readLine().trim();
			        	System.out.println(s);
			        	list.add(s);
			        }
				}catch(Exception e){
					e.printStackTrace();
				}
		return list;
		
	}
	
	public static void txtFileOut(SortedMap<Integer, String> output, String fileName){
		try {
		      ////////////////////////////////////////////////////////////////
		      BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

		      Iterator<Entry<Integer, String>> it = output.entrySet().iterator();
		      Entry<Integer, String> et;
		      while(it.hasNext()){
				et = it.next();
				out.write("Case #"+et.getKey()+": "+et.getValue());
				out.newLine();
		      }

		      out.close();
		      ////////////////////////////////////////////////////////////////
		    } catch (IOException e) {
		        System.err.println(e); // 에러가 있다면 메시지 출력
		        System.exit(1);
		    }
	}
}
