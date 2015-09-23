package processes;

import java.util.HashMap;

public class CharPairScore {
    //` 1 2 3 4 5 6 7 8 9 0 - =
	//   q w e r t y u i o p [ ] \ 
	//    a s d f g h j k l ; '
	//     z x c v b n m , . /
	//        s p a c e b a r
	public HashMap<String,String> keyMap = new HashMap<String,String>();
	
	public CharPairScore(){
		//setting up a keyboard layout to auto generate key separations, a graph structure would be better
		//for a more complicated scoring method, but i'm only discounting mismatches for keys that are one spot away
		String[][] keyboard = new String[][]{{"`~","1!","2@","3#","4$","5%","6^","7&","8*","9(","0)","-_","=+",null,null,null},
				{null,null,"q","w","e","r","t","y","u","i","o","p","[{","]}","\\|",null},
				{null,null,null,"a","s","d","f","g","h","j","k","l",";:","\'\"",null,null},
				{null,null,null,null,"z","x","c","v","b","n","m",",<",".>","/?",null,null},
				{null,null,null,null,null,null," "," "," "," "," "," "," "," "," ",null}};
		//from the keyboard layout we build a map for speed
		for(int x=0;x<5;x++){
			for(int y=0;y<15;y++){
				if(keyboard[x][y]==null){
					continue;
				}
				String closeKeys = "";
				//go to each key around our current target key to build a list of all close keys
				for(int row=-1;row<=1;row++){
					for(int column=-1;column<=1;column++){
						//move on if we're at x,y, out of bounds or if the target location is null
						if((row==0&&column==0)||x+row>4||x+row<0||y+column>15||y+column<0||keyboard[x+row][y+column]==null){
							continue;
						}
						closeKeys = closeKeys+keyboard[x+row][y+column];
					}
				}
				//add the key to the map, for keys with more than one value add a key,value pair for each symbol
				if(keyboard[x][y].length()>1){
					String key1 = keyboard[x][y].substring(0, 1);
					String key2 = keyboard[x][y].substring(1, 2);
					keyMap.put(key1, closeKeys);
					keyMap.put(key2, closeKeys);
				}else {
					keyMap.put(keyboard[x][y], closeKeys);
				}
			}
		}
	}
	//given two characters find how close they are, perfect matches are worth 0, close matches are 1 and everything else is 3
	public Integer getScore(String char1, String char2){
		if(char1.toLowerCase().equals(char2.toLowerCase())){
			return 0;
		}
		if (keyMap.get(char1.toLowerCase()).contains(char2.toLowerCase())){
			return 1;
		}
		return 3;
	}
}
