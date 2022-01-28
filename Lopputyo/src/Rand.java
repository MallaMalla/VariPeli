import java.util.Random;
import java.awt.Color;

public class Rand 
{
	
	public Color RandomColor()
	{
		Color colors[] = {Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN};
		Color rCol = (colors[new Random().nextInt(colors.length)]);
		
		return rCol;
	}
	
	public String RandomText()
	{
		String texts[] = {"PUNAINEN" , "SININEN" , "VIHREÄ" , "ORANSSI"};
		String rText = (texts[new Random().nextInt(texts.length)]);
		
		return rText;
	}

	public Color GetColbyName(String colName)
	{
		Color color = Color.BLACK;
		
		switch(colName)
		{
			case "PUNAINEN":
				color = Color.RED;
				break;
			
			case "SININEN":
				color = Color.BLUE;
				break;
			
			case "VIHREÄ":
				color = Color.GREEN;
				break;
			
			case "ORANSSI":
				color = Color.ORANGE;
				break;
		}
		return color;
	}
}