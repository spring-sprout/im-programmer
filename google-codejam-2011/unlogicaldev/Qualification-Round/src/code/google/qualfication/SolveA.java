package code.google.qualfication;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import code.google.common.abs.AbstractSolve;

public class SolveA extends AbstractSolve {
	
	public SolveA(String input,int seq){
		super(input, seq);
	}

	@Override
	public void solve() {
		List<Integer> listKey = new ArrayList<Integer>();
		List<String> listRobot = new ArrayList<String>();
		List<Integer> listRobotO = new ArrayList<Integer>();
		List<Integer> listRobotB = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(input);
		int cnt = Integer.parseInt(st.nextToken());
		
		String robot = "";
		int level = 0;
		int lastLevel = 0;
		
		while(st.hasMoreTokens()){
			robot = st.nextToken().trim();
			level = Integer.parseInt(st.nextToken().trim());

			listKey.add(level);
			listRobot.add(robot);
			if(level > lastLevel) lastLevel = level;
			if(robot.equals("O")) listRobotO.add(level);
			else listRobotB.add(level);
		}
		
		level = 0;
		int time = 0, rOr = 0, rBr = 0;
		int rO = 1, lO = 0, rB = 1, lB = 0;
		
		if(listRobotO.size() > 0){
			rOr = listRobotO.get(0);
			listRobotO.remove(0);
		}
		else lO = 2;
		
		if(listRobotB.size() > 0){
			rBr = listRobotB.get(0);
			listRobotB.remove(0);
		}
		else lB = 2;
		
		
		
		int key = listKey.get(level);
		String val = listRobot.get(level);
		while(cnt > level){
			time ++;
			if(val.equals("O")){
				if(key == rO){
						lO = 0;
						level ++;
						if(cnt > level){ 
							key = listKey.get(level);
							val = listRobot.get(level);
						}
						if(listRobotO.size() > 0){
							rOr = listRobotO.get(0);
							listRobotO.remove(0);
						}
						else lO = 2;
				}else if(key > rO){
					rO ++;
				}else {
					rO --;
				}
				
				if(rBr == rB){
					//stay
				}else if(rBr > rB){
					rB ++;
				}else{
					rB --;
				}
			}else{
				if(key == rB){
						lB = 0;
						level ++;
						if(cnt > level){
							key = listKey.get(level);
							val = listRobot.get(level);
						}
						if(listRobotB.size() > 0){
							rBr = listRobotB.get(0);
							listRobotB.remove(0);
						}
						else lB = 2;
				}else if(key > rB){
					rB ++;
				}else {
					rB --;
				}

				if(rOr == rO){
					//stay
				}else if(rOr > rO){
					rO ++;
				}else{
					rO --;
				}
			}
		}
		ProblemA.setOutPut(seq, time+"");
	}

}
