package code.google.qualfication;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import code.google.common.abs.AbstractSolve;

public class SolveB extends AbstractSolve {
	
	public SolveB(String input,int seq){
		super(input, seq);
	}

	@Override
	public void solve() {
		List<String> listA = new ArrayList<String>();
		List<String> listB = new ArrayList<String>();
		String str = "";

		StringTokenizer st = new StringTokenizer(input);
		int cnt = Integer.parseInt(st.nextToken());
		
		String token = "";
		for(int i=0; i<cnt; i++){
			token = st.nextToken();
			listA.add(token);
		}
		
		cnt = Integer.parseInt(st.nextToken());
		
		token = "";
		for(int i=0; i<cnt; i++){
			listB.add(st.nextToken());
		}

		cnt = Integer.parseInt(st.nextToken());
		
		str = st.nextToken();
		
		for(String s:listB){
			String key = s;
			if(str.indexOf(key) > -1){
				str = str.replaceAll(key,"");
			}
		}
		
		for(String s:listB){
			String key = s;
			Pattern p = Pattern.compile(key.substring(0,1)+".*"+key.substring(1));
			Matcher m = p.matcher(str);
			str = m.replaceAll("");
		}
		
		for(String s:listA){
			String key = s.substring(0,2);
			String val = s.substring(2);
			String rKey = key.substring(1)+key.substring(0,1);
			if(str.indexOf(key) > -1 && str.indexOf(rKey) > -1){
				if(str.indexOf(key)  < str.indexOf(rKey)){
					str = str.replaceAll(key,val);
					str = str.replaceAll(rKey,val);
				}else{
					str = str.replaceAll(rKey,val);
					str = str.replaceAll(key,val);
				}
			}else{
				str = str.replaceAll(key,val);
				str = str.replaceAll(rKey,val);
			}
		}
		
		System.out.println("["+makeString(str)+"]");
		ProblemB.setOutPut(seq, "["+makeString(str)+"]");
	}
	
	private String makeString(String str){
		StringBuffer sb = new StringBuffer();
		char[] ss = str.toCharArray();
		int cnt = 0;
		for(char b :ss){
			cnt++;
			sb.append(new String(new char[]{b}));
			if(cnt < str.length()) sb.append(", ");
		}
		
		return sb.toString();
	}

}
