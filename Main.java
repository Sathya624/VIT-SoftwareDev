import java.util.*;
import java.lang.Math;

class Main
{
	public static boolean runIsScored(float prob)
	{
		int n=(int) prob;
		Random random = new Random();
		if(random.nextInt(100)<=n)
			return true;
		else
			return false;
		
		
	}
	public static void main(String [] args)
	{
		
		
		// importing database
		
		// importing balls and modifier data
		Map<String, Float> ball=new HashMap<String, Float>();
		
		ball.put("Full toss", (float)4);
		ball.put("Yorker", (float)3);
		ball.put("Out-swinger",(float)3);
		ball.put("In-swinger",(float)2);
		ball.put("Bouncer", (float)4);
		ball.put("Slower Ball",(float)2);
		
		//Importing shot and modifier data
		Map <String, Float> shotMod=new HashMap<String, Float>();
		
		shotMod.put("Defend", (float)5);
		shotMod.put("Run",(float)7);
		shotMod.put("Run Fast", (float)6);
		shotMod.put("Cover Drive", (float)7);
		shotMod.put("On Drive",(float)5);
		shotMod.put("Straight Drive",(float)6);
		shotMod.put("Square Cut",(float)7);
		shotMod.put("Pull",(float)8);
		shotMod.put("Hook", (float)7);
		shotMod.put("Helicopter",(float)8);
		
		//Importing shot and possible runs data
		Map <String, Integer> shotRuns=new HashMap<String, Integer>();
		
		shotRuns.put("Defend", 0);
		shotRuns.put("Run",1);
		shotRuns.put("Run Fast", 2);
		shotRuns.put("Cover Drive", 2);
		shotRuns.put("On Drive",2);
		shotRuns.put("Straight Drive",2);
		shotRuns.put("Square Cut",4);
		shotRuns.put("Pull",4);
		shotRuns.put("Hook", 6);
		shotRuns.put("Helicopter",6);
		
		
		
		//linking balltype to possible shots
		
		String[] Full_toss= {"Defend", "Run", "Run Fast", "Square Cut", "Helicopter"};
		
		String[] Yorker= {"Defend", "Run", "Straight Drive", "Square Cut", "Hook"};
		String[] Out_swinger= {"Defend", "Run", "Cover Drive", "Pull", "Helicopter"};
		String[] In_swinger= {"Defend", "Run", "On Drive", "Pull", "Hook"};
		String[] Bouncer= {"Defend", "Run", "Cover Drive", "Pull", "Hook"};
		String[] Slower_Ball= {"Defend", "Run", "On Drive", "Pull", "Helicopter"};
		
		
		
	
	
	
		
		//taking input for mode
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Select Mode: "+"\n"+"Enter PvE or PvP :");
		String mode=sc.next();
		
		//random number generator
		Random rand = new Random();
		System.out.println(ball.get("Slower ball"));
		
			//selcting random bowler
			if(rand.nextInt(2)==1)
			{
				//then bowler is passive.
				
				//boosting the modifiers.
				
				ball.replace("Slower ball",ball.get("Slower ball")+ 0.2f*ball.get("Slower ball"));
				ball.replace("Bouncer",ball.get("Bouncer")+ 0.2f*ball.get("Bouncer"));
				ball.replace("Out-swinger",ball.get("Out-swinger")+ 0.2f*ball.get("Out-swinger"));
				
				
			}
			else 
			{
				//then the bowler is agressive
				//boosting the modifiers
				ball.replace("Full Toss",ball.get("Full Toss")+ 0.2f*ball.get("Full Toss"));
				ball.replace("In-swinger",ball.get("In-swinger")+ 0.2f*ball.get("In-swinger"));
			}
			
			//selecting batsmen type
			System.out.println("Enter the type of Batsmen(Passive or Agressive: ");
			
			String bat_type=sc.next();
			if(bat_type=="Passive") {
				shotMod.replace("Defend",shotMod.get("Defend")+0.2f*shotMod.get("Defend"));
				shotMod.replace("Run", 1.02f*shotMod.get("Run"));
				shotMod.replace("Run Fast", 1.02f*shotMod.get("Run Fast"));
				shotMod.replace("Cover Drive", 1.02f*shotMod.get("Cover Drive"));
				shotMod.replace("On Drive", 1.02f*shotMod.get("On Drive"));
				shotMod.replace("Straight Drive", 1.02f*shotMod.get("Straight Drive"));
			}
			else if(bat_type=="Agressive")
			{
				shotMod.replace("Pull", 1.02f*shotMod.get("Pull"));
				shotMod.replace("Hook", 1.02f*shotMod.get("Hook"));
				shotMod.replace("Helicopter", 1.02f*shotMod.get("Helicopter"));
				shotMod.replace("Square Cut", 1.02f*shotMod.get("Square Cut"));
			}
			
			int current_runs=0;
			int runs_scored_on_thisball=0;
			Float prob=0f;
		
			
			//for level 1
			for(int i=0;i<6;i++)
			{
				String balltype="";
				//selecting random ball;
				
				int r=rand.nextInt(4);
				if(r==0)
				{
					balltype="Slower ball";
					System.out.println("Current ball is :"+balltype);
					System.out.println("Enter one of the following shots: ");
					for(int l=0;l<5;l++)
					{
						System.out.print(Slower_Ball[l]+" ");
						System.out.print(Slower_Ball[l]+"--");
						prob=(shotMod.get(Slower_Ball[l])-ball.get("Slower Ball"))/100;
						
						System.out.print(shotRuns.get(Slower_Ball[l])+"--"+prob);
					}
					
					
				}
				else if(r==1)
				{
					balltype="Bouncer";
					System.out.println("Current ball is :"+balltype);
					System.out.println("Enter one of the following shots: ");
					for(int l=0;l<5;l++)
					{
						System.out.print(Bouncer[l]+"--");
						prob=(shotMod.get(Bouncer[l])-ball.get("Bouncer"))/100;
						System.out.print(shotRuns.get(Bouncer[l])+"--"+prob);
					}
					
				
				}
				else if(r==2)
				{
					balltype="Out-swinger";
					System.out.println("Current ball is :"+balltype);
					System.out.println("Enter one of the following shots: ");
					for(int l=0;l<5;l++)
					{
						System.out.print(Out_swinger[l]+"--");
						System.out.print(Out_swinger[l]+"--");
						prob=(shotMod.get(Out_swinger[l])-ball.get("Out-swinger"))/100;
						System.out.print(shotRuns.get(Out_swinger[l])+"--"+prob);
					}
					
				}
				else if(r==3)
				{
					balltype="Full Toss";
					System.out.println("Current ball is :"+balltype);
					System.out.println("Enter one of the following shots: ");
					for(int l=0;l<5;l++)
					{
						System.out.print(Full_toss[l]+" ");
						System.out.print(Full_toss[l]+"--");
						prob=(shotMod.get(Full_toss[l])-ball.get("Out-swinger"))/100;
						System.out.print(shotRuns.get(Full_toss[l])+"--"+prob);
					}
					
				}
				else 
				{
					balltype="In-swinger";
					System.out.println("Current ball is :"+balltype);
					System.out.println("Enter one of the following shots: ");
					for(int l=0;l<5;l++)
					{
						System.out.print(In_swinger[l]+" ");
						System.out.print(In_swinger[l]+"--");
						prob=(shotMod.get(In_swinger[l])-ball.get("Out-swinger"))/100;
						System.out.print(shotRuns.get(In_swinger[l])+"--"+prob);
					}
				}
				
				String selected_shot=sc.next();
				
				prob=(shotMod.get(selected_shot)-ball.get(balltype))/100;
				
				if(runIsScored(prob))
				{
					current_runs=current_runs+shotRuns.get(selected_shot);
					runs_scored_on_thisball=shotRuns.get(selected_shot);
					
				}
				System.out.println("current runs :"+current_runs);
				System.out.println("runs on last ball :"+runs_scored_on_thisball);
				
				
				
			}
	}
	
	
}
