package code.google.qualfication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import code.google.common.util.IoUtil;

public class ProblemB {

	private static List<String> prob = new ArrayList<String>();
	private static SortedMap<Integer, String> output = new TreeMap<Integer, String>();
	final static String input = "/Users/pgmnle/dev/google_code_jam_2011/input_B.txt";
	//final static String input = "";
	
	public static void setOutPut(int seq, String out){
		output.put(seq+1, out);
	}
	public static void main(String arg[]) throws Exception{
		
		//read input files
		prob = IoUtil.readInputFile(input);
		int i = 0;
		//TODO solve problem.
		for(String s:prob){
			Thread t = new Thread(new SolveB(s,i));
			t.start();
			i ++;
		}
		
		while(output.size() != prob.size()){
			Thread.sleep(500);
		}

		IoUtil.txtFileOut(output, "/Users/pgmnle/dev/google_code_jam_2011/output_q_pB_s.txt");
		
	}
}
