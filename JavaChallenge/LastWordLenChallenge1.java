package JavaChallenge;

public class LastWordLenChallenge1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text="luffy is still joyboy";
		String[] splittext = text.split(" ");
		int length=0;
		
		//System.out.println(splittext.length);
		for (int i = 0; i < splittext.length; i++) {
			if(i==splittext.length-1)
			{
			char[] splittexttocharArray = splittext[i].toCharArray();
			length = splittexttocharArray.length;
			
			}
			else
			{
				continue;
			}
		}
		System.out.println("Lenght of last word: "+length);

	}

}
